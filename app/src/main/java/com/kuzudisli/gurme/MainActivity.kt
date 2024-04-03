package com.kuzudisli.gurme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kuzudisli.gurme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initUI()
        initNavigation()
    }

    private fun initUI() {
        // Menü öğesi için badge oluşturma ve görüntüleme
        val badge: BadgeDrawable =
            binding.bottomNavigationView.getOrCreateBadge(R.id.orderFragment) // Menü öğenizin ID'si ile değiştirin.
        badge.isVisible = true
        badge.text = "100 TL" // Badge'de görüntülenecek sayı (livedata ile bağlanacak)
        binding.bottomNavigationView.labelVisibilityMode =
            BottomNavigationView.LABEL_VISIBILITY_UNLABELED
    }

    private fun initNavigation() {
        //Inıt of navigationFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu, menu)

        return true
    }
}