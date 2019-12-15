package com.ex.cachu.ui.query

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.ex.cachu.R

class QueryFragment : Fragment(), View.OnClickListener{

    internal lateinit var callback: OnHeadlineSelectedListener

    companion object {
        fun newInstance(): QueryFragment{
            return QueryFragment()
        }
    }

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    interface OnHeadlineSelectedListener {
        fun onQuerySelected(option: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_query, container, false)
        val picQueryBtn = view.findViewById<ImageButton>(R.id.picQueryBtn)
        val mapQueryBtn = view.findViewById<ImageButton>(R.id.mapQueryBtn)

        picQueryBtn.setOnClickListener(this)
        mapQueryBtn.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View) {

        Log.d("QueryFragment", "clicked")

        when(v?.id){
            R.id.picQueryBtn->{
                Log.d("QueryFragment", "picBtn Clicked")
                callback.onQuerySelected(1)
            }
            R.id.mapQueryBtn->{
                Log.d("QueryFragment", "mapBtn Clicked")
                callback.onQuerySelected(2)
            }
        }

    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        this.callback = context as OnHeadlineSelectedListener
    }

}