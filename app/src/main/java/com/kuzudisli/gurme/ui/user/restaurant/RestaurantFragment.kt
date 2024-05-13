package com.kuzudisli.gurme.ui.user.restaurant

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kuzudisli.domain.model.MenuModel
import com.kuzudisli.domain.model.MenuWithCatagories
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentRestaurantBinding
import com.kuzudisli.gurme.ui.user.restaurant.adapter.CategoriesAdapter
import com.kuzudisli.gurme.ui.user.restaurant.adapter.ProductAdapter
import org.koin.android.ext.android.inject


class RestaurantFragment : Fragment(), ProductAdapter.OnProductClickListener {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!
    private val args: RestaurantFragmentArgs by navArgs()
    private val viewModel: RestaurantViewModel by inject()

    private lateinit var bottomNavigaitonView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        bottomNavigaitonView = (activity as AppCompatActivity?)!!.findViewById(R.id.bottomNavigationView)
        bottomNavigaitonView.isVisible = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observers()

        val restaurantId = args.restaurantId
        if (restaurantId != "no id") {
            viewModel.getRestaurant(restaurantId)
        } else {
            Log.d("RestaurantFragment", "onViewCreated: No restaurant id")
        }
    }

    private fun initTabLayout(categories: List<MenuWithCatagories>) {
        if(binding.tabLayout.getTabAt(0) == null) {
            for (category in categories) {
                binding.tabLayout.addTab(binding.tabLayout.newTab().setText(category.name))
            }
        }
    }

    private fun initRecycler(categories: List<MenuWithCatagories>) {
        binding.recyclerView.adapter = CategoriesAdapter(requireContext(), categories,this)
    }

    private fun initMediator(categories: List<MenuWithCatagories>) {
        TabbedListMediator(
            binding.recyclerView,
            binding.tabLayout,
            categories.indices.toList()
        ).attach()
    }

    private fun initUI() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun observers() {
        //burda restoran ve menuleri geliyor.ihtiyacımız olan her şey data içinde.
        viewModel.data.observe(viewLifecycleOwner) { data ->
            val restaurant = data.restaurant
            val menus = data.menu
            val categories = restaurant?.categoryList as List<String>
            binding.restaurantName2.text = restaurant.restaurant_name
            binding.restaurantAddressText.text = restaurant.address
            binding.minimumOrderPrice.text = "Min. Order: ${restaurant.min_price} TL"

            val allCategories = mutableListOf<MenuWithCatagories>()

            for (category in categories) {
                val filteredMenus = menus.filter { it.category == category }
                allCategories.add(MenuWithCatagories(category, filteredMenus))
            }

            initTabLayout(allCategories)
            initRecycler(allCategories)
            initMediator(allCategories)
            // Initialize the tab layout with the categories of the restaurant
        }
    }

    override fun onItemClick(menu:MenuModel) {
        val action = RestaurantFragmentDirections.actionRestaurantFragmentToMenuDetailFragment(menu)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}