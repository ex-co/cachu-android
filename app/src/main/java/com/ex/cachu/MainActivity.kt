package com.ex.cachu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import net.daum.mf.map.api.MapView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mapView = MapView(this)

        val mapViewContainer = findViewById(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)
    }
}
