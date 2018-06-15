package model


data class Person(val idPessoa: Int = 0, val name: String,val rg: Int,val cpf: Int) {

    fun printero(){
        println("Name:" +this.name+" Id:" +this.idPessoa +" RG:" +this.rg +" CPF:"+this.cpf)
    }

}
