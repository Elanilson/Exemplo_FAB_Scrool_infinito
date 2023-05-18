package br.com.apkdoandroid.exemplofabecarregamentoinfinito.helpers

class NomeUtils {
    companion object {
        fun getListaNomes( quantidade : Int = 50): List<String> {
            val listaNomes = mutableListOf<String>()
            for (i in 1..quantidade) {
                listaNomes.add("Nome $i")
            }
            return listaNomes
        }


    }
}
