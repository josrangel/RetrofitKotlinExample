package com.example.retroplo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retroplo.R
import com.example.retroplo.entity.ResultsItem
import com.squareup.picasso.Picasso

class PersonAdapter(private val mList: List<ResultsItem>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_person, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.tvName.text = ItemsViewModel.name?.title + " " + ItemsViewModel.name?.first + " " + ItemsViewModel.name?.last
        holder.tvEmail.text = ItemsViewModel.email
        holder.tvAddress.text = ItemsViewModel.location?.city + ", " + ItemsViewModel.location?.country
        Picasso.get().load(ItemsViewModel.picture?.medium).into(holder.ivPerson);
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivPerson: ImageView = itemView.findViewById(R.id.ivPerson)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
    }
}