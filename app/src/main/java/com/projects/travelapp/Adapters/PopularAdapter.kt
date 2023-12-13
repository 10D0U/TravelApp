package com.projects.travelapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.projects.travelapp.Domains.PopularDomain
import com.projects.travelapp.R
import java.text.DecimalFormat

class PopularAdapter(
    private val items: ArrayList<PopularDomain>
): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private val formatter = DecimalFormat("###,###,###,###")
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.title_text)
        val locationText: TextView = itemView.findViewById(R.id.location_text)
        val scoreText: TextView = itemView.findViewById(R.id.score_text)
        val pic: ImageView = itemView.findViewById(R.id.popular_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleText.text = items[position].title
        holder.locationText.text = items[position].location
        holder.scoreText.text = items[position].score.toString()

        val drawableResourceId = holder.itemView.resources.getIdentifier(items[position].pic,
            "drawable", holder.itemView.context.packageName)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .transform(CenterCrop(), GranularRoundedCorners(40F, 40F, 40F, 40F))
            .into(holder.pic)
    }
}