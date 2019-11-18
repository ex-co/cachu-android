package com.ex.cachu.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ex.cachu.R

class PreviewImageAdapter constructor(mContext: Context, models: List<CafeModel>) : PagerAdapter() {

    private val mContext: Context
    private val models: List<CafeModel>

    init {
        Log.e("Adapter", "init")
        this.mContext = mContext
        this.models = models
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.e("Hello", "I'm instantiable item ~" + position)
        val inflator = LayoutInflater.from(mContext)
        val view = inflator.inflate(R.layout.preview_page, container, false)

        val imageView = view.findViewById<ImageView>(R.id.cafe_image)
        imageView.setImageResource(models.get(position).image)

        val title = view.findViewById<TextView>(R.id.cafe_title)
        title.setText(models.get(position).title)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.e("PreviewImageAdapter", "destroyItem")
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return models.size
    }
}