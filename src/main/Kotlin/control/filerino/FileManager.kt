package control.filerino

import java.io.File
import java.io.InputStream

class Filer{


    fun filero() : MutableList<String> {

        
        //inserir caminho real
        val inputStream: InputStream = File("/home/neos/Documentos/Projetos/Pool3/Pool/src/main/resources/bdstruct/bdzito.txt").inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
       // lineList.forEach{println(">  $it")}

        return lineList

    }

}

