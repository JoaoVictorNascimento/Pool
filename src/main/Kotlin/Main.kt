import db.DbConn
import model.Person


fun main(args: Array<String>) {

    val epa = DbConn() //Serie de testes da conexao do banco
    //epa.supercon()
   // epa.selectNameFromP()

    epa.supercon()
   var lisss :MutableList<Person> = epa.selectPerson()
    val test :Person = lisss[0]

    println(test.printero())



}
