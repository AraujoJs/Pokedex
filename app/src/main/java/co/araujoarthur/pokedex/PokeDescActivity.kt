package co.araujoarthur.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class PokeDescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_desc)
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()

    }
}