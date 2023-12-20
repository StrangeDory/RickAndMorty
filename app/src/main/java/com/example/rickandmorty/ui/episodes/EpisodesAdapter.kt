package com.example.rickandmorty.ui.episodes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.data.entities.Location
import com.example.rickandmorty.databinding.ItemEpisodeBinding

class EpisodesAdapter (private val listener: EpisodeItemListener) : RecyclerView.Adapter<EpisodeViewHolder>() {

    interface EpisodeItemListener {
        fun onClickedEpisode(locationId: Int)
    }

    private val items = ArrayList<Episode>()

    fun setItems(items: ArrayList<Episode>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding: ItemEpisodeBinding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) = holder.bind(items[position])
}

class EpisodeViewHolder(private val itemBinding: ItemEpisodeBinding, private val listener: EpisodesAdapter.EpisodeItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var episode: Episode

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Episode) {
        this.episode = item
        itemBinding.nameEpisode.text = item.name
        itemBinding.episodeAirDateEpisode.text = """${item.episode} - ${item.air_date}"""
    }

    override fun onClick(v: View?) {
        listener.onClickedEpisode(episode.id)
    }
}
