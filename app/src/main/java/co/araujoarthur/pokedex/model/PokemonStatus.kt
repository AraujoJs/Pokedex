package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonStatus(
    @SerializedName("base_stat") val baseStatus: Int? = null,
    @SerializedName("effort") val effort: Int? = null,
    @SerializedName("stat") val stat: Status? = null,
    @SerializedName("back_default") val backDefault: String? = null,
    @SerializedName("front_default") val frontDefault: String? = null,
    @SerializedName("type") val type: Status? = null
)
