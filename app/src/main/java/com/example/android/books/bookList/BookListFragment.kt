package com.example.android.books.bookList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.books.R
import com.example.android.books.databinding.FragmentBookListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {

    private val viewModel: BookListViewModel by lazy {
        ViewModelProvider(this).get(BookListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_book_list, container, false)
        val binding: FragmentBookListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_book_list, container, false
        )

//        allow data binding to observe liveData with the lifecycle of this fragment
        binding.lifecycleOwner = this

//        give binding access to BookListViewModel
        binding.viewModel = viewModel

//        enable options menu
        setHasOptionsMenu(true)

//        return root view that all views are bind to
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}