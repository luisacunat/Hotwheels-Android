package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles

import com.google.gson.annotations.SerializedName
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.brands.Brand
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.countries.Country
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.types.Type

data class Vehicle(
    @SerializedName("year") val year: Int,
    @SerializedName("brand") val brand: Brand,
    @SerializedName("name") val name: String,
    @SerializedName("engine") val engine: Int,
    @SerializedName("image") val image: String,
    @SerializedName("type") val type: Type,
    @SerializedName("created_at") val created: String,
    @SerializedName("id") val id: Int
)
