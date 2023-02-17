package com.example.taskapp.models

data class MovieModel(
    val errorMessage: String,
    val items: List<Item>
) {
    data class Item(
        val crew: String?,
        val fullTitle: String?,
        val id: String?,
        val imDbRating: String?,
        val imDbRatingCount: String?,
        val image: String?,
        val rank: String?,
        val title: String?,
        val year: String?
    )
}