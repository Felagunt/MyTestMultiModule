package com.example.mytestmultimodule.Route

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object RootGraph: Route

    @Serializable
    data class ArtDetails(val id: Int) : Route

    @Serializable
    data object ArtList : Route
}