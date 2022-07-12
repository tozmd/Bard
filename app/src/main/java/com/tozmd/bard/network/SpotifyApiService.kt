package com.tozmd.bard.network

import com.tozmd.bard.data.api.ApiConstants.BASE_URL
import com.tozmd.bard.data.api.ApiConstants.END_POINT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

//Retrofit object w/ Spotify API base URL and converter factory
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//Singleton object to initialize Retrofit
object SpotifyApi {
    val retrofitService: SpotifyApiService by lazy {
        retrofit.create(SpotifyApiService::class.java)
    }
}

//Define how retrofit talks to web server
interface SpotifyApiService {
    @GET(END_POINT)
    //Suspend makes the function callable from within a coroutine
    suspend fun getRecommendedSongs(): String
}
