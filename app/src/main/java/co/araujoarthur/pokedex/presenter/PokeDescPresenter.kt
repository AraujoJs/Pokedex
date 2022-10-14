package co.araujoarthur.pokedex.presenter

import android.graphics.Color
import androidx.annotation.StringRes
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.data.PokeDescCallback
import co.araujoarthur.pokedex.data.PokeDescResourceDatabase
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.model.PokemonStatus
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

    fun getTypeColors(pokemon: PokemonStatus): Int {

        return when(pokemon.type?.name) {
            "grass" -> Color.GREEN
            "poison" -> Color.MAGENTA
            "fire" -> Color.RED
            "water" -> Color.BLUE
            "dragon" -> Color.MAGENTA
            "flying" -> Color.MAGENTA
            "dark" -> Color.BLACK
            "normal" -> Color.LTGRAY
            "electric" -> Color.YELLOW
            "bug" -> Color.GREEN
            "ice" -> Color.WHITE
            "ground" -> Color.GRAY
            "rock" -> Color.DKGRAY
            "steel" -> Color.BLACK
            "psychic" -> Color.MAGENTA
            "ghost" -> Color.WHITE
            "fairy" -> Color.MAGENTA
            "fighting" -> Color.RED
            else -> Color.TRANSPARENT
        }
    }

    fun getCalcul(status: Int?): String {
        return view.getString(R.string.txt_poke_height, (status?.div(10.0)).toString())
    }

    fun getNameFormated(order: Int, name: String? ): String {
        return when {
            order < 10 -> view.getString(R.string.txt_poke_name_format_9, name, order.toString())
            order < 100 -> view.getString(R.string.txt_poke_name_format_99, name, order.toString())
            else -> view.getString(R.string.txt_poke_name_format_999, name, order.toString())
        }
    }

}