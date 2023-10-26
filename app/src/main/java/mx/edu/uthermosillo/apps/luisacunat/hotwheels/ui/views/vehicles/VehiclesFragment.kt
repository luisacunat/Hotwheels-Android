package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.vehicles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.viewmodels.VehiclesViewModel
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.databinding.FragmentVehiclesBinding
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.adapters.VehiclesAdapter

class VehiclesFragment : Fragment() {

    private var _binding: FragmentVehiclesBinding? = null
    private val binding get() = _binding!!

    private val vehiclesViewModel : VehiclesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentVehiclesBinding.inflate(inflater, container, false)

        vehiclesViewModel.loadVehicles()

        vehiclesViewModel.vehicles.observe(viewLifecycleOwner, Observer {
            vehicles ->
            binding.vehiclesRecycler.layoutManager = LinearLayoutManager(context)
            val adapter = VehiclesAdapter(vehicles)
            binding.vehiclesRecycler.adapter = adapter

            if(vehicles.isNotEmpty()) {
                binding.vehiclesShimmer.visibility = View.GONE
                binding.vehiclesRecycler.visibility = View.VISIBLE
            }
         })

        vehiclesViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.vehiclesShimmer.isVisible = it
        })

        return binding.root
    }
}