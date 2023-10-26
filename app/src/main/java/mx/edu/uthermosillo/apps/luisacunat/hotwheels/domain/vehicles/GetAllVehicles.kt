package mx.edu.uthermosillo.apps.luisacunat.hotwheels.domain.vehicles

import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.repositories.VehiclesRepository

class GetAllVehicles {

    private val repository = VehiclesRepository()

    suspend operator fun invoke() = repository.getAllVehicles()
}