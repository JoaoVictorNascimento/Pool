package dao

import control.db.DbConn
import model.PriorityList

class PriorityDao {
    var con = DbConn()

    fun save(aluno: String, telefone: String, horario: String, idModality: Int, observacao: String ) { //
            con.supercon()
            con.insertPriority(PriorityList(nome_aluno = aluno, telefone = telefone, horario = horario, idModality = idModality, observacao = observacao))
            return println("Cadastrado com Sucesso")
    }

   fun delete(id: Int) {

       con.supercon()
       con.deletePriority(id)
   }

    fun update(candidato: PriorityList){
        con.supercon()
        con.updatePriority(candidato)
    }

    fun selectAll():MutableList<PriorityList>{
        con.supercon()
        return con.selectPriorityList()
    }

    fun findByName(name: String):MutableList<PriorityList>{//returns a list of persons in case they have the same name

        con.supercon()
        val listPriorityList: MutableList<PriorityList> = con.selectPriorityByName(name)
        return listPriorityList
    }


}