package co.aladinjunior.tournamentsimulator

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    val id: Int,
    @StringRes val itemName: Int,
    @DrawableRes val itemIcon: Int,
    val color: Int
)
