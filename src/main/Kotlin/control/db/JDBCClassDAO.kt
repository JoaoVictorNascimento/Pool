package control.db

import control.results.*
import model.Classs
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement



class JDBCClassDAO{

    private var conn : Connection? = DbConn().supercon()
    private var stat : Statement? = null
    private var res : ResultSet? = null

    fun fetch():ResultC{

        conn = DbConn().supercon()

        var Classlist :MutableList<Classs> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM Aula;")


            if(stat!!.execute("SELECT * FROM Aula;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idAluno :Int = res!!.getInt("idAula")
                val horario :String = res!!.getString("Horario")
                val dia :String= res!!.getString("Dia")
                val idmodalidade :Int= res!!.getInt("Modalidade_idModalidade")
                val professor :String= res!!.getString("Professor")
                val qntAluno :Int= res!!.getInt("QntAlunos")

                val classs = Classs(idAluno,horario,dia,idmodalidade,professor,qntAluno)
                Classlist.add(classs)
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
        return ResultC(null,MessageType.SUCCESS,Classlist)
    }


    fun classbyhorario(horario: String):ResultC{

        conn = DbConn().supercon()

        var Classlist :MutableList<Classs> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM Aula WHERE Horario = ?;")
            state.setString(1,horario)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idAluno :Int = res!!.getInt("idAula")
                val horario :String = res!!.getString("Horario")
                val dia :String= res!!.getString("Dia")
                val idmodalidade :Int= res!!.getInt("Modalidade_idModalidade")
                val professor :String= res!!.getString("Professor")
                val qntAluno :Int= res!!.getInt("QntAlunos")

                val classs = Classs(idAluno,horario,dia,idmodalidade,professor,qntAluno)
                Classlist.add(classs)
                //println(listinha.size)

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
        return ResultC(null,MessageType.SUCCESS,Classlist)

    }

    fun insert(klass :Classs):Error{

        val success: Int
        conn = DbConn().supercon()

        try{
            val statement = conn!!.prepareStatement("INSERT INTO Aula" +
                    "(Horario, Dia, Modalidade_idModalidade, Professor, QntAlunos) VALUES (?,?,?,?,?) ")
            statement.setString(1, klass.horario )
            statement.setString(2,klass.dia )
            statement.setInt(3,klass.idModality)
            statement.setString(4,klass.professor)
            statement.setInt(5,klass.qntAlunos)
            success = statement.executeUpdate()
        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }
        return if (success == 1) Error(null,null) else Error(null,ErrorType.FAILED)
    }

    fun delete(id: Int):Error{
        val success: Int
        conn = DbConn().supercon()
        try {
            val statement = conn!!.prepareStatement("DELETE FROM Aula WHERE idAula = ?")
            statement.setInt(1, id)
           success = statement.executeUpdate()
            }catch (e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }
        return if (success == 1) Error(null,null) else Error(null,ErrorType.FAILED)
    }

    fun delete(klass: Classs):Error{
        val success: Int
        conn = DbConn().supercon()
        try {
            val statement = conn!!.prepareStatement("DELETE FROM Aula WHERE idAula = ?")
            statement.setInt(1, klass.id)
            success = statement.executeUpdate()
        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }
        return if (success == 1) Error(null,null) else Error(null,ErrorType.FAILED)
    }


    fun update(klass: Classs):Error{
        val success: Int
        conn = DbConn().supercon()
        try{
            val statement = conn!!.prepareStatement("UPDATE Aula SET Horario = ?, Dia = ?, Modalidade_idModalidade = ?, Professor = ?, QntAlunos = ?  WHERE idAula = ?" )

            statement.setString(1,klass.horario )
            statement.setString(2,klass.dia)
            statement.setInt(3,klass.idModality )
            statement.setString(4,klass.professor)
            statement.setInt(5,klass.qntAlunos)
            statement.setInt(6,klass.id)
           success = statement.executeUpdate()
        }catch(e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }
        return if (success == 1) Error(null,null) else Error(null,ErrorType.FAILED)

    }




}