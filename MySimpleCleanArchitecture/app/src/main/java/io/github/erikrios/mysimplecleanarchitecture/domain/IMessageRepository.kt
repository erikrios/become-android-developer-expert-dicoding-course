package io.github.erikrios.mysimplecleanarchitecture.domain

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}