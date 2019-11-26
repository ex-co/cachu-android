package com.ex.cachu.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ex.cachu.R

//TODO this needs to be refactored using MVVM model.
class HomeFragment : Fragment() {

    val firstModels: MutableList<CafeModel> = ArrayList()
    val secondModels: MutableList<CafeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("HomeFragment", "onCreateView")
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        generateCafeModels()

        val firstViewPager = root.findViewById<CustomViewPager>(R.id.first_pager)
        val secondViewPager = root.findViewById<CustomViewPager>(R.id.second_pager)

        val mContext = context

        if (mContext != null) {
            val firstPagerAdapter = PreviewImageAdapter(mContext, firstModels)
            val secondPagerAdapter = PreviewImageAdapter(mContext, secondModels)

            firstViewPager.adapter = firstPagerAdapter
            firstViewPager.clipToPadding = false

            secondViewPager.adapter = secondPagerAdapter
            secondViewPager.clipToPadding = false
        }

        return root
    }

    fun generateCafeModels() {
        firstModels.add(CafeModel(R.drawable.cafe_dummy_1, "Cafe #1"))
        firstModels.add(CafeModel(R.drawable.cafe_dummy_2, "Cafe #2"))
        firstModels.add(CafeModel(R.drawable.cafe_dummy_3, "Cafe #3"))
        firstModels.add(CafeModel(R.drawable.cafe_dummy_4, "Cafe #4"))

        secondModels.add(CafeModel(R.drawable.cafe_dummy_1, "Cafe #1"))
        secondModels.add(CafeModel(R.drawable.cafe_dummy_2, "Cafe #2"))
        secondModels.add(CafeModel(R.drawable.cafe_dummy_3, "Cafe #3"))
        secondModels.add(CafeModel(R.drawable.cafe_dummy_4, "Cafe #4"))
    }
}