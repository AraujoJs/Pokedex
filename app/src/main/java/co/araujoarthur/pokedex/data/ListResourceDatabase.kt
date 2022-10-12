package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.PokeItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListResourceDatabase {

    fun findAll(callback: ListCallback) {
        HTTPClient.retrofit()
            .create(PokeAPI::class.java)
            .findPokemons()
            .enqueue(object : Callback<List<PokeItem>> {
                override fun onResponse(
                    call: Call<List<PokeItem>>,
                    response: Response<List<PokeItem>>
                ) {
                    if (response.isSuccessful) {
                        val pokemons = response.body()
                        callback.onSuccess(pokemons ?: emptyList())
                    } else {
                        val error = response.errorBody()?.toString()
                        callback.onError(error ?: "Erro desconhecido.")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<PokeItem>>, t: Throwable) {
                    callback.onError(t.message.toString())
                    callback.onComplete()
                }

            })
    }
}