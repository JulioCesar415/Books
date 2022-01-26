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
    private val _response = MutableLiveData<String>()
//    external LiveData for requests status String
    val response: LiveData<String>
    get() = _response

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
                _response.value = "Success: ${listResult.size} Book properties retrieved"
            }catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }
        }

    }
}