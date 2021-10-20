package com.sinus.projectaplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sinus.projectaplikasi.fragment.AkunFragment
import com.sinus.projectaplikasi.fragment.BarangFragment
import com.sinus.projectaplikasi.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    val fragmenthome : Fragment = HomeFragment()
    val fragmentbarang : Fragment = BarangFragment()
    val fragmentakun : Fragment = AkunFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = HomeFragment()

    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.nav_host_fragment, fragmenthome).show(fragmenthome).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentbarang).hide(fragmentbarang).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentakun).hide(fragmentakun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home-> {
                    Log.d("Respon", "Home")
                    menuItem = menu.getItem(0)
                    menuItem.isChecked = true
                    fm.beginTransaction().hide(active).show(fragmenthome).commit()
                    active = fragmenthome
                }
                R.id.navigation_barang-> {
                    Log.d("Respon", "Barang")
                    menuItem = menu.getItem(1)
                    menuItem.isChecked = true
                    fm.beginTransaction().hide(active).show(fragmentbarang).commit()
                    active = fragmentbarang
                }
                R.id.navigation_akun-> {
                    Log.d("Respon", "Akun")
                    menuItem = menu.getItem(2)
                    menuItem.isChecked = true
                    fm.beginTransaction().hide(active).show(fragmentakun).commit()
                    active = fragmentakun
                }
            }
        false }
    }
}