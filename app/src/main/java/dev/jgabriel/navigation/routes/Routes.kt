package dev.jgabriel.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Profile(val id: String, val blah: String)

@Serializable
data class StringList(val items: List<String>)

@Serializable
object Modal
