package control.db

import control.results.Error
import control.results.ErrorType
import control.results.Result
import model.Student
import java.sql.*


class JDBCStudentDAO{

    private var conn : Connection? = DbConn().supercon()
    private var stat : Statement? = null
    private var res : ResultSet? = null


    fun selectAll():MutableList<Student>{
        conn = DbConn().supercon()
        val listinha :MutableList<Student> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM aluno;")


            if(stat!!.execute("SELECT * FROM aluno;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val id: Int = res!!.getInt("idAluno")
                //val fichaC: Blob = res!!.getBlob("FichaCadastral")
                //val fichaM: Blob = res!!.getBlob("FichaMedica")
                //val contrato: Blob = res!!.getBlob("Contrato")
                //val fichaAn: Blob = res!!.getBlob("FichaAnamnese")
                val name: String = res!!.getString("Nome")
                val rg: Int = res!!.getInt("Rg")
                val cpf: Int = res!!.getInt("Cpf")
                val aula: Int = res!!.getInt("Aula_idAula")
                val modalida: Int = res!!.getInt("Aula_Modalidade_idModalidade")
                val idade: Int = res!!.getInt("Idade")
                val sexo: String = res!!.getString("Sexo")
                val end: String = res!!.getString("Endereco")
                val tell: String = res!!.getString("Telefone")
                val resp: String = res!!.getString("Responsavel")
                val nasc: Date = res!!.getDate("DataNascimento")
                val idoso: Boolean = res!!.getBoolean("Idoso")

                val pe = Student(id,null,null,null,null,name,rg,cpf,aula,
                        modalida,idade,sexo,end,tell,resp,nasc,idoso)
                listinha.add(pe)
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

        return listinha

    }

    fun selectByName(name: String):MutableList<Student>{
        conn = DbConn().supercon()
        val listinha :MutableList<Student> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM aluno WHERE Nome = ?;")
            state.setString(1,name)
            this.res = state.executeQuery()

            while (res!!.next()){

                val id: Int = res!!.getInt("idAluno")
                //val fichaC: Blob = res!!.getBlob("FichaCadastral")
                //val fichaM: Blob = res!!.getBlob("FichaMedica")
                //val contrato: Blob = res!!.getBlob("Contrato")
                //val fichaAn: Blob = res!!.getBlob("FichaAnamnese")
                val name: String = res!!.getString("Nome")
                val rg: Int = res!!.getInt("Rg")
                val cpf: Int = res!!.getInt("Cpf")
                val aula: Int = res!!.getInt("Aula_idAula")
                val modalida: Int = res!!.getInt("Aula_Modalidade_idModalidade")
                val idade: Int = res!!.getInt("Idade")
                val sexo: String = res!!.getString("Sexo")
                val end: String = res!!.getString("Endereco")
                val tell: String = res!!.getString("Telefone")
                val resp: String = res!!.getString("Responsavel")
                val nasc: Date = res!!.getDate("DataNascimento")
                val idoso: Boolean = res!!.getBoolean("Idoso")

                val pe = Student(id,null,null,null,null,name,rg,cpf,aula,
                        modalida,idade,sexo,end,tell,resp,nasc,idoso)
                listinha.add(pe)
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

        return listinha


    }

    fun insert(student :Student):Error{
        conn = DbConn().supercon()
        try{
        val statement = conn!!.prepareStatement("INSERT INTO aluno" +
                "(idAluno,Nome,Rg,Cpf,Aula_idAula,Aula_modalidade_idModalidade,Idade,Sexo,Endereco,Telefone," +
                "Responsavel,DataNascimento,Idoso) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ")

        statement.setInt(1, student.id)
        statement.setString(2, student.nome)
        statement.setInt(3, student.rg)
        statement.setInt(4, student.cpf)
        statement.setInt(5, student.aula)
        statement.setInt(6, student.modalidade)
        statement.setInt(7, student.idade)
        statement.setString(8, student.sexo)
        statement.setString(9, student.endereco)
        statement.setString(10, student.telefone)
        statement.setString(11, student.responsavel)
        statement.setDate(12, student.nascimento)
        statement.setBoolean(13, student.idoso)
        statement.executeUpdate()

        }catch (e: SQLException){
            e.printStackTrace()
            return Error(1, ErrorType.FAILED)
        }
        return Error()
    }

    fun delete(student :Student){
        conn = DbConn().supercon()
        val statement = conn!!.prepareStatement("DELETE FROM aluno WHERE idAluno = ?")
        statement.setInt(1, student.id)
        statement.executeUpdate()

    }

    fun delete(id: Int){
        conn = DbConn().supercon()
        val statement = conn!!.prepareStatement("DELETE FROM aluno WHERE idAluno = ?")
        statement.setInt(1,id)
        statement.executeUpdate()
    }

    fun update(student: Student){
        conn = DbConn().supercon()
        val statement = conn!!.prepareStatement("UPDATE aluno SET Nome,Rg,Cpf,Aula_idAula," +
                "Aula_modalidade_idModalidade," +
                "Idade,Sexo,Endereco,Telefone," +
                "Responsavel,DataNascimento,Idoso WHERE idAluno = ?")

        statement.setString(1, student.nome)
        statement.setInt(2, student.rg)
        statement.setInt(3, student.cpf)
        statement.setInt(4, student.aula)
        statement.setInt(5, student.modalidade)
        statement.setInt(6, student.idade)
        statement.setString(7, student.sexo)
        statement.setString(8, student.endereco)
        statement.setString(9, student.telefone)
        statement.setString(10, student.responsavel)
        statement.setDate(11, student.nascimento)
        statement.setBoolean(12, student.idoso)
        statement.setInt(13, student.id)

        statement.executeUpdate()
    }

}

