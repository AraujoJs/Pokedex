package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.model.Status
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class PokeDescResourceDatabase {

    fun findStatus(callback: PokeDescCallback, url: String) {
        HTTPClient.retrofit()
            .create(PokeAPI::class.java)
            .findStatus(url)
            .enqueue(object : Callback<Pokemon> {
                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        callback.onSuccess(body ?: throw RuntimeException("Status não encontrado!"))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onFailure(error ?: "Erro desconhecido.")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    callback.onFailure(t.message.toString())
                    callback.onComplete()
                }

            })
    }

}