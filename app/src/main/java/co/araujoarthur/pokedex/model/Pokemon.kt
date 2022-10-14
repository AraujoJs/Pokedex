package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("order") val order: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("stats") val status: List<PokemonStatus>? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("weight") val weight: Int? = null
)
