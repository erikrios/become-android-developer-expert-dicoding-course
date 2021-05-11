package io.github.erikrios.mysimplecleanarchitecture.di

import io.github.erikrios.mysimplecleanarchitecture.data.IMessageDataSource
import io.github.erikrios.mysimplecleanarchitecture.data.MessageDataSource
import io.github.erikrios.mysimplecleanarchitecture.data.MessageRepository
import io.github.erikrios.mysimplecleanarchitecture.domain.IMessageRepository
import io.github.erikrios.mysimplecleanarchitecture.domain.MessageInteractor
import io.github.erikrios.mysimplecleanarchitecture.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}