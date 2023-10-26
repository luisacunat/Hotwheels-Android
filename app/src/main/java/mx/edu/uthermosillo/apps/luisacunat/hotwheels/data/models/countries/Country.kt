package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.countries

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") val name: String,
    @SerializedName("flag") val flag: String,
    @SerializedName("id") val id: Int
)
