package model

import java.sql.Blob
import java.sql.Date


data class Student(val id: Int = 0,
                   val fichaCadastral: Blob? = null,
                   val fichaMedica: Blob? = null,
                   val contrato: Blob? = null,
                   val fichaAnamnese: Blob? = null,
                   val nome: String,
                   val rg: Int,
                   val cpf: Int,
                   val aula: Int,
                   val modalidade: Int,
                   val idade: Int,
                   val sexo: String?,
                   val endereco: String?,
                   val telefone: String?,
                   val responsavel: String?,
                   val nascimento: Date?,
                   val idoso: Boolean)
