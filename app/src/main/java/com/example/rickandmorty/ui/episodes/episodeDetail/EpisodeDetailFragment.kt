package com.example.rickandmorty.ui.episodes.episodeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rickandmorty.data.entities.Episode
import com.example.rickandmorty.databinding.FragmentEpisodesDetailBinding
import com.example.rickandmorty.utils.Resource
import com.example.rickandmorty.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment: Fragment() {
    private var binding: FragmentEpisodesDetailBinding by autoCleared()
    private val viewModel: EpisodeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEpisodesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.episode.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.episodeCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.episodeCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindCharacter(episode: Episode) {
        binding.nameEpisode.text = episode.name
        binding.episodeEpisode.text = episode.episode
        binding.airDateEpisode.text = episode.air_date
    }
}