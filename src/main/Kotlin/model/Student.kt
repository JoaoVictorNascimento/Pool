package model



data class Student(val idAluno:Int,val pessoaIdPessoa:Int,val aulaIdAula: Int){

    fun printero(){
        println("IAluno: "+ this.idAluno+ "PidP: "+this.pessoaIdPessoa +"AidAula:"+ this.aulaIdAula )
    }

}
