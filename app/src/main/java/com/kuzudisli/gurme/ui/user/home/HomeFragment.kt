package com.kuzudisli.gurme.ui.user.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kuzudisli.domain.entities.RestaurantWithMenu
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject


class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val viewModel: HomeViewModel by inject()
    private lateinit var bottomNavigaitonView: BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        bottomNavigaitonView = (activity as AppCompatActivity?)!!.findViewById(R.id.bottomNavigationView)
        bottomNavigaitonView.isVisible = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observers()

        viewModel.getRestaurantList()
    }

    private fun initUI() {

    }

    private fun setupRecyclerView(dataList: List<RestaurantWithMenu>) {
        binding.recyclerViewHome.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewHome.adapter = HomeAdapter(dataList, this)
    }

    private fun observers() {
        viewModel.dataList.observe(viewLifecycleOwner) { dataList ->
            setupRecyclerView(dataList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(_id:String) {

        val action =
            HomeFragmentDirections.actionHomeFragmentToRestaurantFragment(_id)
        findNavController().navigate(action)
    }
}