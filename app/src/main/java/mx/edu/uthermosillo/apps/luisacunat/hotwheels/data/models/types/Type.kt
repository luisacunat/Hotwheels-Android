package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.types

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name") val name: String,
    @SerializedName("doors") val doors: Int,
    @SerializedName("isConvertible") val convertible: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("created_at") val created: String,
    @SerializedName("id") val id: Int
    )
