package model

import java.sql.Blob
import java.sql.Date


data class Student(val idAluno: Int,
                   val fichaCadastral: Blob,
                   val fichaMedica: Blob,
                   val contrato: Blob,
                   val fichaAnamnese: Blob,
                   val Nome: String,
                   val Rg: Int,
                   val Cpf: Int,
                   val idAula: Int,
                   val idModalidade: Int,
                   val idade: Int,
                   val sexo: String,
                   val endereco: String,
                   val telefone: String,
                   val responsavel: String,
                   val nascimento: Date,
                   val idoso: Boolean)
