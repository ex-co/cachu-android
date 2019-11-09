package com.ex.cachu.ui.query

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ex.cachu.R

class QueryFragment : Fragment() {

    companion object {
        fun newInstance() = QueryFragment()
    }

    private lateinit var viewModel: QueryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_query, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QueryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
