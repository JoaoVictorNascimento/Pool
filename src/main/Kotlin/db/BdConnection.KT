package db


import filerino.Filer
import model.Person
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

    //ira retornar o resultado em um Array de string
    //so pode retornar uma coluna do banco de dados por vez
    //nada de "select * from coisa"
    //e sim "select coisinha from coisa"
    fun executeMySQLQuery(command : String) : Array<String> {

        var stmt: Statement? = null
        var resultset: ResultSet? = null
        var result = emptyArray<String>()

        try {
            stmt = this.conn!!.createStatement()

            //stmt!!.execute("USE " + database)

            resultset = stmt!!.executeQuery(command)

            if (stmt.execute(command)) {
                resultset = stmt.resultSet
            }

            //como navegar em um ResultSet caso necessario pode-se voltar
            //para o inicio com ResultSet.first()
            //tentei implementar para varias colunas de uma unica vez, mas nao rolou
            //funciona apenas para uma unica coluna por vez
            var i = 1
            var rsmd : ResultSetMetaData = resultset.getMetaData() //para pegar o numero de colunas do resultado
            while(i <= rsmd.columnCount){
                while (resultset!!.next()) {
                    result = result.plus(resultset.getString(i))
                }
                resultset.first()
                i++
            }

        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources

            if (resultset != null) {

                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }
            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                conn = null
            }

        }
        return result
    }
    
    
    
    
    fun selectPerson() :MutableList<Person> {

    var listinha :MutableList<Person> = mutableListOf()

    try{
        this.stat = this.conn!!.createStatement()
        this.res = this.stat!!.executeQuery("SELECT * FROM pessoa;")


        if(stat!!.execute("SELECT * FROM pessoa;")){
            res= stat!!.resultSet
        }
        while (res!!.next()){

            //println(res!!.getString("iDPessoa"))
            //println(res!!.getString("Nome"))
            //println(res!!.getString("RG"))
            //println(res!!.getString("CPF"))

            val idP :Int = res!!.getInt("iDPessoa")
            val rg :Int = res!!.getInt("RG")
            val cpf :Int = res!!.getInt("CPF")
            val name :String = res!!.getString("Nome")

            val pe = Person(idP,name,rg,cpf)

            listinha.add(pe)
            println(listinha.size)


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

    return listinha


}


}







