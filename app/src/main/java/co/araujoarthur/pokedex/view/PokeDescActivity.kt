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
import java.lang.RuntimeException

class PokeDescActivity : AppCompatActivity() {

    lateinit var pokemonHp: TextView
    lateinit var pokemonAttack: TextView
    lateinit var pokemonDefense: TextView
    lateinit var pokemonSpecialAttack: TextView
    lateinit var progress: ProgressBar
    lateinit var presenter: PokeDescPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_desc)
        val pokemon = intent?.extras?.getString("pokemon")
        val url = intent?.extras?.getString("url")

        findViewById<TextView>(R.id.txt_poke_name).text = pokemon
        pokemonHp = findViewById(R.id.txt_poke_hp)
        pokemonAttack = findViewById(R.id.txt_poke_attack)
        pokemonDefense = findViewById(R.id.txt_poke_defense)
        pokemonSpecialAttack = findViewById(R.id.txt_poke_special_attack)
        progress = findViewById(R.id.progress_poke_desc)

        if (url != null) {
            presenter = PokeDescPresenter(this, url)

        }

        presenter.findStatus()


    }

    fun showStatus(pokemonStatus: Pokemon) {
        pokemonStatus.status?.map {
            when (it.stat?.name) {
                "hp" -> pokemonHp.text = getString(R.string.txt_poke_hp, it.baseStatus.toString())
                "attack" -> pokemonAttack.text = getString(R.string.txt_poke_attack, it.baseStatus.toString())
                "defense" -> pokemonDefense.text = getString(R.string.txt_poke_defense, it.baseStatus.toString())
                "special-attack" -> pokemonSpecialAttack.text = getString(R.string.txt_poke_special_attack, it.baseStatus.toString())
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