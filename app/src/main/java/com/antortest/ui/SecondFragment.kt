package com.antortest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.antortest.R
import com.antortest.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.imageView.setOnClickListener {
            sendImage(1)
        }

        binding.imageView2.setOnClickListener {
            sendImage(2)
        }

        binding.imageView3.setOnClickListener {
            sendImage(3)
        }

        return binding.root
    }

    private fun sendImage(number: Int) {
        val arg = Bundle()
        arg.putInt("image", number)
        findNavController().navigate(R.id.action_feedFragment_to_imageFragment, arg)
    }
}

