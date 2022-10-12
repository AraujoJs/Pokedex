package co.araujoarthur.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.model.PokeItem
import co.araujoarthur.pokedex.presenter.ListPresenter
import com.xwray.groupie.GroupieAdapter

class ListActivity : AppCompatActivity() {

    private lateinit var progressList: ProgressBar
    lateinit var presenter: ListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        progressList = findViewById(R.id.progress_list)
        presenter = ListPresenter(this)
        val name = findViewById<TextView>(R.id.txt_item_list)
        val recycle = findViewById<RecyclerView>(R.id.rv_list)


        recycle.layoutManager = LinearLayoutManager(this)
        val adapter = GroupieAdapter()
        recycle.adapter = adapter

        presenter.findPokemons()

    }

    fun showPokemons(pokeItems: List<PokeItem>) {
        Toast.makeText(this, pokeItems.toString(), Toast.LENGTH_SHORT).show()
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