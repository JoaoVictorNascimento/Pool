package control.results

import model.Student

data class Result(val error: Int,val msg: String,val result: Student? = null){

        constructor(resultlist: MutableList<Student>,error: Int , msg: String) : this (error,msg)

}
