package com.sinus.projectaplikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sinus.projectaplikasi.fragment.AkunFragment
import com.sinus.projectaplikasi.fragment.BarangFragment
import com.sinus.projectaplikasi.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    val fragmenthome : Fragment = HomeFragment()
    val fragmentbarang : Fragment = BarangFragment()
    val fragmentakun : Fragment = AkunFragment()
    val fm : FragmentManager = supportFragmentManager
    val active : Fragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.nav_host_fragment, fragmenthome).show(fragmenthome).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentbarang).hide(fragmentbarang).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment, fragmentakun).hide(fragmentakun).commit()
    }
}