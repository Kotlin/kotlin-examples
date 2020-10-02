package examples.querydsl

import com.querydsl.jpa.impl.JPAQuery

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

import examples.querydsl.QUser.user
import org.junit.Assert
import org.junit.Test

class PersistenceTest {

    @Test
    fun shouldSaveAndRetrieveEntity() {
        Persistence.createEntityManagerFactory("unit").use { emf ->
            emf.createEntityManager().use { entityManager ->
                val transaction = entityManager.transaction
                transaction.begin()

                with(entityManager) {
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
                        .fetchCount()

                Assert.assertEquals(2, uniqueUserNames)
            }
        }
    }
}

inline fun <T> EntityManagerFactory.use(f: (EntityManagerFactory) -> T) = try { f(this) } finally { close() }
inline fun <T> EntityManager.use(f: (EntityManager) -> T) = try { f(this) } finally { close() }
