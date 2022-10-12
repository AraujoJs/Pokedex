package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.PokeItem

interface ListCallback {
    fun onSuccess(pokeItems: PokeItem)
    fun onError(message: String)
    fun onComplete()
}