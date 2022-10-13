package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.Pokemon

interface PokeDescCallback {
    fun onSuccess(pokemon: Pokemon)
    fun onFailure(message: String)
    fun onComplete()
}