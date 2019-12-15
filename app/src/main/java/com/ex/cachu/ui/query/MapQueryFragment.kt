package com.ex.cachu.ui.query

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ex.cachu.R
import net.daum.mf.map.api.MapView

class MapQueryFragment : Fragment() {

    companion object {
        fun newInstance() = MapQueryFragment()
    }

    private lateinit var viewModel: MapQueryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.map_query_fragment, container, false)
        var mapView = MapView(getActivity())
        var mapViewContainer: ViewGroup = view.findViewById(R.id.mapView)
        mapViewContainer.addView(mapView)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapQueryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
