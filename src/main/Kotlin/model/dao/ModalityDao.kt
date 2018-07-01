package model.dao

import control.db.DbConn
import model.Modality


class ModalityDao {
    var con = DbConn()

    fun save(disciplina: String) { //
        con.supercon()

        if (findByName(disciplina).isEmpty()) {
            con.supercon()
            con.insertModality(Modality(disciplina = disciplina))
            return println("Cadastrado com Sucesso")
        }
        return println("ja existente")
    }

    fun update(modality: Modality){

        con.supercon()
        con.updateModality(modality)

    }

    fun delete(modality: Modality){

        con.supercon()
        con.deleteModality(modality)


    }

    fun findByName(name: String):MutableList<Modality>{//returns a list of persons in case they have the same name

        con.supercon()
        val listModality: MutableList<Modality> = con.selectModalityByName(name)
        return listModality
    }

    fun selectAll():MutableList<Modality>{
        con.supercon()
        return con.selectModality()
    }

}