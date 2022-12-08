package com.cit.k_pagination3.api

import com.cit.k_pagination3.data.model.ResponseQuotes
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("/quotes")
    suspend fun getAllQuotes(@Query("page") page: Int): ResponseQuotes


}