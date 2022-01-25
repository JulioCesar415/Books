package com.example.android.books.bookList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.books.network.BookProperty
import com.example.android.books.network.BooksApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
//        call BooksApi which returns a call object
//        call enqueue on callback to start network request on background thread
        BooksApi.retrofitService.getProperties().enqueue(object : Callback<List<BookProperty>> {
            override fun onResponse(call: Call<List<BookProperty>>, response: Response<List<BookProperty>>) {
                _response.value = "Success: ${response.body()?.size} Book properties retrieved"
            }

            override fun onFailure(call: Call<List<BookProperty>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

        })
//        _response.value = "Set Book API response here"
    }
}