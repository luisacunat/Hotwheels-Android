package mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.data.models.Dashboard
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.databinding.FragmentDashboardBinding
import mx.edu.uthermosillo.apps.luisacunat.hotwheels.ui.views.adapters.DashboardAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var dashboardAdapter: DashboardAdapter
    private var options: List<Dashboard> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        loadOptions()

        val recyclerView = binding.dashboardRecycler
        dashboardAdapter = DashboardAdapter(options)

        val layoutManager = LinearLayoutManager(context)
        //val layoutManager = GridLayoutManager(context, 2)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = dashboardAdapter

        return binding.root
    }

    private fun loadOptions() {

        options = listOf(
            Dashboard(1, "Autos", "https://i.pinimg.com/originals/1e/08/fe/1e08fedf56325b544e8f1c09ad8648b1.jpg"),
            Dashboard(2, "Brands", "https://2.bp.blogspot.com/-O2jVBoJmPMs/UR3GoUhcvoI/AAAAAAAAAcs/8Q5u9YW0gXU/s1600/car+logos+4.gif"),
            Dashboard(3, "Countries", "https://www.hdwallpaper.nu/wp-content/uploads/2015/03/75687ef560864a88fa0e4b9bbf46b044.jpg"),
            Dashboard(4, "Types", "https://carfromjapan.com/wp-content/uploads/2018/03/types_of_cars.jpg"),
            Dashboard(5, "Engines", "https://i.pinimg.com/originals/3d/8a/cd/3d8acd93fa7a5e6194bea0e0c9d28df1.jpg"),
        )
    }
}