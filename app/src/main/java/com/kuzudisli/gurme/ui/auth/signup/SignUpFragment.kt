package com.kuzudisli.gurme.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.kuzudisli.domain.model.SignUpResult
import com.kuzudisli.gurme.MainActivity
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentSignUpBinding
import com.kuzudisli.gurme.utils.NavigationUtils
import org.koin.android.ext.android.inject

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignUpViewModel by inject()

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUpButton: Button
    private lateinit var haveAnAccountText: TextView
    private lateinit var name: EditText
    private lateinit var surname: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observers()
    }

    private fun initUI() {
        email = binding.signUpEmailEditText
        password = binding.signUpPasswordEditText
        signUpButton = binding.signUpButton
        haveAnAccountText = binding.forgotPassword
        name = binding.signUpNameEditText
        surname = binding.signUpLastNameEditText

        haveAnAccountText.setOnClickListener {
            NavigationUtils.navigateToFragment(this, R.id.action_signUpFragment_to_loginFragment)
        }

        signUpButton.setOnClickListener {
            viewModel.signUp(name.text.toString(), surname.text.toString(), email.text.toString(), password.text.toString())
        }

        val passwordEditText = binding.signUpPassword.editText
        passwordEditText?.let { password ->
            binding.signUpPassword.setStartIconOnClickListener {
                val currentTransformationMethod = password.transformationMethod
                password.transformationMethod =
                    if (currentTransformationMethod == PasswordTransformationMethod.getInstance()) {
                        binding.signUpPassword.setStartIconDrawable(R.drawable.ic_pswhide)
                        HideReturnsTransformationMethod.getInstance()
                    } else {
                        binding.signUpPassword.setStartIconDrawable(R.drawable.ic_pswsee)
                        PasswordTransformationMethod.getInstance()
                    }
                password.setSelection(password.text?.length ?: 0)
            }
        }

    }

    private fun observers() {
        viewModel.signUpResult.observe(viewLifecycleOwner) { result ->
            when (result) {
                is SignUpResult.Success -> navigateToHomePage()
                is SignUpResult.Failure -> showErrorMessage(result.error)
                else -> {

                }
            }
        }
    }

    private fun navigateToHomePage() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun showErrorMessage(error: String) {
        // Show error message
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

}