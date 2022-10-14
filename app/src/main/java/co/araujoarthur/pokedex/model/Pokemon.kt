package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("order") val order: Int? = null,
    @SerializedName("height") val height: Int? = null,
    @SerializedName("weight") val weight: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("stats") val status: List<PokemonStatus>? = null,
    @SerializedName("sprites") val sprites: PokemonStatus? = null,
    @SerializedName("types") val types: List<PokemonStatus>? = null
    )
