package com.kuzudisli.gurme.ui.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.kuzudisli.gurme.databinding.FragmentRestaurantBinding


class RestaurantFragment : Fragment() {

    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuDetailToolbar: MaterialToolbar
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var isUserScrolling: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = binding.recyclerViewRestaurant.layoutManager as LinearLayoutManager
        initUI()

    }

    private fun initUI() {
        syncTabWithRecyclerView()
        initializeTabItem(listOf("Burger", "Pizza", "Kebab", "Dessert", "Drink"))
    }

    private fun initializeTabItem(products: List<String?>?) {
        binding.tlMerchant.removeAllTabs()
        products?.forEach { product ->
            binding.tlMerchant.addTab(binding.tlMerchant.newTab().setText(product))
        }
    }


    private fun syncTabWithRecyclerView() {
        // Move recyclerview to the selected position
        binding.tlMerchant.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (!isUserScrolling) {
                    val position = tab.position
                    smoothScroller(position)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        // Detect recyclerview position and select tab respectively.
        binding.recyclerViewRestaurant.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    isUserScrolling = true
                }  else if (newState == RecyclerView.SCROLL_STATE_IDLE)
                    isUserScrolling = false
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (isUserScrolling) {
                    val firstCompletePos = linearLayoutManager.findFirstVisibleItemPosition()

                    if (firstCompletePos != binding.tlMerchant.selectedTabPosition)
                        binding.tlMerchant.getTabAt(firstCompletePos)?.select()
                }
            }
        })
    }

    private fun smoothScroller(position: Int) {
        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
        smoothScroller.targetPosition = position
        linearLayoutManager.startSmoothScroll(smoothScroller)
    }

    override fun onResume() {
        super.onResume()
        view?.animation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
            // When the view is fully visible, the query is made.
            //homeViewModel.queryMerchant(args.id)
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}