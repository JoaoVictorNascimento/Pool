package model



class Student{

    private var idAluno: Int
    private var pessoaIdPessoa: Int
    private var aulaIdAula: Int

    constructor(idAluno:Int, pessoaIdPessoa:Int, aulaIdAula: Int){

        this.idAluno = idAluno
        this.pessoaIdPessoa = pessoaIdPessoa
        this.aulaIdAula = aulaIdAula

    }


    fun getIdAula():Int{
        return idAluno
    }

    fun getPessoaIdPessoa():Int{
        return pessoaIdPessoa
    }

    fun getAulaIdAula():Int{
        return aulaIdAula
    }


    fun printero(){
        println("IAula: "+ this.idAluno+ "PidP: "+this.pessoaIdPessoa +"AidAula:"+ this.aulaIdAula )
    }

}