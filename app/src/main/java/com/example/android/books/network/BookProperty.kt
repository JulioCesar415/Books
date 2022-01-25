package com.example.android.books.network

//data class with property names to match properties in JSON response
//Moshi matches these by name and fills data objects with values and types
data class BookProperty (

    val Author: String,
    val Title: String,
    val Published: Double,
    val Description: String)