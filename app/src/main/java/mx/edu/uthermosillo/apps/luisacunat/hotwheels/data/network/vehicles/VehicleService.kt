package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.network.vehicles

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.core.RetrofitHelper
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.Vehicle

class VehicleService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getVehicles() : List<Vehicle> {

        return withContext(Dispatchers.IO) {
            val response = retrofit.create(
                VehicleApiClient::class.java)
                .getAllVehicles()
            response.body() ?: emptyList()
        }
    }

    suspend fun getVehicle(vehicle_id: Int) : Vehicle {

        return withContext(Dispatchers.IO) {
            val response = retrofit.create(
                VehicleApiClient::class.java)
                .getVehicle(vehicle_id)
            response.body()!!
        }
    }
}