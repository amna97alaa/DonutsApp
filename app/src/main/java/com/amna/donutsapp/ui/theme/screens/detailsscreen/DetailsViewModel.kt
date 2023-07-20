package com.amna.donutsapp.ui.theme.screens.detailsscreen

import androidx.lifecycle.ViewModel
import com.amna.donutsapp.ui.theme.screens.homescreen.DonutOffersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()


    fun increaseQuantity() {
        if (state.value.donutOffers.quantity < 16) {
            _state.update {
                it.copy(
                    donutOffers = DonutOffersUiState(
                        quantity = (it.donutOffers.quantity + 1),
                        newPrice = (it.donutOffers.newPrice.toInt() * 2).toString()
                    )
                )
            }
        }

    }

    fun decreaseQuantity() {
        if (state.value.donutOffers.quantity > 1) {
            _state.update {
                it.copy(
                    donutOffers = DonutOffersUiState(
                        quantity = (it.donutOffers.quantity - 1),
                        newPrice = (it.donutOffers.newPrice.toInt() / it.donutOffers.quantity).toString()
                    )
                )
            }
        }
    }

}