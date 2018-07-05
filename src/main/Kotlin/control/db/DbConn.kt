package control.db


import control.filerino.Filer
import model.Contract
import model.Person
import model.Student
import model.Modality
import model.PriorityList
import model.Classs
import java.sql.*





class DbConn{

    private var conn :Connection? = null
    private var stat :Statement? = null
    private var res :ResultSet? = null

    fun supercon(): Connection? { //conexao com o banco

        val jFile = Filer()
        val theUrl = jFile.filero()

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(theUrl[0],theUrl[1],theUrl[2])
        }catch (ex: SQLException){
            ex.printStackTrace()
        }catch (ex: Exception){
            ex.printStackTrace()
        }
        return conn
    }
}








