package dao

import control.db.JDBCPersonDAO
import model.Person

class PersonDao {

    val dao = JDBCPersonDAO()

    fun save(name: String,rg: Int,cpf: Int){ //

       dao.insertPerson(Person(name = name, rg = rg, cpf = cpf))

    }


    fun findById(id: Int): Person {
        val que: MutableList<Person> = dao.selectPersonById(id)

        if (que.isEmpty()){
            println("Nao encontrado")
            return Person(-1, "Error", -1, -1)
        }
        return que[0]
    }

    fun findByName(name: String):MutableList<Person>{//returns a list of persons in case they have the same name

        val que: MutableList<Person> = dao.selectPersonByName(name)

        if (que.isEmpty()){
            println("Nao encontrado")
            return que
        }
        return que
    }

    fun update(person: Person){//

        dao.updatePerson(person)

    }

    fun delete(person: Person){

        dao.deletePerson(person)

    }


    fun selectAll():MutableList<Person>{
        return dao.selectPerson()
    }

}
