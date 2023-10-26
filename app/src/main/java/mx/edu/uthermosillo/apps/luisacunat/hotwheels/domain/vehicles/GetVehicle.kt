package mx.edu.uthermosillo.apps.luisacunat.hotwheels.domain.vehicles

import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.repositories.VehiclesRepository

class GetVehicle {

    private val repository = VehiclesRepository()

    suspend operator fun invoke(vehicle_id: Int) =
        repository.getVehicle(vehicle_id)
}