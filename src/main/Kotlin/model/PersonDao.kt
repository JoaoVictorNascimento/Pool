package model

import control.db.DbConn

class PersonDao {

    var con = DbConn()

    fun save(name: String,rg: Int,cpf: Int){ //

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

    fun findByName(name: String):MutableList<Person>{//returns a list of persons in case they have the same name

        con.supercon()
        val que: MutableList<Person> = con.selectPersonByName(name)

        if (que.isEmpty()){
            println("Nao encontrado")
            return que
        }
        return que


    }

    fun update(person: Person){//??

        con.supercon()
        con.updatePerson(person)

    }

    fun delete(person: Person){
        con.supercon()

        con.deletePerson(person)

    }


    fun selectAll():MutableList<Person>{
        con.supercon()
        return con.selectPerson()
    }


}
