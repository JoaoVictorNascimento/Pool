package model.dao

import control.db.JDBCPriorityDAO
import model.Observacao
import model.PriorityList


class PriorityDao {
    var dao = JDBCPriorityDAO()

    fun save(aluno: String, telefone: String, horario: String, idModality: Int, observacao: Observacao ) { //

            dao.insertPriority(PriorityList(nome_aluno = aluno, telefone = telefone, horario = horario, idModality = idModality, observacao = observacao))
            return println("Cadastrado com Sucesso")
    }

   fun delete(id: Int) {
       dao.deletePriority(id)
   }

    fun update(candidato: PriorityList){
        dao.updatePriority(candidato)
    }

    fun selectAll():MutableList<PriorityList>{
        return dao.selectPriorityList()
    }

    fun findByName(name: String):MutableList<PriorityList>{//returns a list of persons in case they have the same name
        val listPriorityList: MutableList<PriorityList> = dao.selectPriorityByName(name)
        return listPriorityList
    }


}