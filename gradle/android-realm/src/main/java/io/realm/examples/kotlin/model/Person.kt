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

package io.realm.examples.kotlin.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

/* Your model has to extend RealmObject.
   Class and all of the properties must be annotated with 'open' (as classes and functions are final by default).

   You can put properties in the constructor as long as all of them are initialized with
   default values. This ensures that an empty constructor is generated.
   All properties are persisted by default. Properties can be annotated with PrimaryKey or Index.
*/
open class Person(
        @PrimaryKey 
        open var name: String = "",

        open var age: Int = 0,

        // Other objects in a one-to-one relation must also subclass RealmObject
        open var dog: Dog? = null,

        // One-to-many relations is simply a RealmList of the objects which also subclass RealmObject
        open var cats: RealmList<Cat> = RealmList(),

        // You can instruct Realm to ignore a field and not persist it.
        @Ignore
        open var tempReference: Int = 0,

        open var id: Long = 0
) : RealmObject()