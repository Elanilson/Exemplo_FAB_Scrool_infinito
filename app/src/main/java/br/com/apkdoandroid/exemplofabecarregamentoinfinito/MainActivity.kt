package br.com.apkdoandroid.exemplofabecarregamentoinfinito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView.OnScrollListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.dapter.ItemAdapter
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.databinding.ActivityMainBinding
import br.com.apkdoandroid.exemplofabecarregamentoinfinito.helpers.NomeUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ItemAdapter()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var carregar = 50;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //adapeter
        adapter.attackLista(NomeUtils.getListaNomes())
        //recyclerView
        linearLayoutManager  = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                /**
                 * Verifique se esta exibição pode ser rolada verticalmente em uma determinada direção.
                    Isso não importa se a visualização está habilitada ou não, ou se rolará em resposta à entrada do usuário ou não.
                    Parâmetros:
                    direção – Negativo para verificar a rolagem para cima, positivo para verificar a rolagem para baixo.
                    Retorna:
                    true se esta exibição puder ser rolada na direção especificada, false caso contrário.
                 */

                // ==== ROLAGEM INFINITA
                var retorno = recyclerView.canScrollVertically(1)
                Log.d("recyclerView_teste","infinito: ${retorno}")
                if(!retorno){
                    adapter.attackLista(NomeUtils.getListaNomes(carregar))
                }

                //=========== FAB
                //esconde fab somente no ultimo item
                var ultimoVisivel = linearLayoutManager.findLastVisibleItemPosition()
                var totalItens = binding.recyclerView.adapter?.itemCount
                if(ultimoVisivel != null && totalItens != null){
                    if(totalItens -1 == ultimoVisivel){
                        binding.floatingActionButton.hide()
                    }else{
                        binding.floatingActionButton.show()
                    }
                }

                Log.d("recyclerView_teste","onScrolled: DX: ${dx}, DY: ${dy}")
                // esconde quando rola para baixo
              /*  if(dy > 0){
                    binding.floatingActionButton.hide()
                }else{
                    binding.floatingActionButton.show()
                }*/
            }
        })
    }

}