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

    fun fetchAll():Result{
        val retu= dao.selectAll()
        return if (retu.result!!.isEmpty()) Result(null,MessageType.SUCCESS,retu.result) else Result(1,MessageType.EMPTY,retu.result)
    }

    fun byName(name: String):Result{

        val retu = dao.selectByName(name).result

        if (retu != null) {

                return Result(null,MessageType.SUCCESS,retu)

        }
        return Result(null,MessageType.EMPTY,retu)
    }

    fun byIdoso(i:Int):Result{
        var bool:Boolean = false
        if(i == 0){
            bool = false
        }
        if(i == 1){
            bool = true
        }
        if((i != 1) && ( i!=0 )){
            return Result(1,MessageType.WRONG_VALUES)
        }

        val retu = dao.selectIdoso(bool).result

        if (retu != null) {
                return Result(null,MessageType.SUCCESS,retu)
        }
        return Result(null,MessageType.EMPTY,retu)
    }

    fun delete(student: Student){
        dao.delete(student)
    }

    fun update(student: Student){
        dao.update(student)
    }

    fun delete(id: Int){
       println( dao.delete(id).e)
    }


}