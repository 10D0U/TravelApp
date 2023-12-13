package com.projects.travelapp.Domains

import java.io.Serializable

data class PopularDomain(
    val title: String,
    val location: String,
    val description: String,
    val bed: Int,
    val guide: Boolean,
    val score: Double,
    val pic: String,
    val wifi: Boolean,
    val price: Int
): Serializable
