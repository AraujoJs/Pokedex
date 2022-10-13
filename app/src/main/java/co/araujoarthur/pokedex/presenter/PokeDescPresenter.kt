package co.araujoarthur.pokedex.presenter

import co.araujoarthur.pokedex.data.PokeDescCallback
import co.araujoarthur.pokedex.data.PokeDescResourceDatabase
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.view.PokeDescActivity

class PokeDescPresenter(
    private val view: PokeDescActivity,
    private val url: String,
    private val database: PokeDescResourceDatabase = PokeDescResourceDatabase()


    ): PokeDescCallback {

    fun findStatus() {
        view.showProgress()
        val newUrl = url.removePrefix("https://pokeapi.co/")
        database.findStatus(this, newUrl)


    }

    override fun onSuccess(pokemon: Pokemon) {
        view.showStatus(pokemon)
    }

    override fun onFailure(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}