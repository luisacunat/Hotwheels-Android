package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.Dashboard
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.R
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.databinding.ItemDashboardBinding

class DashboardAdapter(private var options: List<Dashboard>):
    RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return DashboardViewHolder(layoutInflater.inflate(
            R.layout.item_dashboard,
        parent, false))
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.render(options[position])

        val options : Dashboard = options[position]
        val binding = ItemDashboardBinding.bind(holder.itemView)

        binding.dashboardCard.setOnClickListener {

            val navController : NavController =
                Navigation.findNavController(holder.itemView)

            when(options.id) {
                1 -> {
                    navController.navigate(R.id.action_dashboardFragment_to_vehiclesFragment)
                }
                2-> {
                    navController.navigate(R.id.action_dashboardFragment_to_vehiclesFragment)
                }
                3 -> {
                    navController.navigate(R.id.action_dashboardFragment_to_vehiclesFragment)
                }
                4 -> {
                    navController.navigate(R.id.action_dashboardFragment_to_vehiclesFragment)
                }
                5 -> {
                    navController.navigate(R.id.action_dashboardFragment_to_vehiclesFragment)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ItemDashboardBinding.bind(view)

        fun render(dashboard: Dashboard) {
            binding.textView.text = dashboard.name
            Picasso
                .get()
                .load(dashboard.image)
                .into(binding.imageView)
        }
    }
}