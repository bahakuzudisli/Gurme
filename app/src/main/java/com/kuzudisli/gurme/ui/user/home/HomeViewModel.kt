package com.kuzudisli.gurme.ui.user.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzudisli.data.local.home.RestaurantWithMenusDaoImpl
import com.kuzudisli.domain.entities.Menu
import com.kuzudisli.domain.entities.Restaurant
import com.kuzudisli.domain.entities.RestaurantWithMenu
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.launch

class HomeViewModel(val repo: RestaurantWithMenusDaoImpl) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> = _isLoading

    private val _dataList = MutableLiveData<List<RestaurantWithMenu>>()
    val dataList: LiveData<List<RestaurantWithMenu>> = _dataList

    init {
        getRestaurantList()
    }

    fun getRestaurantList() {
        isLoading.value = true
        viewModelScope.launch {
            repo.insertAll(createDiverseRestaurantsWithMenus())
            val result = repo.findAll()
            _dataList.postValue(result)
        }
        isLoading.value = false
    }

    private fun createDiverseRestaurantsWithMenus(): List<RestaurantWithMenu> {
        val samples = mutableListOf<RestaurantWithMenu>()

        // İtalyan Restoranı Örneği
        val italianRestaurant = Restaurant().apply {
            _id = "101"
            restaurant_name = "Italian Aroma"
            address = "123 Pasta Street, Rome"
            phone_number = "555-1010"
            image = "image_italian_restaurant_url"
            opening_hours = "11:00"
            closing_hours = "23:00"
            categoryList = realmListOf("Pasta", "Pizza","Desert")
            min_price = "$15"
        }
        val italianMenu = realmListOf(
            Menu().apply {
                _id = "it001"
                restaurant_id = "101"
                item_name = "Spaghetti Carbonara"
                price = 12.0
                image = "image_carbonara_url"
                category = "Pasta"
                description = "Classic creamy pasta with eggs, cheese, and pancetta."
            },
            Menu().apply {
                _id = "it002"
                restaurant_id = "101"
                item_name = "Margherita Pizza"
                price = 15.0
                image = "image_margherita_pizza_url"
                category = "Pasta"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it003"
                restaurant_id = "101"
                item_name = "pepperoni Pizza"
                price = 15.0
                image = "image_margherita_pizza_url"
                category = "Pasta"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it004"
                restaurant_id = "101"
                item_name = "Sucuklu Pizza"
                price = 15.0
                image = "image_margherita_pizza_url"
                category = "Pizza"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it005"
                restaurant_id = "101"
                item_name = "Mantarlı Pizza"
                price = 15.0
                image = "image_margherita_pizza_url"
                category = "Pizza"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it006"
                restaurant_id = "101"
                item_name = "Vejetaryen Pizza"
                price = 15.0
                image = "image_margherita_pizza_url"
                category = "Pizza"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it007"
                restaurant_id = "101"
                item_name = "Künefe"
                price = 25.0
                image = "image_margherita_pizza_url"
                category = "Desert"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it008"
                restaurant_id = "101"
                item_name = "Puding"
                price = 5.0
                image = "image_margherita_pizza_url"
                category = "Desert"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            Menu().apply {
                _id = "it009"
                restaurant_id = "101"
                item_name = "Sütlaç"
                price = 8.0
                image = "image_margherita_pizza_url"
                category = "Desert"
                description = "Authentic Neapolitan pizza with fresh mozzarella and basil."
            },
            // Diğer menüler bu şekilde eklenir
        )
        samples.add(RestaurantWithMenu().apply {
            _id = italianRestaurant._id
            restaurant = italianRestaurant
            menu = italianMenu
        })

        // Burgerci Örneği
        val burgerJoint = Restaurant().apply {
            _id = "102"
            restaurant_name = "Burger Hub"
            address = "456 Burger Road, New York"
            phone_number = "555-2020"
            image = "image_burger_joint_url"
            opening_hours = "10:00"
            closing_hours = "22:00"
            categoryList = realmListOf("Burgers", "Fries")
            min_price = "$8"
        }
        val burgerMenu = realmListOf(
            Menu().apply {
                _id = "bg001"
                restaurant_id = "102"
                item_name = "Cheeseburger"
                price = 9.0
                image = "image_cheeseburger_url"
                category = "Burgers"
                description = "Juicy burger with cheddar cheese, lettuce, and tomato."
            },
            Menu().apply {
                _id = "bg002"
                restaurant_id = "102"
                item_name = "Loaded Fries"
                price = 5.0
                image = "image_loaded_fries_url"
                category = "Fries"
                description = "Crispy fries topped with cheese sauce and bacon bits."
            },
            // Diğer menüler bu şekilde eklenir
        )
        samples.add(RestaurantWithMenu().apply {
            _id = burgerJoint._id
            restaurant = burgerJoint
            menu = burgerMenu
        })

        // Kafe Örneği
        val cafe = Restaurant().apply {
            _id = "103"
            restaurant_name = "Cozy Cafe"
            address = "789 Coffee Blvd, Seattle"
            phone_number = "555-3030"
            image = "image_cafe_url"
            opening_hours = "08:00"
            closing_hours = "20:00"
            categoryList = realmListOf("Coffee", "Desserts")
            min_price = "$4"
        }
        val cafeMenu = realmListOf(
            Menu().apply {
                _id = "cf001"
                restaurant_id = "103"
                item_name = "Cappuccino"
                price = 4.0
                image = "image_cappuccino_url"
                category = "Coffee"
                description = "Rich and foamy cappuccino with a dusting of cocoa powder."
            },
            Menu().apply {
                _id = "cf002"
                restaurant_id = "103"
                item_name = "Cheesecake"
                price = 6.0
                image = "image_cheesecake_url"
                category = "Desserts"
                description = "Creamy cheesecake with a buttery graham cracker crust."
            },
            // Diğer menüler bu şekilde eklenir
        )
        samples.add(RestaurantWithMenu().apply {
            _id = cafe._id
            restaurant = cafe
            menu = cafeMenu
        })

        // Diğer restoran örnekleri ve menülerini benzer bir yapıda oluşturarak, çeşitliliği artırabilirsiniz.

        return samples
    }




}