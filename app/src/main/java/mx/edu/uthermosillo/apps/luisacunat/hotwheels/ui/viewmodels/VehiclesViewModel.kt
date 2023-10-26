package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.domain.vehicles.GetAllVehicles
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.Vehicle
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.domain.vehicles.GetVehicle

class VehiclesViewModel : ViewModel() {

    val vehicles = MutableLiveData<List<Vehicle>>()
    val vehicle = MutableLiveData<Vehicle>()
    val isLoading = MutableLiveData<Boolean>()

    var getAllVehicles = GetAllVehicles()
    var getVehicle = GetVehicle()

    fun loadVehicle(vehicle_id: Int) {
        viewModelScope.launch {
            val result = getVehicle.invoke(vehicle_id)
            isLoading.postValue(true)
            vehicle.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun loadVehicles() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAllVehicles()

            if(!result.isNullOrEmpty()) {
                vehicles.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}