package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("stats") val status: List<PokemonStatus>? = null
)
