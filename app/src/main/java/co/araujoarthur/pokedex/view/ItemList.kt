package co.araujoarthur.pokedex.view

import android.view.View
import android.widget.TextView
import co.araujoarthur.pokedex.R
import co.araujoarthur.pokedex.model.PokeItem
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class ItemList(val pokeItem: PokeItem): Item<ItemList.PokemonViewHolder>() {

    override fun createViewHolder(itemView: View): PokemonViewHolder {
        return PokemonViewHolder(itemView)
    }

    class PokemonViewHolder(itemView: View): GroupieViewHolder(itemView)


    override fun bind(viewHolder: PokemonViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_item_list).text = pokeItem.count.toString()
    }

    override fun getLayout() = R.layout.item_list

}