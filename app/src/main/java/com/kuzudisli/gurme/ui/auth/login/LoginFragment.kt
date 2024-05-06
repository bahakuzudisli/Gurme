package com.kuzudisli.gurme.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.work.ListenableWorker
import androidx.work.WorkInfo
import com.kuzudisli.domain.model.LoginResult
import com.kuzudisli.gurme.MainActivity
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentLoginBinding
import com.kuzudisli.gurme.utils.NavigationUtils
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    val viewModel: LoginViewModel by inject()


    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPassword: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observers()
    }

    private fun initUI() {
        email = binding.loginEmailEditText
        password = binding.loginPasswordEditText
        loginButton = binding.loginButton
        forgotPassword = binding.forgotPassword

        forgotPassword.setOnClickListener {
            NavigationUtils.navigateToFragment(this, R.id.action_loginFragment_to_signUpFragment)
        }

        loginButton.setOnClickListener {
            viewModel.login(email.text.toString(), password.text.toString())
        }

        val passwordEditText = binding.loginPassword.editText
        passwordEditText?.let { password ->
            binding.loginPassword.setStartIconOnClickListener {
                val currentTransformationMethod = password.transformationMethod
                password.transformationMethod =
                    if (currentTransformationMethod == PasswordTransformationMethod.getInstance()) {
                        binding.loginPassword.setStartIconDrawable(R.drawable.ic_pswhide)
                        HideReturnsTransformationMethod.getInstance()
                    } else {
                        binding.loginPassword.setStartIconDrawable(R.drawable.ic_pswsee)
                        PasswordTransformationMethod.getInstance()
                    }
                password.setSelection(password.text?.length ?: 0)
            }
        }
    }

    private fun observers() {
        viewModel.loginResult.observe(viewLifecycleOwner){ workInfo ->
            if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                // Login işlemi başarılı
                // UI'ı güncelle veya başka bir aktiviteye geç
                navigateToHomePage()
            } else if (workInfo.state == WorkInfo.State.FAILED) {
                // Hata yönetimi
                showErrorMessage("Login Failed")
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