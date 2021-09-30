package com.mobile.withings

import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.withings.model.ImageResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search.view.*

class ListAdapter(var searchResultItems: List<ImageResult>) : RecyclerView.Adapter<ListAdapter.PostViewHolder>() {

    var onItemClick: ((ImageResult) -> Unit)? = null

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(searchResultItems[adapterPosition])
                if(searchResultItems[adapterPosition].isSelected == true){
                    itemView.setBackgroundColor(Color.parseColor("#ff0000"))
                }else{
                    itemView.setBackgroundColor(Color.parseColor("#ffffff"))
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchResultItems.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply{
            itemTags.text = searchResultItems[position].tags
            itemUser.text = searchResultItems[position].user
            Picasso.get()
                .load(Uri.parse(searchResultItems[position].webformatURL))
                .noPlaceholder()
                .into(imageSearch)
        }
    }
}