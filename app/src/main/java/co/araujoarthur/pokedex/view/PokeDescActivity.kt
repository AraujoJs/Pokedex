package co.araujoarthur.pokedex.view

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.presenter.PokeDescPresenter
import com.squareup.picasso.Picasso

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
                "hp" -> findViewById<TextView>(R.id.txt_poke_hp).text =
                    getString(R.string.txt_poke_hp, it.baseStatus.toString())
                "attack" -> findViewById<TextView>(R.id.txt_poke_attack).text =
                    getString(R.string.txt_poke_attack, it.baseStatus.toString())
                "defense" -> findViewById<TextView>(R.id.txt_poke_defense).text =
                    getString(R.string.txt_poke_defense, it.baseStatus.toString())
                "special-attack" -> findViewById<TextView>(R.id.txt_poke_special_attack).text =
                    getString(R.string.txt_poke_special_attack, it.baseStatus.toString())
            }
        }

        findViewById<TextView>(R.id.txt_poke_height).text = presenter.getCalcul(pokemonStatus.height)
        findViewById<TextView>(R.id.txt_poke_weight).text = presenter.getCalcul(pokemonStatus.weight)

        findViewById<TextView>(R.id.txt_poke_name).text =
            presenter.getNameFormated(pokemonStatus.order ?: 0, pokemonStatus.name ?: "None")


        val imgFront = findViewById<ImageView>(R.id.img_poke_front)
        val imgBack = findViewById<ImageView>(R.id.img_poke_back)
        Picasso.get().load(pokemonStatus.sprites?.frontDefault).into(imgFront)
        Picasso.get().load(pokemonStatus.sprites?.backDefault).into(imgBack)

        val btnType1 = findViewById<Button>(R.id.btn_poke_type)
        val btnType2 = findViewById<Button>(R.id.btn_poke_type2)

        if (pokemonStatus.types != null) {
            if (pokemonStatus.types.size > 1) {
                btnType1.apply {
                    text = pokemonStatus.types[0].type?.name
                    visibility = View.VISIBLE
                    setBackgroundColor(presenter.getTypeColors(pokemonStatus.types[0]))
                }
                btnType2.apply {
                    text = pokemonStatus.types[1].type?.name
                    visibility = View.VISIBLE
                    setBackgroundColor(presenter.getTypeColors(pokemonStatus.types[1]))
                }
            }else {
                btnType1.apply {
                    text = pokemonStatus.types[0].type?.name
                    visibility = View.VISIBLE
                    setBackgroundColor(presenter.getTypeColors(pokemonStatus.types[0]))
                }
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
