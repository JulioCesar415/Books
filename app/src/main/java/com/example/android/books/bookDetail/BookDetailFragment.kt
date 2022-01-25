package com.example.android.books.bookDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.books.R
import com.example.android.books.databinding.FragmentBookDetailBinding

class BookDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding: FragmentBookDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_book_detail, container, false
        )
        binding.lifecycleOwner = this

        return binding.root
    }

}