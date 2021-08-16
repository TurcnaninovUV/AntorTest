package com.antortest.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antortest.dto.Fields
import com.antortest.repository.FieldsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FieldsViewModel @Inject constructor(
    private val repository: FieldsRepository
) : ViewModel() {

    val data = repository.dataFields


    fun load(listFields: List<Fields>) = viewModelScope.launch {
        repository.insert(listFields)
    }

    fun stringShow() = viewModelScope.launch {
        data.value?.map {
            it.showString = !it.showString
            it.showInt = false
            it.showDouble = false
        }
    }

    fun intShow() = viewModelScope.launch {
        data.value?.map {
            it.showString = false
            it.showInt = !it.showInt
            it.showDouble = false
        }
    }

    fun doubleShow() = viewModelScope.launch {
        data.value?.map {
            it.showString = false
            it.showInt = false
            it.showDouble = !it.showDouble
        }
    }


}