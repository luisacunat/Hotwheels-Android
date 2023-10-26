package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.R
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.vehicles.Vehicle
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.databinding.ItemVehicleBinding
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.vehicles.VehiclesFragmentDirections


class VehiclesAdapter(private val vehicles : List<Vehicle>) :
    RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VehiclesViewHolder(layoutInflater.inflate(
            R.layout.item_vehicle,
        parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.render(vehicles[position])

        val vehicle : Vehicle = vehicles[position]
        val binding = ItemVehicleBinding.bind(holder.itemView)

        binding.textView.text = vehicle.name
        Picasso.get().load(vehicle.image).into(binding.imageView)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    class VehiclesViewHolder(view: View, ct: Context) :
        RecyclerView.ViewHolder(view) {

        private val binding = ItemVehicleBinding.bind(view)
        private val context = ct

        fun render(vehicle: Vehicle) {

            binding.vehicleCard.setOnClickListener {
                //Toast.makeText(context, "Brand :" + vehicle.brand.name, Toast.LENGTH_SHORT).show()
                val navController : NavController =
                    Navigation.findNavController(binding.root)

                val action =
                    VehiclesFragmentDirections.actionVehiclesFragmentToVehicleFragment(vehicle.id)
                navController.navigate(action)
            }
        }
    }
}