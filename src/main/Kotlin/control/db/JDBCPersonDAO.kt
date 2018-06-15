package control.db

import model.Person
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class JDBCPersonDAO {

    private var conn : Connection? = DbConn().supercon()
    private var stat : Statement? = null
    private var res : ResultSet? = null

    fun selectPerson() :MutableList<Person> {

        var listinha :MutableList<Person> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM aluno;")


            if(stat!!.execute("SELECT * FROM aluno;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){


                val idP :Int = res!!.getInt("idAluno")
                val rg :Int = res!!.getInt("Rg")
                val cpf :Int = res!!.getInt("Cpf")
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


    fun insertPerson(person :Person){

        val statement = conn!!.prepareStatement("INSERT INTO aluno" +
                "(Nome, RG, CPF) VALUES (?,?,?) ")
        statement.setString(1, person.name)
        statement.setInt(2, person.rg)
        statement.setInt(3, person.cpf)
        statement.executeUpdate()

    }

    fun selectPersonById(id: Int):MutableList<Person>{

        var listinha :MutableList<Person> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM pessoa WHERE idPessoa = ?;")
            state.setInt(1,id)

            this.res = state.executeQuery()

            while (res!!.next()){
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



    fun selectPersonByName(name: String):MutableList<Person>{

        var listinha :MutableList<Person> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM pessoa WHERE Nome = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
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

    fun updatePerson(person: Person){

        val statement = conn!!.prepareStatement("UPDATE Pessoa SET Nome = ?, RG = ?, CPF = ? WHERE idPessoa = ?" )

        statement.setString(1, person.name)
        statement.setInt(2, person.rg)
        statement.setInt(3, person.cpf)
        statement.setInt(4,person.idPessoa)
        statement.executeUpdate()
    }

    fun deletePerson(person :Person){

        val statement = conn!!.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ?")
        statement.setInt(1, person.idPessoa)
        statement.executeUpdate()
    }


}