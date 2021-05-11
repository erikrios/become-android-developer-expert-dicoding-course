package io.github.erikrios.mysimplecleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.erikrios.mysimplecleanarchitecture.di.Injection
import io.github.erikrios.mysimplecleanarchitecture.domain.MessageUseCase

class MainViewModelFactory(
    private val messageUseCase: MessageUseCase
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideUseCase())
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}