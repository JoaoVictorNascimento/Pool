package model.dao

import control.db.DbConn
import model.Classs

class ClassDao {
    var con = DbConn()

    fun save(horario: String, dia: String, idmodalidade: Int, professor: String, qntAlunos: Int){
        con.supercon()
        con.insertClass(Classs(horario = horario, dia = dia, idModality = idmodalidade, professor = professor, qntAlunos = qntAlunos))
        return println("Cadastrado com Sucesso")
    }

    fun delete(id: Int){
        con.supercon()
        con.deleteClass(id)
        return println("Deletado com Sucesso")
    }

    fun update(klass: Classs){
        con.supercon()
        con.updateClass(klass)
    }

    fun selectAll():MutableList<Classs>{
        con.supercon()
        return con.selectClass()
    }

    fun findByhorario(horario: String):MutableList<Classs>{//returns a list of persons in case they have the same name

        con.supercon()
        val listPriorityList: MutableList<Classs> = con.selectClassbyhorario(horario)
        return listPriorityList
    }
}

