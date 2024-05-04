package com.kuzudisli.gurme.ui.menudetail

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentMenuDetailBinding


class MenuDetailFragment : Fragment() {


    private var _binding: FragmentMenuDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuDetailToolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        menuDetailToolbar = binding.detailedToolbar
        menuDetailToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val chipTexts = listOf(
            "turşu",
            "marul",
            "domates",
            "biber",
            "soğan",
            "maydanoz"
        )

        val chipGroup = binding.chipGroup

        for (chipText in chipTexts) {
            val chip = Chip(requireContext())
            chip.id = View.generateViewId()
            chip.text = chipText
            chip.chipStrokeColor =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black))
            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            chip.isClickable = true

            // Chip'in tıklanma durumunu takip etmek için bir değişken
            var isClicked = false

            chip.setOnClickListener {
                // Tıklama durumunu değiştir
                isClicked = !isClicked

                // Duruma göre arka plan ve metin rengini değiştir
                if (isClicked) {
                    chip.setChipBackgroundColorResource(R.color.blackTone)
                    chip.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            android.R.color.white
                        )
                    )
                } else {
                    chip.setChipBackgroundColorResource(R.color.white)
                    chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackTone))
                }
            }

            chipGroup.addView(chip)
        }


    }

}