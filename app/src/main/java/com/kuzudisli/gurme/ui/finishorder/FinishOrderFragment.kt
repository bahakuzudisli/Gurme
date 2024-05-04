package com.kuzudisli.gurme.ui.finishorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kuzudisli.gurme.databinding.FragmentFinishOrderBinding


class FinishOrderFragment : Fragment() {
    private var _binding: FragmentFinishOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentFinishOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

}