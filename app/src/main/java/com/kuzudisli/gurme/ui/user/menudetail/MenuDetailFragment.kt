package com.kuzudisli.gurme.ui.user.menudetail

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.kuzudisli.domain.model.MenuModel
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentMenuDetailBinding
import org.koin.android.ext.android.inject


class MenuDetailFragment : Fragment() {


    private var _binding: FragmentMenuDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuDetailToolbar: MaterialToolbar

    val viewModel: MenuDetailViewModel by inject()


    private val args: MenuDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMenuDetailBinding.inflate(inflater, container, false)


        val menu = args.menuModel
        initUI(menu)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(menu: MenuModel) {
        menuDetailToolbar = binding.detailedToolbar
        menuDetailToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        menu.ingredients_to_remove = listOf("Sogan", "Domates", "Biber", "Maydanoz", "Tuz")
        val chipTexts = menu.ingredients_to_remove
        val chipGroup = binding.chipGroup

        for (chipText in chipTexts) {
            val chip = Chip(requireContext())
            chip.id = View.generateViewId()
            chip.text = chipText
            chip.chipStrokeColor = ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            chip.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            chip.setChipBackgroundColorResource(R.color.white)
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
                    chip.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.black
                        )
                    )
                }
            }

            chipGroup.addView(chip)
        }

        binding.menuName.text = menu.item_name
        binding.menuPriceText.text = "${menu.price} TL"
        binding.menuDescription.text = menu.description
        binding.addBasketButton.setOnClickListener {
            //viewModel.addMenuToCart()
        }
    }

    fun observers() {
        viewModel.askQuestion.observe(viewLifecycleOwner) {
            // AlertDialog göster
            showAlertDialog {
                viewModel.clearOrder()
            }
        }
    }

    fun showAlertDialog(operation: () -> Unit) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Order Alert")
        builder.setMessage("You have an order from another restaurant. Do you want to clear it?")
        builder.setPositiveButton("Yes") { dialog, which ->
            // Handle the user's positive action here
            operation()
        }
        builder.setNegativeButton("No") { dialog, which ->
            // Handle the user's negative action here
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}