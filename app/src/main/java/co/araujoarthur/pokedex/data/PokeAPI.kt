package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.PokeItem
import retrofit2.Call
import retrofit2.http.GET

interface PokeAPI {

    @GET("api/v2/pokemon?limit=100000&offset=0")
    fun findPokemons(): Call<List<PokeItem>>

}