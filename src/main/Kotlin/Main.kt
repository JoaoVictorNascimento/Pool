import control.db.DbConn
import model.Person


fun main(args: Array<String>) {

    if(args.size > 1){ //command line mode to insert person

        //process inputs
        val epa = DbConn()
        epa.supercon()
        //nome, rg, cpf
        val novaPessoa = Person(args[0],args[1].toInt(),args[2].toInt())
        epa.insertPessoa(novaPessoa)



    }    
    
    else{ //command line to list persons
    
        val epa = DbConn() //Serie de testes da conexao do banco
        //epa.supercon()
        // epa.selectNameFromP()

        epa.supercon()

        //pega lista de alunos
        var lisss: MutableList<Person> = epa.selectPerson()


        //listar alunos
        for(alunos in lisss)

            alunos.printero()

        //val ptes = Person(100,"testerson",9742,321) create person
        //val auTest = model.Class(1,"3:40","Segunda") create class

       // epa.supercon()
        //epa.insertClasss(auTest) insert class

        //epa.insertPessoa(ptes) insert person
        //val testStudent :Student = Student(1,test.getIdPessoa(),auTest.getIdAula()) create studant

        //epa.supercon()
        //epa.insertStudent(testStudent) insert student

    }

}


