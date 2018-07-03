package model.dao

import control.db.DbConn
import control.db.JDBCClassDAO
import control.results.*
import model.Classs

class ClassDao {

    val dao = JDBCClassDAO()

    fun save(horario: String, dia: String, idmodalidade: Int, professor: String, qntAlunos: Int):Error{

        var c =  Classs(horario = horario, dia = dia, idModality = idmodalidade, professor = professor, qntAlunos = qntAlunos)

        if(dao.insert(c) == (Error())){
            println("Success")
            return Error()
        }
        return Error(1, ErrorType.FAILED)
    }

    fun delete(id: Int){
        dao.delete(id)
    }

    fun update(klass: Classs){

        dao.update(klass)
    }

    fun fetchAll(): ResultC {
        val retu= dao.fetch()

        return if (retu.result!!.isEmpty()) ResultC(null, MessageType.SUCCESS,retu.result) else ResultC(1, MessageType.EMPTY,retu.result)
    }

    fun byhorario(horario: String):ResultC{

        val retu = dao.classbyhorario(horario)
        return if (retu.result!!.isEmpty()) ResultC(null, MessageType.SUCCESS,retu.result) else ResultC(1, MessageType.EMPTY,retu.result)
    }

    fun delete(klass: Classs){
        dao.delete(klass)
    }


}

