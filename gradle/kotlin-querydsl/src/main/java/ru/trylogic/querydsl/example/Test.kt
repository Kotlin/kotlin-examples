package ru.trylogic.querydsl.example

import com.querydsl.jpa.impl.JPAQuery
import ru.trylogic.querydsl.example.QUser.user
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Test {
    @JvmStatic
    fun main(args: Array<String>) = Persistence.createEntityManagerFactory("unit").use { emf ->
        emf.createEntityManager().use { entityManager ->
            val transaction = entityManager.transaction
            transaction.begin()

            with (entityManager) {
                persist(User("Smith"))
                persist(User("Gates"))
                persist(User("Orlov"))
                persist(User("Smirnov"))
                persist(User("Orlov"))

                flush()
            }

            transaction.commit()

            val query = JPAQuery<User>(entityManager)

            val uniqueUserNames = query.from(user)
                    .where(user.name.like("%ov"))
                    .groupBy(user.name)
                    .select(user.name)
                    .fetch()

            println("Unique names: ")
            uniqueUserNames.forEach { println(it) }
        }
    }
}

inline fun <T> EntityManagerFactory.use(f: (EntityManagerFactory) -> T) = try { f(this) } finally { close() }

inline fun <T> EntityManager.use(f: (EntityManager) -> T) = try { f(this) } finally { close() }