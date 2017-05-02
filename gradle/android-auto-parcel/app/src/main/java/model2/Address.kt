package model2

import com.google.auto.value.AutoValue

import android.os.Parcelable

@AutoValue
abstract class Address : Parcelable {
    abstract fun coordinates(): DoubleArray
    abstract fun cityName(): String

    @AutoValue.Builder
    interface Builder {
        fun coordinates(x: DoubleArray): Builder
        fun cityName(x: String): Builder
        fun build(): Address
    }

    companion object {
        fun create(coordinates: DoubleArray, cityName: String): Address {
            return builder().coordinates(coordinates).cityName(cityName).build()
        }

        fun builder(): Builder = `$AutoValue_Address`.Builder()
    }

}
