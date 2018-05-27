package model

import control.db.DbConn

class PersonDao {

    var con = DbConn()

    fun save(name: String,rg: Int,cpf: Int){

       con.supercon()
       con.insertPerson(Person(name = name,rg = rg, cpf = cpf))

    }


    fun findById(id: Int):Person{

        con.supercon()
        val que: MutableList<Person> = con.selectPersonById(id)

        if (que.isEmpty()){
            println("Nao encontrado")
            return Person(-1,"Error",-1,-1)
        }
        return que[0]
    }

    fun findByName(){

    }

    fun update(){

    }

    fun delete(){

    }


}