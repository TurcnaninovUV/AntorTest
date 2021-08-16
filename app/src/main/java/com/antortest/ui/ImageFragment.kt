package com.antortest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antortest.R
import com.antortest.databinding.FragmentImageBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentImageBinding.inflate(inflater, container, false)
        when (arguments?.getInt("image")) {
            1 -> binding.imageViewShow.setImageResource(R.mipmap.ic_image1)
            2 -> binding.imageViewShow.setImageResource(R.mipmap.ic_image2)
            3 -> binding.imageViewShow.setImageResource(R.mipmap.ic_image3)
        }
        return binding.root
    }
}
