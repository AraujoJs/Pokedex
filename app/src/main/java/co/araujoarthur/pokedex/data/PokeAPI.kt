package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.ListItem
import co.araujoarthur.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {

    @GET("api/v2/pokemon?limit=100000&offset=0")
    fun findPokemons(): Call<ListItem>

    @GET("{url}")
    fun findStatus(@Path("url") url: String): Call<Pokemon>

}