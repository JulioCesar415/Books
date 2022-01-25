package com.example.android.books.bookDetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.books.network.BookProperty

class BookDetailViewModelFactory (
    private val bookProperty: BookProperty,
    private val application: Application
        ): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(BookDetailViewModel::class.java)){
            return BookDetailViewModel(bookProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}