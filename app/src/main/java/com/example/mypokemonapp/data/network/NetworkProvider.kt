package com.example.mypokemonapp.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object NetworkProvider {
    private const val POKEMON_URL = "https://pokeapi.co/api/v2/"

    private fun retrofit(
        urlBase: String
    ): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLoggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()
    }

    fun providePokemonApi(): PokemonApi {
        return retrofit(POKEMON_URL).create(PokemonApi::class.java)
    }
}