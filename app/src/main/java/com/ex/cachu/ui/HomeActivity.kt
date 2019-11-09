package com.ex.cachu.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ex.cachu.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Home", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_query,
                R.id.navigation_dashboard, R.id.navigation_mypage
            )
        )

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

        navView.setupWithNavController(navController)
    }
}
