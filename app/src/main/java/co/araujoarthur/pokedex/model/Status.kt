package co.araujoarthur.pokedex.model

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
