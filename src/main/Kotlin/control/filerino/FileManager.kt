package control.filerino

import java.io.File
import java.io.InputStream

class Filer{


    fun filero() : MutableList<String> {

        val inputStream: InputStream = File("C:\\Users\\Thiago\\IdeaProjects\\art1\\src\\main\\resources\\bdstruct\\bdzito.txt").inputStream()
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }
        lineList.forEach{println(">  $it")}

        return lineList

    }

}

