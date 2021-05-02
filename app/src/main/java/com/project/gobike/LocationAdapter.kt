package com.project.gobike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.location_bikestation_row.view.*
import com.squareup.picasso.Picasso

class LocationAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<HomeFeedListViewHolder>() {
    val bslist = listOf<String>("GoBike 001", "GoBike 002", "GoBike 003", "GoBike 004")

    override fun getItemCount(): Int {
        return homeFeed.favorites.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFeedListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.location_bikestation_row, parent, false)
        return HomeFeedListViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: HomeFeedListViewHolder, position: Int) {
        val bikeStationlist = homeFeed.favorites.get(position)
        holder.itemView.textView_bstation_name?.text = bikeStationlist.contract_name
        holder.view.textView_station_name.text = bikeStationlist.name
        holder.view.textView_title.text = bikeStationlist.address
      //  val thumbImageView = holder.view.imageView_thumb
      //  Picasso.with(holder.view.context).load(favorites.imageUrl).into(thumbImageView)


    }
}

class HomeFeedListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}