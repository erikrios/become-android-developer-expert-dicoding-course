package io.github.erikrios.mysimplecleanarchitecture.domain

import io.github.erikrios.mysimplecleanarchitecture.data.IMessageDataSource

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String) =
        MessageEntity("Hello $name! Welcome to Clean Architecture")
}