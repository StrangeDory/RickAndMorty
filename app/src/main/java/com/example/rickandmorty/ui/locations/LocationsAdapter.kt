package com.example.rickandmorty.ui.locations

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.data.entities.Location
import com.example.rickandmorty.databinding.ItemLocationBinding

class LocationsAdapter (private val listener: LocationItemListener) : RecyclerView.Adapter<LocationViewHolder>() {

    interface LocationItemListener {
        fun onClickedLocation(locationId: Int)
    }

    private val items = ArrayList<Location>()

    fun setItems(items: ArrayList<Location>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding: ItemLocationBinding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) = holder.bind(items[position])
}

class LocationViewHolder(private val itemBinding: ItemLocationBinding, private val listener: LocationsAdapter.LocationItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var location: Location

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Location) {
        this.location = item
        itemBinding.nameLocation.text = item.name
        itemBinding.typeLocation.text = item.type
//        Glide.with(itemBinding.root)
//            .load(item.image)
//            .transform(CircleCrop())
//            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedLocation(location.id)
    }
}
