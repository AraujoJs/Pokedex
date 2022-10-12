package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokeItem(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val result: List<Pokemon>
)
