package com.roshni.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.roshni.softuser.fragments.AboutUsFragment
import com.roshni.softuser.fragments.AddFragment
import com.roshni.softuser.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        val first = HomeFragment()
        val second = AddFragment()
        val third = AboutUsFragment()
        setFragment(first)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> setFragment(first)
                R.id.navigation_AddStudent -> setFragment(second)
                R.id.navigation_AboutUs -> setFragment(third)
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearContainer,fragment)
            commit()
        }
}