package com.example.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.ui.characters.CharactersFragment
import com.example.rickandmorty.ui.episodes.EpisodesFragment
import com.example.rickandmorty.ui.locations.LocationsFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            val fragment = navHostFragment.childFragmentManager.fragments[0]
            when (it.itemId) {
                R.id.nav_characters -> if (fragment !is CharactersFragment) {
                    navController.graph = navController.graph.apply {
                        startDestination = R.id.charactersFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_locations -> if (fragment !is LocationsFragment) {
                    navController.graph = navController.graph.apply {
                        startDestination = R.id.locationsFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_episodes -> if (fragment !is EpisodesFragment) {
                    navController.graph = navController.graph.apply {
                        startDestination = R.id.episodesFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }
            }

            return@setOnNavigationItemSelectedListener false
        }
    }
}
