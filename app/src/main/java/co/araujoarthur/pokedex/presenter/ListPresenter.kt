package co.araujoarthur.pokedex.presenter

import co.araujoarthur.pokedex.data.ListCallback
import co.araujoarthur.pokedex.data.ListResourceDatabase
import co.araujoarthur.pokedex.model.PokeItem
import co.araujoarthur.pokedex.view.ListActivity

class ListPresenter(
    val view: ListActivity,
    val database: ListResourceDatabase = ListResourceDatabase()
    ): ListCallback {
    fun findPokemons() {
        view.showProgress()
        database.findAll(this)

    }

    override fun onSuccess(pokeItems: PokeItem) {
        view.showPokemons(pokeItems.result)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}