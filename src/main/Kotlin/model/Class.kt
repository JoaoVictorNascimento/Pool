package model



class Class{


    private var idAula :Int
    private var horario :String
    private var dia :String

    constructor(idAula :Int, horario :String, dia :String){
        this.idAula = idAula
        this.horario = horario
        this.dia = dia
    }

    fun getIdAula():Int{
        return idAula
    }

    fun getHorario():String{
        return horario
    }

    fun getDia():String{
        return dia
    }

    fun printero(){
        println("IAula: "+ this.idAula+ "Horario: "+this.horario +"Dia:"+ this.dia )
    }

}