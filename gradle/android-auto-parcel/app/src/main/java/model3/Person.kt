package model3

import com.google.auto.value.AutoValue

import android.os.Parcelable

import model1.HeightBucket
import model2.Address

@AutoValue
abstract class Person : Parcelable {
    abstract fun name(): String
    abstract fun id(): Long
    abstract fun heightType(): HeightBucket
    abstract fun addresses(): MutableMap<String, Address>
    abstract fun friends(): MutableList<Person>

    @AutoValue.Builder
    interface Builder {
        fun name(s: String): Builder
        fun id(n: Long): Builder
        fun heightType(x: HeightBucket): Builder
        fun addresses(x: MutableMap<String, Address>): Builder
        fun friends(x: MutableList<Person>): Builder
        fun build(): Person
    }

    companion object {
        fun create(name: String,
                   id: Long,
                   heightType: HeightBucket,
                   addresses: Map<String, Address>,
                   friends: List<Person>
        ) = builder()
                .name(name)
                .id(id)
                .heightType(heightType)
                .addresses(addresses as? MutableMap<String, Address> ?: addresses.toMutableMap())
                .friends(friends as? MutableList<Person> ?: friends.toMutableList())
                .build()

        fun builder(): Builder = `$AutoValue_Person`.Builder()
    }
}
