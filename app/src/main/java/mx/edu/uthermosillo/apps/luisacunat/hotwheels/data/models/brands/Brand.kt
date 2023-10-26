package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.brands

import com.google.gson.annotations.SerializedName
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.countries.Country

data class Brand (
    @SerializedName("name") val name: String,
    @SerializedName("country") val country: Country,
    @SerializedName("moto") val moto: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("status") val status: Int,
    @SerializedName("created_at") val since: String,
    @SerializedName("id") val id: Int
)