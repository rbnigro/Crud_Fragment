package com.ronney.mysubscribers

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // https://www.youtube.com/watch?v=eMVxhlBsxEk
        // https://github.com/douglasramalho/my-subscribers-app/blob/tutorial-parte-05/app/src/main/res/layout/activity_main.xml
        
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        var navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        app_toolbar.setupWithNavController(navController, appBarConfiguration)

    }
}