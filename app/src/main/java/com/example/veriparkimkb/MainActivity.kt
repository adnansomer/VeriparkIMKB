package com.example.veriparkimkb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.veriparkimkb.databinding.ActivityMainBinding
import com.example.veriparkimkb.view.di.Injector
import com.example.veriparkimkb.view.handshake.HandshakeViewModel
import com.example.veriparkimkb.view.handshake.HandshakeViewModelFactory
import com.example.veriparkimkb.view.imkblist.ImkbListFragment
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var factory: HandshakeViewModelFactory
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: HandshakeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createHandshakeSubComponent().inject(this)

        viewModel = ViewModelProvider(this, factory).get(HandshakeViewModel::class.java)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_app_bar_open_drawer_description, R.string.nav_app_bar_close_drawer_description)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragment = ImkbListFragment()
        when (item.itemId) {
            R.id.nav_allstocks -> {
                fragment.arguments = bundleOf("period" to "all")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }

            R.id.nav_rising -> {
                fragment.arguments = bundleOf("period" to "increasing")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }

            R.id.nav_falling -> {
                fragment.arguments = bundleOf("period" to "decreasing")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }

            R.id.nav_100 -> {
                fragment.arguments = bundleOf("period" to "volume30")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }

            R.id.nav_50 -> {
                fragment.arguments = bundleOf("period" to "volume50")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }

            R.id.nav_30 -> {
                fragment.arguments = bundleOf("period" to "volume100")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                    .commit()
                binding.drawerLayout.closeDrawers()
            }
        }
        return true
    }
}