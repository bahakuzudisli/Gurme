package com.kuzudisli.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T> : ViewModel() {
    private val _state = MutableStateFlow<Resource<T>>(Resource.Loading())
    val state: StateFlow<Resource<T>> = _state.asStateFlow()

    protected fun postState(newState: Resource<T>) {
        _state.value = newState
    }
}