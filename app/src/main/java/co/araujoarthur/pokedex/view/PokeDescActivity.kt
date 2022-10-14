package co.araujoarthur.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.presenter.PokeDescPresenter
import org.w3c.dom.Text
import java.lang.RuntimeException

class PokeDescActivity : AppCompatActivity() {

    lateinit var progress: ProgressBar
    lateinit var presenter: PokeDescPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_desc)
        val url = intent?.extras?.getString("url")



        progress = findViewById(R.id.progress_poke_desc)

        if (url != null) {
            presenter = PokeDescPresenter(this, url)

        }

        presenter.findStatus()


    }

    fun showStatus(pokemonStatus: Pokemon) {
        pokemonStatus.status?.map {
            when (it.stat?.name) {
                "hp" -> findViewById<TextView>(R.id.txt_poke_hp).text = getString(R.string.txt_poke_hp, it.baseStatus.toString())
                "attack" -> findViewById<TextView>(R.id.txt_poke_attack).text = getString(R.string.txt_poke_attack, it.baseStatus.toString())
                "defense" -> findViewById<TextView>(R.id.txt_poke_defense).text = getString(R.string.txt_poke_defense, it.baseStatus.toString())
                "special-attack" -> findViewById<TextView>(R.id.txt_poke_special_attack).text = getString(R.string.txt_poke_special_attack, it.baseStatus.toString())
            }
        }

        findViewById<TextView>(R.id.txt_poke_height).text = getString(R.string.txt_poke_height, (pokemonStatus.height?.div(10.0)).toString())
        findViewById<TextView>(R.id.txt_poke_weight).text = getString(R.string.txt_poke_weight, (pokemonStatus.weight?.div(10.0)).toString())

        if (pokemonStatus.order != null) {
            findViewById<TextView>(R.id.txt_poke_name).text = when {
                pokemonStatus.order < 10 -> getString(R.string.txt_poke_name_format_9, pokemonStatus.name, pokemonStatus.order.toString())
                pokemonStatus.order < 100 -> getString(R.string.txt_poke_name_format_99, pokemonStatus.name, pokemonStatus.order.toString())
                else -> getString(R.string.txt_poke_name_format_999, pokemonStatus.name, pokemonStatus.order.toString())
            }
        }

    }
    fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        progress.visibility = View.VISIBLE
    }
    fun hideProgress() {
        progress.visibility = View.GONE
    }

}