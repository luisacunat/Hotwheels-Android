package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.network.vehicles

import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.Vehicle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VehicleApiClient {

    @GET("vehicles")
    suspend fun getAllVehicles() : Response<List<Vehicle>>

    @GET("vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: Int) : Response<Vehicle>
}