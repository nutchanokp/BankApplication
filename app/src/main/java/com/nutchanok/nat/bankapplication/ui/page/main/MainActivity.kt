package com.nutchanok.nat.bankapplication.ui.page.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.common.base.BaseActivity
import com.nutchanok.nat.bankapplication.databinding.ActivityMainBinding
import com.nutchanok.nat.bankapplication.extensions.setupWithNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    // test
    private val mainViewModel: MainViewModel by viewModel()

    private var navController: LiveData<NavController>? = null

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this.lifecycleOwner
            activity = this@MainActivity
        }
    }

    override fun initView() {

        setUpBottomNavigatorBar()

    }

    override fun initListener() {
    }

    override fun setupObserve() {
    }

    private fun setUpBottomNavigatorBar() {

//        binding.bnvMain.itemIconTintList = null
        with(binding) {
//            bnvMain.apply {
////                itemIconTintList = it.itemId
//                disableTooltip()
//            }

            val navGraphIds = listOf(
                R.navigation.nav_home,
                R.navigation.nav_account,
                R.navigation.nav_scan,
                R.navigation.nav_services,
                R.navigation.nav_settings,
            )
            // Setup the bottom navigation view with a list of navigation graphs
            navController = bnvMain.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.nav_host_container,
                intent = intent
            ) { id ->
                return@setupWithNavController true
            }
            bnvMain.selectedItemId = R.id.nav_account

//            bnvMain.apply {
//                disableTooltip()
//                setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
//                    bnvMain.selectedItemId = it.itemId
//                    return@OnItemSelectedListener true
//                })
//            }

        }
    }


}