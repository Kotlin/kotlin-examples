/*
 * Copyright 2015 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.examples.kotlin

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.Sort
import io.realm.examples.kotlin.model.Cat
import io.realm.examples.kotlin.model.Dog
import io.realm.examples.kotlin.model.Person
import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.activity_realm_basic_example.*

class KotlinExampleActivity : Activity() {
    private companion object {
        val TAG = KotlinExampleActivity::class.java.name
    }

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm_basic_example)

        // This example uses Kotlin Android Extensions plugin
        container.removeAllViews()

        realm = Realm.getInstance(RealmConfiguration.Builder(this).build())
        with (realm) {
            // These operations are small enough that we can safely run them on the UI thread
            basicCRUD()
            basicQuery()
            basicLinkQuery()
        }

        val realmConfig = realm.configuration
        // More complex operations can be executed on another thread
        async() {
            fun realmInstance() = Realm.getInstance(realmConfig)
            var info = complexReadWrite(realmInstance()) + complexQuery(realmInstance())

            uiThread { act ->
                act.log(info)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun Realm.basicCRUD() {
        log("Perform basic Create/Read/Update/Delete (CRUD) operations...")

        // Add new person
        executeTransaction {
            realm.createObject(Person::class.java).apply {
                id = 1
                name = "Young Person"
                age = 14
            }
        }

        // Simple lookup
        val person = realm.where(Person::class.java).findFirst()
        log(person.name + ": " + person.age)

        // Modify person entry
        executeTransaction {
            person.name = "Senior Person"
            person.age = 40
            log(person.name + " got older: " + person.age)
        }

        // Remove all users
        executeTransaction {
            allObjects(Person::class.java).clear()
        }
    }

    private fun Realm.basicQuery() {
        log("\nPerforming basic Query operation...")
        log("Number of people: ${allObjects(Person::class.java).size}")

        val results = where(Person::class.java).equalTo("age", 99).findAll()

        log("Size of result set: " + results.size)
    }

    private fun Realm.basicLinkQuery() {
        log("\nPerforming basic Link Query operation...")
        log("Number of people: ${allObjects(Person::class.java).size}")

        val results = where(Person::class.java).equalTo("cats.name", "Tiger").findAll()

        log("Size of result set: ${results.size}")
    }

    private fun log(text: String) {
        Log.i(TAG, text)

        val textView = TextView(this)
        textView.text = text
        container.addView(textView)
    }
}

private fun complexReadWrite(realm: Realm): String {
    return StringBuilder().apply {
        append("\nPerforming complex Read/Write operation...")

        realm.use { realm ->
            realm.executeTransaction(::addTenPeople)

            append("\nNumber of people: ${realm.allObjects(Person::class.java).size}")

            // Iterate over all objects
            for (person in realm.allObjects(Person::class.java)) {
                val dogName: String = person?.dog?.name ?: "None"

                append("\n${person.name}: ${person.age} : $dogName : ${person.cats.size}")

                // The field tempReference is annotated with @Ignore
                // Though we initially set its value to 42, it has
                // not been saved as part of the Person RealmObject:
                check(person.tempReference == 0)
            }

            // Sorting
            val sortedPersons = realm.allObjects(Person::class.java)
            sortedPersons.sort("age", Sort.DESCENDING)
            check(realm.allObjects(Person::class.java).last().name == sortedPersons.first().name)

            append("\nSorting ${sortedPersons.last().name} == ${realm.allObjects(Person::class.java).first().name}")
        }
    }.toString()
}

private fun addTenPeople(realm: Realm) {
    val fido = realm.createObject(Dog::class.java)
    fido.name = "fido"

    for (ageIndex in 0..9) {
        val person = realm.createObject(Person::class.java).apply {
            id = ageIndex.toLong()
            name = "Person no. $ageIndex"
            age = ageIndex
            dog = fido
        }

        // The field 'tempReference' is annotated with @Ignore.
        // This means it is not saved as part of the RealmObject.
        person.tempReference = 42

        for (j in 0..ageIndex - 1) {
            val cat = realm.createObject(Cat::class.java)
            cat.name = "Cat_$j"
            person.cats.add(cat)
        }
    }
}

private fun complexQuery(realm: Realm) = StringBuilder("\n\nPerforming complex Query operation...").apply {
    realm.use { realm ->
        append("\nNumber of people: ").append(realm.allObjects(Person::class.java).size)

        val results = realm.where(Person::class.java)
                .between("age", 7, 9)
                .beginsWith("name", "Person")
                .findAll()

        append("\nSize of result set: ").append(results.size)
    }
}.toString()
