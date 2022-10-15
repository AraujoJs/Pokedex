package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.ListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class ListResourceDatabase {

    fun findAll(callback: ListCallback) {
        HTTPClient.retrofit()
            .create(PokeAPI::class.java)
            .findPokemons()
            .enqueue(object : Callback<ListItem> {
                override fun onResponse(
                    call: Call<ListItem>,
                    response: Response<ListItem>
                ) {
                    if (response.isSuccessful) {
                        val pokemons = response.body()
                        callback.onSuccess(pokemons ?: throw RuntimeException("Pokemons não encontrados."))
                    } else {
                        val error = response.errorBody()?.toString()
                        callback.onError(error ?: "Erro desconhecido.")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<ListItem>, t: Throwable) {
                    callback.onError(t.message.toString())
                    callback.onComplete()
                }

            })
    }
}