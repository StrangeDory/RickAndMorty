package com.example.rickandmorty.ui.filter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.entities.Character
import com.example.rickandmorty.data.repository.Repository
import kotlinx.coroutines.launch

class FilterViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    var listCharactersInEpisode = MutableLiveData<List<Character>>()
    var filterValue = MutableLiveData<Array<Int>>()
    var isFilter = MutableLiveData<Boolean>()

    init {
        filterValue.value = arrayOf(0, 0)
        isFilter.value = false
    }

//    fun getCharacters(page: Int) {
//        viewModelScope.launch{
//            val characters = repository.getCharacters(page)
//            listCharactersInEpisode.value = characters.value
//            isFilter.value = false
//        }
//    }

    fun getByName(name: String){
        viewModelScope.launch{
            val characters = repository.getCharactersByName(name)
            listCharactersInEpisode.value = characters.value?.data
            isFilter.value = true
        }
    }

    fun getByStatusAndGender(status : String, gender: String, page:Int){
//        viewModelScope.launch{
//            val characters = repository.getCharactersbyStatusAndGender(status, gender, page)
//            listCharactersInEpisode.value = characters.results
//            isFilter.value = true
//        }
    }

    fun getByStatus(status : String, page:Int){
//        viewModelScope.launch{
//            val characters = repository.getCharactersByStatus(status, page)
//            listCharactersInEpisode.value = characters.results
//            isFilter.value = true
//        }
    }

    fun getByGender(gender: String, page:Int){
//        viewModelScope.launch{
//            val characters = repository.getCharactersByGender(gender, page)
//            listCharactersInEpisode.value = characters.results
//            isFilter.value = true
//        }
    }
}