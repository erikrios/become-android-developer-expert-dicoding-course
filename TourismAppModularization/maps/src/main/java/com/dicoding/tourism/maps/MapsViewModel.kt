package com.dicoding.tourism.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUserCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUserCase.getAllTourism().asLiveData()
}