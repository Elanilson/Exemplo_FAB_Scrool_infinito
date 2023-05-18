package br.com.apkdoandroid.exemplofabecarregamentoinfinito.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item : String){
        var textView : TextView = itemView.findViewById(R.id.textViewItem)
        textView.setText(item)
    }
}