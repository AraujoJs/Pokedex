package co.araujoarthur.pokedex.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.model.Pokemon
import co.araujoarthur.pokedex.presenter.ListPresenter
import com.xwray.groupie.GroupieAdapter

class ListActivity : AppCompatActivity() {

    private lateinit var progressList: ProgressBar
    lateinit var presenter: ListPresenter
    private val adapter = GroupieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        progressList = findViewById(R.id.progress_list)
        presenter = ListPresenter(this)

        val recycle = findViewById<RecyclerView>(R.id.rv_list)

        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = adapter

        presenter.findPokemons()

        adapter.setOnItemClickListener { item, view ->
            val pokemon = (item as ItemList).pokemon
            val intent = Intent(this, PokeDescActivity::class.java)
            intent.putExtra("url", pokemon.url)
            startActivity(intent)
        }
    }

    fun showPokemons(pokeItems: List<Pokemon>) {
        val pokemons = pokeItems.map { ItemList(it) }
        adapter.addAll(pokemons)
        adapter.notifyDataSetChanged()
    }

    fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showProgress() {
        progressList.visibility = View.VISIBLE
    }
    fun hideProgress() {
        progressList.visibility = View.GONE
    }


}