package com.kuzudisli.gurme.orderdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentOrderDetailBinding


class OrderDetailFragment : Fragment() {

    private var binding: FragmentOrderDetailBinding?= null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_detail, container, false)
    }


}