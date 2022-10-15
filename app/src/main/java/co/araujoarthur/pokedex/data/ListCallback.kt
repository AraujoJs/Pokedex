package co.araujoarthur.pokedex.data

import co.araujoarthur.pokedex.model.ListItem

interface ListCallback {
    fun onSuccess(listItems: ListItem)
    fun onError(message: String)
    fun onComplete()
}