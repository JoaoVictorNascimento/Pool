package control.filerino

import java.io.File
import java.io.InputStream

class Filer{

    fun fileWalkerDayStalker(){
        File("bdstruct").walk().forEach { println(it) }
    }

    fun filero() : MutableList<String> {
        //inserir caminho real
        val inputStream: InputStream = File("C:\\Users\\Thiago\\IdeaProjects\\thePool\\Pool\\src\\main\\resources\\bdstruct\\bdzito.txt").inputStream()
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
       // lineList.forEach{println(">  $it")}

        return lineList
    }

}

