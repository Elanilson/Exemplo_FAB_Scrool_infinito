package br.com.apkdoandroid.exemplofabecarregamentoinfinito.dapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.R
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.databinding.ItemBinding
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.viewholder.ItemViewHolder

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private var lista : MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(lista.get(position))
    }

    fun attackLista(lista : List<String>){
        this.lista.addAll(lista)
        notifyDataSetChanged()
    }
}