package com.mobile.withings.model

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.withings.R
import com.squareup.picasso.Picasso
import java.util.*


class DataAdapter(
    private val context: Context,
    private val ImgUrls: ArrayList<String>
) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
//        Log.e("URLS: ", ImgUrls[i])
       // Picasso.with(context).load(ImgUrls[i]).resize(600, 600).into(viewHolder.img_android)
        Picasso.get()
            .load(Uri.parse(ImgUrls[i]))
            .noPlaceholder()
            .into(viewHolder.imgSearch)
    }

    override fun getItemCount(): Int {
        return ImgUrls.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imgSearch: ImageView = view.findViewById<View>(R.id.img_android) as ImageView

    }

}