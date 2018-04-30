package db


import filerino.Filer
import java.io.File
import java.io.InputStream
import java.sql.*


class DbConn{



private var conn :Connection? = null
private var stat :Statement? = null
private var res :ResultSet? = null





fun supercon(){ //conexao com o banco

    val jFile = Filer()
    val theUrl = jFile.filero()

    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(theUrl[0],theUrl[1],theUrl[2])
    }catch (ex: SQLException){
        ex.printStackTrace()
    }catch (ex: Exception){
        ex.printStackTrace()
    }

}


fun selectNameFromP(){ // Select nome da tabela pessoas
    try{
        this.stat = this.conn!!.createStatement()
        this.res = this.stat!!.executeQuery("SELECT Nome FROM pessoa;")


        if(stat!!.execute("SELECT Nome FROM pessoa;")){
            res= stat!!.resultSet
        }
        while (res!!.next()){
            println(res!!.getString("Nome"))
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
}




}







