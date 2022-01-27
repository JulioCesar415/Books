package com.example.android.books.bookList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.books.network.BookProperty
import com.example.android.books.network.BookResponse
import com.example.android.books.network.BooksApi
import kotlinx.coroutines.launch


class BookListViewModel : ViewModel(){

//    internal MutableLiveData String stores status of most recent request
    private val _status = MutableLiveData<String>()
//    external LiveData for requests status String
    val status: LiveData<String>
    get() = _status

//    internal MutableLiveData data class stores book
    private val _book = MutableLiveData<BookProperty>()
//    external LiveData for requests book data class
    val book: LiveData<BookProperty>
    get() = _book

    init {
        getBookProperties()
    }


//    method calls Retrofit service and handles returned JSON String
    private fun getBookProperties(){
////        call BooksApi which returns a call object
////        call enqueue on callback to start network request on background thread
//        BooksApi.retrofitService.getProperties().enqueue(object : Callback<List<BookResponse>> {
//            override fun onResponse(call: Call<List<BookResponse>>, response: Response<List<BookResponse>>) {
//                _response.value = "Success: ${response.body()?.size} Book properties retrieved"
//            }
//
//            override fun onFailure(call: Call<List<BookResponse>>, t: Throwable) {
//                _response.value = "Failure: " + t.message
//            }
//
//        })
        viewModelScope.launch{
            try {
                var listResult = BooksApi.retrofitService.getProperties()
                _status.value = "Success: ${listResult.size} Book properties retrieved"
                if (listResult.size > 0){
                    _book.value = listResult[0]
                }
            }catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}