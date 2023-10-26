package mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.repositories

import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.VehicleProvider
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.network.vehicles.VehicleService
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.Vehicle
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.VehiclesProvider

class VehiclesRepository {

    private val api = VehicleService()

    suspend fun getAllVehicles() : List<Vehicle> {
        val response = api.getVehicles()
        VehiclesProvider.vehicles = response
        return response
    }

    suspend fun getVehicle(vehicle_id: Int) : Vehicle {
        val response = api.getVehicle(vehicle_id)
        VehicleProvider.vehicle = response
        return response
    }
}