package com.cit.k_pagination3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.cit.k_pagination3.databinding.ActivityMainBinding
import com.cit.k_pagination3.paging.LoaderAdapter
import com.cit.k_pagination3.paging.PagingAdapter
import com.cit.viewmodels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PagingAdapter
    private lateinit var viewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        adapter = PagingAdapter()

        binding.quoteRecyclerview.setHasFixedSize(true)
        binding.quoteRecyclerview.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )


        viewModel.quoteList.observe(this) {
            adapter.submitData(lifecycle, it)




        }


    }
}