package com.garrodroideveloper.muzzexercise.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor(private val mainRepository: MainRepository) : ViewModel() {
        fun populateUserDatabase() =
            viewModelScope.launch {
                mainRepository.populateDatabase()
            }
    }
