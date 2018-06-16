package dao

import control.db.JDBCStudentDAO
import model.Student
import java.sql.Blob
import java.sql.Date

class StudentDao{

    val dao = JDBCStudentDAO()

    fun save(fichaCadastral: Blob?,fichaMedica: Blob?,contrato: Blob?,
              fichaAnamnese: Blob?,nome: String,rg: Int,cpf: Int,aula: Int,modalidade: Int,
              idade: Int,sexo: String,endereco: String,telefone: String,responsavel: String,
              nascimento: Date,idoso: Boolean){

         dao.insertStudent(Student(nome = nome,rg = rg,cpf = cpf,aula = aula,modalidade = modalidade,idade = idade,sexo = sexo,
                 endereco = endereco,telefone = telefone,responsavel = responsavel,nascimento = nascimento,idoso = idoso))
    }

    fun save(student: Student){
        dao.insertStudent(student)
    }

    fun selectAll():MutableList<Student>{
        return dao.selectStudent()
    }

}