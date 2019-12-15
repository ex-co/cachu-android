package com.ex.cachu.ui.query

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ex.cachu.R

class PictureQueryFragment : Fragment() {

    companion object {
        fun newInstance() = PictureQueryFragment()
    }

    private lateinit var viewModel: PictureQueryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.picture_query_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PictureQueryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
