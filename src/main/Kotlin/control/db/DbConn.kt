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


    fun insertContract(cont :Contract){

        val statement = conn!!.prepareStatement("INSERT INTO contrato" +
                "(idContrato, Arquivo, Aluno_idAluno) VALUES (?,?,?) ")
        statement.setInt(1, cont.idContract )
        statement.setString(2, cont.fileContract)
        statement.setInt(3, cont.alunoIdAluno)
        statement.executeUpdate()

    }












    // Crud PriorityList

    fun insertPriority(candidato :PriorityList){

        val statement = conn!!.prepareStatement("INSERT INTO ListadeEspera" +
                "(Nome_aluno, Telefone, Horario, Modalidade_idModalidade, Observacao) VALUES (?,?,?,?,?) ")
        statement.setString(1, candidato.nome_aluno )
        statement.setString(2, candidato.telefone)
        statement.setString(3, candidato.horario)
        statement.setInt(4, candidato.idModality)
        statement.setString(5, candidato.observacao)
        statement.executeUpdate()

    }

    fun updatePriority(candidato: PriorityList){

        val statement = conn!!.prepareStatement("UPDATE ListadeEspera SET Nome_aluno = ?, Telefone = ?, Horario = ?, Modalidade_idModalidade = ?, Observacao = ? WHERE idListadeEspera = ?" )

        statement.setString(1, candidato.nome_aluno)
        statement.setString(2, candidato.telefone)
        statement.setString(3, candidato.horario)
        statement.setInt(4, candidato.idModality)
        statement.setString(5, candidato.observacao)
        statement.setInt(6, candidato.idLista)
        statement.executeUpdate()
    }

    fun deletePriority(id: Int) {
        val statement = conn!!.prepareStatement("DELETE FROM ListadeEspera WHERE idListadeEspera = ?")
        statement.setInt(1, id)
        statement.executeUpdate()
    }

    fun selectPriorityList():MutableList<PriorityList>{

        var priorityList :MutableList<PriorityList> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM ListadeEspera;")


            if(stat!!.execute("SELECT * FROM ListadeEspera;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idListadeEspera :Int = res!!.getInt("idListadeEspera")
                val nome_aluno :String = res!!.getString("Nome_aluno")
                val telefone :String = res!!.getString("Telefone")
                val horario :String = res!!.getString("Horario")
                val idmodalidade :Int = res!!.getInt("Modalidade_idModalidade")
                val observacao :String = res!!.getString("Observacao")

                val priority = PriorityList(idListadeEspera,nome_aluno,telefone,horario,idmodalidade,observacao)
                priorityList.add(priority)

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

        return priorityList

    }

    fun selectPriorityByName(name: String):MutableList<PriorityList>{

        var listPriority :MutableList<PriorityList> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM ListadeEspera WHERE Nome_aluno = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idListadeEspera :Int = res!!.getInt("idListadeEspera")
                val nome_aluno :String = res!!.getString("Nome_aluno")
                val telefone :String = res!!.getString("Telefone")
                val horario :String = res!!.getString("Horario")
                val idmodalidade :Int = res!!.getInt("Modalidade_idModalidade")
                val observacao :String = res!!.getString("Observacao")

                val priority = PriorityList(idListadeEspera,nome_aluno,telefone,horario,idmodalidade,observacao)
                listPriority.add(priority)
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
        return listPriority

    }




}







