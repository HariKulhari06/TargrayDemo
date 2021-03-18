package com.hari.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.hari.sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val navController: NavController by lazy {
        Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbar()
        setUpNavigation()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setUpNavigation() {
        appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.employeesFragment)
            )

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}