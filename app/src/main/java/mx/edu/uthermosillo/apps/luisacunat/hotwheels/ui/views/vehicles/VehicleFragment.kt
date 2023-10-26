package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.vehicles

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.databinding.FragmentVehicleBinding
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.viewmodels.VehiclesViewModel
import okhttp3.internal.wait

class VehicleFragment : Fragment() {

    private var _binding: FragmentVehicleBinding? = null
    private val binding get() = _binding!!

    private val vehiclesViewModel : VehiclesViewModel by viewModels()
    private var vehicleId = 0
    private val args: VehicleFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentVehicleBinding.inflate(inflater, container, false)
        vehicleId = args.vehicleId

        vehiclesViewModel.loadVehicle(vehicleId)

        vehiclesViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.vehiclesShimmer.isVisible = it
            binding.content.isVisible = !it
        })

        vehiclesViewModel.vehicle.observe(viewLifecycleOwner, Observer {
            vehicle ->
            binding.brandName.text = vehicle.brand.name
            binding.modelName.text = vehicle.name
            binding.vehicleType.text = vehicle.type.name
            binding.vehicleYear.text = vehicle.year.toString()
            binding.vehicleDoors.text = vehicle.type.doors.toString()
            binding.vehicleBrandCountry.text = vehicle.brand.country.name

            Picasso.get().load(vehicle.image).into(binding.vehicleImage)
            Picasso.get().load(vehicle.brand.logo).into(binding.brandLogo)
            Picasso.get().load(vehicle.brand.country.flag).into(binding.brandCountryFlag)
        })

        return binding.root
    }
}