package com.example.android.books.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =  " https://softpointdev.com/"

// create moshi object using moshi builder
private val moshi = Moshi.Builder()
//        add KotlinJsonAdapterFactory in order for Moshi annotation to work with Kotlin
    .add(KotlinJsonAdapterFactory())
//        build Moshi object
    .build()

//create retrofit builder which will fetch a json response from
// web service and return as String
private val retrofit = Retrofit.Builder()
//        add MoshiConverterFactory to notify Retrofit to use Moshi to convert
//        JSON response into Kotlin objects
    .addConverterFactory(MoshiConverterFactory.create(moshi))
//        specify root web address by calling baseUrl and passing base url
    .baseUrl(BASE_URL)
//        call build to create object
    .build()

//define interface to explain how retrofit communicates with server using http request
interface BooksApiService {
//    get JSON response string
//    use @GET annotation to tell retrofit what method does
    @GET("sdk/api/v01/book_data.php")
    suspend fun getProperties():
//        ask Retrofit to return a list of BookProperty objects from JSON array
        Call<List<BookResponse>>
}

//expose Retrofit service to the rest of application using public object
object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}