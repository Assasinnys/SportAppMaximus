package com.example.sportappmaximus

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_progress,
                R.id.navigation_chat,
                R.id.navigation_settings,
                R.id.navigation_store
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    fun hideNavigationBar() {
        nav_view.visibility = View.GONE
        clearFragmentMargin()
    }

    fun showNavigationBar() {
        nav_view.visibility = View.VISIBLE
        applyFragmentMargin()
    }

    private fun clearFragmentMargin() {
        val params = fragment_container.layoutParams as ConstraintLayout.LayoutParams
        if (params.bottomMargin != 0)
            fragment_container.layoutParams = params.apply { bottomMargin = 0 }
    }

    private fun applyFragmentMargin() {
        val params = fragment_container.layoutParams as ConstraintLayout.LayoutParams
        if (params.bottomMargin == 0)
            fragment_container.layoutParams = params.apply {
                bottomMargin = resources.getDimension(R.dimen.fragment_container_vertical_margin).toInt()
            }
    }
}