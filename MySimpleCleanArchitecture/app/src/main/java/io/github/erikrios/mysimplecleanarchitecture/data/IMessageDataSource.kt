package io.github.erikrios.mysimplecleanarchitecture.data

import io.github.erikrios.mysimplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}