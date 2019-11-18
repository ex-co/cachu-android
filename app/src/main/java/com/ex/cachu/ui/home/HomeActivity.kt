package com.ex.cachu.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ex.cachu.R
import com.ex.cachu.ui.dashboard.DashboardFragment
import com.ex.cachu.ui.mypage.MyPageFragment
import com.ex.cachu.ui.query.QueryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Home", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //init
        val homeFragment = HomeFragment()
        val dashboardFragment = DashboardFragment()
        val myPageFragment = MyPageFragment()
        val queryFragment = QueryFragment()

        navView.setOnNavigationItemSelectedListener {
            item ->
            when {
                item.itemId == R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content_details, homeFragment).commit()
                }
                item.itemId == R.id.navigation_query -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content_details, queryFragment).commit()
                }
                item.itemId == R.id.navigation_dashboard -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content_details, dashboardFragment).commit()
                }
                item.itemId == R.id.navigation_mypage -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content_details, myPageFragment).commit()
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

        val nickname = intent.getStringExtra("nickname")
        val imageUrl = intent.getStringExtra("imageUrl")

        val textView = findViewById<TextView>(R.id.profile_nickname)
        textView.setText("Hello, " + nickname)

        val imageView = findViewById<ImageView>(R.id.profile_image)

        if (imageUrl == null) {
            Glide.with(this)
                .load(R.drawable.kakao_default_profile_image)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
        } else {
            Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
        }

        supportFragmentManager.beginTransaction().replace(R.id.content_details, homeFragment).commit()
    }
}
