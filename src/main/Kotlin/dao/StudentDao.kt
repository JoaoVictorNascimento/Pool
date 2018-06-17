package dao

import control.db.JDBCStudentDAO
import control.results.Error
import control.results.ErrorType
import control.results.MessageType
import model.Student
import java.sql.Blob
import java.sql.Date
import control.results.Result
import kotlin.math.E

class StudentDao{

    val dao = JDBCStudentDAO()

    fun save(fichaCadastral: Blob?,fichaMedica: Blob?,contrato: Blob?,
              fichaAnamnese: Blob?,nome: String,rg: Int,cpf: Int,aula: Int,modalidade: Int,
              idade: Int,sexo: String,endereco: String,telefone: String,responsavel: String,
              nascimento: Date,idoso: Boolean){

         dao.insert(Student(nome = nome,rg = rg,cpf = cpf,aula = aula,modalidade = modalidade,idade = idade,sexo = sexo,
                 endereco = endereco,telefone = telefone,responsavel = responsavel,nascimento = nascimento,idoso = idoso))
    }


    fun save(student: Student):Error{
        if(dao.insert(student) == (Error())){
            println("Success")
            return Error()
        }
           return Error(1,ErrorType.FAILED)
    }

    fun selectAll():Result{
        val retu= dao.selectAll()
        if(retu.isEmpty()){
            return Result(  null,MessageType.EMPTY, retu)
        }
        return Result( null, MessageType.SUCCESS, retu)
    }

    fun selectName(name: String):Result{

        val retu = dao.selectByName(name)

        if(retu.isEmpty()){
            return Result(null,MessageType.EMPTY,retu)
        }
        return Result(null,MessageType.SUCCESS,retu)
    }

    fun delete(student: Student){
        dao.delete(student)
    }

    fun update(student: Student){
        dao.update(student)
    }

    fun delete(id: Int){
        dao.delete(id)
    }


}