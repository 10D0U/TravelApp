package com.projects.travelapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projects.travelapp.Domains.CategoryDomain
import com.projects.travelapp.R

class CategoryAdapter(private val items: ArrayList<CategoryDomain>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val picImage: ImageView = itemView.findViewById(R.id.category_image)
        val titleText: TextView = itemView.findViewById(R.id.category_title)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = items[position]
        holder.titleText.text  = category.title

        val drawableResourceId = ContextCompat.getDrawable(
            holder.itemView.context,
            holder.itemView.resources.getIdentifier(
                category.picPath, "drawable", holder.itemView.context.packageName
            )
        )?.toBitmap()

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.picImage)
    }
}