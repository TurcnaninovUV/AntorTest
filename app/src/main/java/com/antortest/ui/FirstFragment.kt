package com.antortest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.antortest.adapter.FieldsAdapter
import com.antortest.databinding.FragmentFirstBinding
import com.antortest.dto.Fields
import com.antortest.viewmodel.FieldsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


val insertList = listOf(
    Fields("один", 1, 1.1, showString = false, showInt = false, showDouble = false),
    Fields("два", 2, 2.1, showString = false, showInt = false, showDouble = false),
    Fields("три", 3, 3.1, showString = false, showInt = false, showDouble = false),
    Fields("четыре", 4, 4.1, showString = false, showInt = false, showDouble = false),
    Fields("пять", 5, 5.1, showString = false, showInt = false, showDouble = false),
    Fields("шесть", 6, 6.1, showString = false, showInt = false, showDouble = false),
    Fields("семь", 7, 7.1, showString = false, showInt = false, showDouble = false)
)


@AndroidEntryPoint
class FirstFragment : Fragment() {

    @ExperimentalCoroutinesApi
    private val viewModel: FieldsViewModel by viewModels(ownerProducer = ::requireParentFragment)

    @ExperimentalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        val adapter = FieldsAdapter()

        binding.container.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner) { listFields ->
            adapter.submitList(listFields)
        }

        viewModel.load(insertList)

        binding.intDB.setOnClickListener {
            viewModel.intShow()
            adapter.notifyDataSetChanged()
        }

        binding.doubleDB.setOnClickListener {
            viewModel.doubleShow()
            adapter.notifyDataSetChanged()
        }

        binding.stringDB.setOnClickListener {
            viewModel.stringShow()
            adapter.notifyDataSetChanged()
        }

        return binding.root
    }
}