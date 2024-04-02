package com.kuzudisli.gurme.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

object NavigationUtils {
    // Activity'ler arası geçiş için fonksiyon
    fun <T : AppCompatActivity> Context.navigateToActivity(destination: Class<T>) {
        val intent = Intent(this, destination)
        startActivity(intent)
    }

    // Fragmentlar arası geçiş için fonksiyon
    fun navigateToFragment(fragment: Fragment, destinationId: Int) {
        fragment.findNavController().navigate(destinationId)
    }

    //Argümanlar ile veri taşınacaksa bunu kullan, method overloading
    fun Fragment.navigateToFragment(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    fun navigateToFragment(fragment: Fragment?, directions: Int, bundle: Bundle?) {
        // Eğer bir Bundle varsa, NavController'e bu Bundle'ı ekleyerek navigasyon yapın
        if (bundle != null) {
            NavHostFragment.findNavController(fragment!!).navigate(directions, bundle)
        } else {
            NavHostFragment.findNavController(fragment!!).navigate(directions)
        }
    }
}