package model.dao


import control.db.JDBCModalityDAO
import control.results.Error
import control.results.ErrorType
import control.results.MessageType
import control.results.ResultM
import model.Modality


class ModalityDao {
    var dao = JDBCModalityDAO()

    fun save(disciplina: Modality):Error { //

        if(dao.insert(disciplina) == (Error())){
            //println("Success")
            return Error()

        }
        return Error(1, ErrorType.FAILED)

    }

    fun update(modality: Modality){
        dao.update(modality)
    }

    fun delete(modality: Modality){
        dao.delete(modality)
    }

    fun ByName(name: String): ResultM {//returns a list of persons in case they have the same name

        val retu: ResultM = dao.fetchByName(name)
        return if (retu.result!!.isEmpty()) ResultM(null, MessageType.SUCCESS,retu.result) else ResultM(1, MessageType.EMPTY,retu.result)
    }

    fun fetchAll(): ResultM {

        val retu = dao.fetch()
        return if (retu.result!!.isEmpty()) ResultM(null, MessageType.SUCCESS,retu.result) else ResultM(1, MessageType.EMPTY,retu.result)
    }

}