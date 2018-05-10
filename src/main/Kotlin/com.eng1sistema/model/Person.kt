package com.eng1sistema.model


class Person {

    private var idPessoa: Int
    private var nome: String
    private var rg: Int
    private var cpf: Int

    constructor(idPessoa: Int, nome: String, rg: Int, cpf: Int) {
        this.idPessoa = idPessoa
        this.nome = nome
        this.rg = rg
        this.cpf = cpf
    }

    fun getIdPessoa() :Int{
            return idPessoa
    }

    fun getNome() :String{
        return nome
    }

    fun getRg() :Int{
        return rg
    }

    fun getCpf() :Int{
        return cpf
    }

    fun printero(){
        println("Name:" +this.nome+" Id:" +this.idPessoa +" RG:" +this.rg +" CPF:"+this.cpf)
    }

}


