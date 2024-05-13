package com.kuzudisli.gurme.ui.user.menudetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzudisli.data.local.home.RestaurantWithMenusDaoImpl
import com.kuzudisli.data.local.order.OrderDaoImpl
import com.kuzudisli.domain.entities.CurrentOrder
import com.kuzudisli.domain.entities.OrderMenu
import kotlinx.coroutines.launch

class MenuDetailViewModel(val menuRepo: OrderDaoImpl) : ViewModel() {


    val askQuestion: MutableLiveData<String> = MutableLiveData()

    fun addMenuToCart(orderMenu: OrderMenu) {
        viewModelScope.launch {
            val currentOrder = menuRepo.findById("1")
            if (currentOrder == null || currentOrder.restaurant_id == orderMenu.restaurant_id) {
                val order = CurrentOrder()
                order._orderId = "1"
                order.restaurant_id = orderMenu.restaurant_id
                order.orderMenuList.add(orderMenu)
                menuRepo.insert(order)
            } else {
                askQuestion.postValue("You have an order from another restaurant. Do you want to clear it?")
            }
        }
    }

    fun clearOrder() {
        viewModelScope.launch {
            menuRepo.deleteAll()
        }
    }

}