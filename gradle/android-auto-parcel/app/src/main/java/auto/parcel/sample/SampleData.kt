package auto.parcel.sample

import java.util.Arrays
import java.util.Collections
import java.util.HashMap

import model1.HeightBucket
import model2.Address
import model3.Person

interface SampleData {
    companion object {
        val ALICE = Person.create("Alice", 1L, HeightBucket.AVERAGE,
                addresses = hashMapOf("home" to Address.create(doubleArrayOf(0.3, 0.7), "Rome")),
                friends = emptyList<Person>())

        val BOB = Person.builder()
                .name("Bob")
                .id(2L)
                .heightType(HeightBucket.TALL)
                .addresses(hashMapOf(
                        "home" to Address.create(doubleArrayOf(3.2, 143.2), "Turin"),
                        "work" to Address.create(doubleArrayOf(5.9, 156.1), "Genoa")))
                .friends(Arrays.asList(ALICE)).build()
    }
}
