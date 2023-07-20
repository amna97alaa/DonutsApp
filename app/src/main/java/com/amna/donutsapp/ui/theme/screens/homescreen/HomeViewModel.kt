package com.amna.donutsapp.ui.theme.screens.homescreen

import androidx.lifecycle.ViewModel
import com.amna.donutsapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getDonutOffers()
        getDonut()
    }

    private fun getDonutOffers() {
        _state.update {
            it.copy(
                donutOffers = listOf(
                    DonutOffersUiState(
                        title = "Strawberry Wheel",
                        description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                        imageRes = R.drawable.donutpink_card,
                        oldPrice = "$10",
                        newPrice = "$20"
                    ),
                    DonutOffersUiState(
                        title = "Chocolate Glaze",
                        description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                        imageRes = R.drawable.donutbrown_card,
                        oldPrice = "$10",
                        newPrice = "$20"
                    ),
                )
            )
        }
    }

    private fun getDonut() {
        _state.update {
            it.copy(
                donut = listOf(
                    DonutUiState(
                        name = "Chocolate Cherry",
                        image = R.drawable.donut1,
                        price = "$10",
                    ),
                    DonutUiState(
                        name = "Strawberry Rain",
                        image = R.drawable.donut2,
                        price = "$10",
                    ),
                    DonutUiState(
                        name = "Strawberry Coco",
                        image = R.drawable.donut3,
                        price = "$10",
                    )
                )
            )
        }
    }
}