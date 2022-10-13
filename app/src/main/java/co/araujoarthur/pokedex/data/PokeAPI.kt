package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.PokeItem
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.model.PokemonStatus
import co.araujoarthur.pokedex.model.Status
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {

    @GET("api/v2/pokemon?limit=100000&offset=0")
    fun findPokemons(): Call<PokeItem>

    @GET("{url}")
    fun findStatus(@Path("url") url: String): Call<Pokemon>

}