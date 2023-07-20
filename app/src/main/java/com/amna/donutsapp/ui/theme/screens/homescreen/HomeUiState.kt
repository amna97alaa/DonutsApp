package com.amna.donutsapp.ui.theme.screens.homescreen

data class HomeUiState(
    val donutOffers: List<DonutOffersUiState> = emptyList(),
    val donut: List<DonutUiState> = emptyList(),
)
data class DonutOffersUiState(
    val title: String="",
    val description: String="",
    val imageRes: Int=0,
    val oldPrice: String="",
    val newPrice: String="16",
    var quantity:Int= 1,
)
data class DonutUiState(
    val name:String="",
    val image:Int=0,
    val price:String="",
)