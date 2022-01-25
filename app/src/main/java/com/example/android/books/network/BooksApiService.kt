package com.example.android.books.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =  "http://softpointdev.com/"

//create retrofit builder which will fetch a json response from
// web service and return as String
private val retrofit = Retrofit.Builder()
//       pass in ScalarsCoverterFactory to
//       scalars converter that supports returning Strings
    .addConverterFactory(ScalarsConverterFactory.create())
//        specify root web address by calling baseUrl and passing base url
    .baseUrl(BASE_URL)
//        call build to create object
    .build()

//define interface to explain how retrofit communicates with server using http request
interface BooksApiService {
//    get JSON response string
//    use @GET annotation to tell retrofit what method does
    @GET("sdk/api/v01/book_data.php")
    fun getProperties():
//        Call object starts request
        Call<String>
}

//expose Retrofit service to the rest of application using public object
object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}