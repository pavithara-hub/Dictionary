package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val search= SearchFragment()
        val favourite=FavouriteFragment()

        currentFragment(search)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.search->currentFragment(search)
                R.id.favourite->currentFragment(favourite)
            }
            true
        }


    }
    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView, fragment).commit()
        }
}
