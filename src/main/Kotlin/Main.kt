import db.DbConn
import model.Person
import model.Student


fun main(args: Array<String>) {

    val epa = DbConn() //Serie de testes da conexao do banco
    //epa.supercon()
   // epa.selectNameFromP()

   epa.supercon()
   var lisss :MutableList<Person> = epa.selectPerson()
   val test :Person = lisss[0]
   //println(test.printero())

    //val ptes = Person(100,"testerson",9742,321) create person
    //val auTest = model.Class(1,"3:40","Segunda") create class

   // epa.supercon()
    //epa.insertClasss(auTest) insert class

    //epa.insertPessoa(ptes) insert person
    //val testStudent :Student = Student(1,test.getIdPessoa(),auTest.getIdAula()) create studant

    //epa.supercon()
    //epa.insertStudent(testStudent) insert student



}


