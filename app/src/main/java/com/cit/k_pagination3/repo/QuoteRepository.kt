package com.cit.k_pagination3.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.cit.k_pagination3.api.QuotesApi
import com.cit.k_pagination3.paging.QuotePagingSource
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quotesApi: QuotesApi) {


    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quotesApi) }
    ).liveData
}