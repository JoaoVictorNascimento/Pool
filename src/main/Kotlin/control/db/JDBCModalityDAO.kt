package control.db

import control.results.*
import model.Modality
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class JDBCModalityDAO{

    private var conn : Connection? = DbConn().supercon()
    private var stat : Statement? = null
    private var res : ResultSet? = null




    fun insert(modality :Modality):Error{

        val success: Int
        conn = DbConn().supercon()

        try {

            val statement = conn!!.prepareStatement("INSERT INTO Modalidade" +
                    "(Disciplina) VALUES (?) ")
            statement.setString(1, modality.disciplina)
            success = statement.executeUpdate()

        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }

        return if (success == 1) Error(null,null) else Error(null,ErrorType.FAILED)
    }

    fun update(modality: Modality):Error{
        conn = DbConn().supercon()
        val statement = conn!!.prepareStatement("UPDATE Modalidade SET Disciplina = ? WHERE idModalidade = ?" )

        try {

            statement.setString(1, modality.disciplina)
            statement.setInt(2, modality.id)
            statement.executeUpdate()
        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1)
        }
        return Error()
    }

    fun delete(modality: Modality):Error {
        val success: Int
        try {
            val statement = conn!!.prepareStatement("DELETE FROM Modalidade WHERE idModalidade = ?")
            statement.setInt(1, modality.id)
            success = statement.executeUpdate()

        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1,ErrorType.FAILED)
        }
        return if (success == 1) Error(null,ErrorType.DELETED) else Error(null,ErrorType.UNCHANGED)
    }

    fun delete(id: Int):Error {
        val success: Int
        try {
            val statement = conn!!.prepareStatement("DELETE FROM Modalidade WHERE idModalidade = ?")
            statement.setInt(1, id)
            success = statement.executeUpdate()

        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1,ErrorType.FAILED)
        }
        return if (success == 1) Error(null,ErrorType.DELETED) else Error(null,ErrorType.UNCHANGED)
    }

    fun fetchByName(name: String):ResultM{

        conn = DbConn().supercon()
        var list :MutableList<Modality> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM Modalidade WHERE Disciplina = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idModalidade :Int = res!!.getInt("idModalidade")
                val disciplina :String = res!!.getString("Disciplina")

                val modality = Modality(idModalidade,disciplina)

                list.add(modality)
            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return ResultM(null, MessageType.SUCCESS,list)

    }

    fun fetch():ResultM{

        conn = DbConn().supercon()
        var listModality :MutableList<Modality> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM Modalidade;")


            if(stat!!.execute("SELECT * FROM Modalidade;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idModalidade :Int = res!!.getInt("idModalidade")
                val disciplina :String = res!!.getString("Disciplina")

                val modality = Modality(idModalidade,disciplina)
                listModality.add(modality)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }

        }

        return ResultM(null,MessageType.SUCCESS,listModality)

    }



}