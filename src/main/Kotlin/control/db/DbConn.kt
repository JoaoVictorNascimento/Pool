package control.db


import control.filerino.Filer
import model.Contract
import model.Person
import model.Student
import model.Modality
import model.PriorityList
import model.Classs
import java.sql.*





class DbConn{



private var conn :Connection? = null
private var stat :Statement? = null
private var res :ResultSet? = null





fun supercon(){ //conexao com o banco

    val jFile = Filer()
    val theUrl = jFile.filero()

    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        conn = DriverManager.getConnection(theUrl[0],theUrl[1],theUrl[2])
    }catch (ex: SQLException){
        ex.printStackTrace()
    }catch (ex: Exception){
        ex.printStackTrace()
    }

}


fun selectPerson() :MutableList<Person> {

    var listinha :MutableList<Person> = mutableListOf()

    try{
        this.stat = this.conn!!.createStatement()
        this.res = this.stat!!.executeQuery("SELECT * FROM Pessoa;")


        if(stat!!.execute("SELECT * FROM Pessoa;")){
            res= stat!!.resultSet
        }
        while (res!!.next()){


            val idP :Int = res!!.getInt("iDPessoa")
            val rg :Int = res!!.getInt("RG")
            val cpf :Int = res!!.getInt("CPF")
            val name :String = res!!.getString("Nome")

            val pe = Person(idP,name,rg,cpf)

            listinha.add(pe)
            println(listinha.size)


        }

    }catch (ex: SQLException){
        ex.printStackTrace()
    }finally {

        if (res!=null){
            try {
                res!!.close()

            }catch (sqlEx: SQLException){

            }
            res = null
        }


        if (stat!=null){
            try {
                stat!!.close()

            }catch (sqlEx: SQLException){

            }
            stat = null
        }

        if (conn!=null){
            try {
                conn!!.close()

            }catch (sqlEx: SQLException){

            }
            conn = null
        }

    }

    return listinha

}


    fun insertPerson(person :Person){

            val statement = conn!!.prepareStatement("INSERT INTO Pessoa" +
                    "(Nome, RG, CPF) VALUES (?,?,?) ")
            statement.setString(1, person.name)
            statement.setInt(2, person.rg)
            statement.setInt(3, person.cpf)
            statement.executeUpdate()

    }


    fun selectPersonById(id: Int):MutableList<Person>{

        var listinha :MutableList<Person> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM pessoa WHERE idPessoa = ?;")
            state.setInt(1,id)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idP :Int = res!!.getInt("iDPessoa")
                val rg :Int = res!!.getInt("RG")
                val cpf :Int = res!!.getInt("CPF")
                val name :String = res!!.getString("Nome")

                val pe = Person(idP,name,rg,cpf)

                listinha.add(pe)
                println(listinha.size)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return listinha
    }


    fun selectPersonByName(name: String):MutableList<Person>{

        var listinha :MutableList<Person> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM pessoa WHERE Nome = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idP :Int = res!!.getInt("iDPessoa")
                val rg :Int = res!!.getInt("RG")
                val cpf :Int = res!!.getInt("CPF")
                val name :String = res!!.getString("Nome")

                val pe = Person(idP,name,rg,cpf)

                listinha.add(pe)
                println(listinha.size)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return listinha

    }

    fun updatePerson(person: Person){

        val statement = conn!!.prepareStatement("UPDATE Pessoa SET Nome = ?, RG = ?, CPF = ? WHERE idPessoa = ?" )

        statement.setString(1, person.name)
        statement.setInt(2, person.rg)
        statement.setInt(3, person.cpf)
        statement.setInt(4,person.idPessoa)
        statement.executeUpdate()
    }





//
//    fun selectStudent():MutableList<Student>{
//
//        var listinha :MutableList<Student> = mutableListOf()
//
//        try{
//            this.stat = this.conn!!.createStatement()
//            this.res = this.stat!!.executeQuery("SELECT * FROM aluno;")
//
//
//            if(stat!!.execute("SELECT * FROM aluno;")){
//                res= stat!!.resultSet
//            }
//            while (res!!.next()){
//
//                val idA :Int = res!!.getInt("idAluno")
//                val peP :Int = res!!.getInt("Pessoa_idPessoa")
//                val aulIdA :Int = res!!.getInt("Aula_idAula")
//
//                val pe = Student(idA,peP,aulIdA)
//                listinha.add(pe)
//                //println(listinha.size)
//
//            }
//
//        }catch (ex: SQLException){
//            ex.printStackTrace()
//        }finally {
//
//            if (res!=null){
//                try {
//                    res!!.close()
//
//                }catch (sqlEx: SQLException){
//
//                }
//                res = null
//            }
//
//
//            if (stat!=null){
//                try {
//                    stat!!.close()
//
//                }catch (sqlEx: SQLException){
//
//                }
//                stat = null
//            }
//
//            if (conn!=null){
//                try {
//                    conn!!.close()
//
//                }catch (sqlEx: SQLException){
//
//                }
//                conn = null
//            }
//
//        }
//
//        return listinha
//
//    }
//
//
//
//
//    fun insertStudent(student :Student){
//
//        val statement = conn!!.prepareStatement("INSERT INTO aluno" +
//                "(Pessoa_idPessoa, Aula_idAula) VALUES (?,?) ")
//
//        statement.setInt(1, student.pessoaIdPessoa)
//        statement.setInt(2, student.aulaIdAula)
//        statement.executeUpdate()
//
//    }

    fun selectClass():MutableList<model.Classs>{

        var Classlist :MutableList<Classs> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM Aula;")


            if(stat!!.execute("SELECT * FROM Aula;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idAluno :Int = res!!.getInt("idAula")
                val horario :String = res!!.getString("Horario")
                val dia :String= res!!.getString("Dia")
                val idmodalidade :Int= res!!.getInt("Modalidade_idModalidade")
                val professor :String= res!!.getString("Professor")
                val qntAluno :Int= res!!.getInt("QntAlunos")

                val classs = Classs(idAluno,horario,dia,idmodalidade,professor,qntAluno)
                Classlist.add(classs)
                //println(listinha.size)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }

        }

        return Classlist

    }

    fun selectClassbyhorario(horario: String):MutableList<Classs>{

        var Classlist :MutableList<Classs> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM Aula WHERE Horario = ?;")
            state.setString(1,horario)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idAluno :Int = res!!.getInt("idAula")
                val horario :String = res!!.getString("Horario")
                val dia :String= res!!.getString("Dia")
                val idmodalidade :Int= res!!.getInt("Modalidade_idModalidade")
                val professor :String= res!!.getString("Professor")
                val qntAluno :Int= res!!.getInt("QntAlunos")

                val classs = Classs(idAluno,horario,dia,idmodalidade,professor,qntAluno)
                Classlist.add(classs)
                //println(listinha.size)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return Classlist

    }



    fun insertClass(klass :Classs){

        val statement = conn!!.prepareStatement("INSERT INTO Aula" +
                "(Horario, Dia, Modalidade_idModalidade, Professor, QntAlunos) VALUES (?,?,?,?,?) ")
        statement.setString(1, klass.horario )
        statement.setString(2,klass.dia )
        statement.setInt(3,klass.idModality)
        statement.setString(4,klass.professor)
        statement.setInt(5,klass.qntAlunos)
        statement.executeUpdate()

    }



    fun insertContract(cont :Contract){

        val statement = conn!!.prepareStatement("INSERT INTO contrato" +
                "(idContrato, Arquivo, Aluno_idAluno) VALUES (?,?,?) ")
        statement.setInt(1, cont.idContract )
        statement.setString(2, cont.fileContract)
        statement.setInt(3, cont.alunoIdAluno)
        statement.executeUpdate()

    }



    fun deleteClass(id: Int){

        val statement = conn!!.prepareStatement("DELETE FROM Aula WHERE idAula = ?")
        statement.setInt(1, id)
        statement.executeUpdate()

    }

    fun updateClass(klass: Classs){

        val statement = conn!!.prepareStatement("UPDATE Aula SET Horario = ?, Dia = ?, Modalidade_idModalidade = ?, Professor = ?, QntAlunos = ?  WHERE idAula = ?" )

        statement.setString(1,klass.horario )
        statement.setString(2,klass.dia)
        statement.setInt(3,klass.idModality )
        statement.setString(4,klass.professor)
        statement.setInt(5,klass.qntAlunos)
        statement.setInt(6,klass.idAula)
        statement.executeUpdate()
    }



    fun deleteStudent(student :Student){

        val statement = conn!!.prepareStatement("DELETE FROM aluno WHERE idAluno = ?")
        statement.setInt(1, student.idAluno)
        statement.executeUpdate()

    }


    fun deletePerson(person :Person){

        val statement = conn!!.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ?")
        statement.setInt(1, person.idPessoa)
        statement.executeUpdate()
    }

    // Crud Modality

    fun insertModality(modality :model.Modality){

        val statement = conn!!.prepareStatement("INSERT INTO Modalidade" +
                "(Disciplina) VALUES (?) ")
        statement.setString(1, modality.disciplina)
        statement.executeUpdate()
    }

    fun updateModality(modality: Modality){

        val statement = conn!!.prepareStatement("UPDATE Modalidade SET Disciplina = ? WHERE idModalidade = ?" )

        statement.setString(1, modality.disciplina)
        statement.setInt(2, modality.idModalidade)
        statement.executeUpdate()
    }

    fun deleteModality(modality: Modality) {
        val statement = conn!!.prepareStatement("DELETE FROM Modalidade WHERE idModalidade = ?")
        statement.setInt(1, modality.idModalidade)
        statement.executeUpdate()
    }

    fun selectModalityByName(name: String):MutableList<Modality>{

        var list :MutableList<Modality> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM Modalidade WHERE Disciplina = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idModalidade :Int = res!!.getInt("idModalidade")
                val disciplina :String = res!!.getString("Disciplina")

                val modality = Modality(idModalidade,disciplina)

                list.add(modality)
            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return list

    }

    fun selectModality():MutableList<Modality>{

        var listModality :MutableList<Modality> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM Modalidade;")


            if(stat!!.execute("SELECT * FROM Modalidade;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idModalidade :Int = res!!.getInt("idModalidade")
                val disciplina :String = res!!.getString("Disciplina")

                val modality = Modality(idModalidade,disciplina)
                listModality.add(modality)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }

        }

        return listModality

    }
    // Crud PriorityList

    fun insertPriority(candidato :PriorityList){

        val statement = conn!!.prepareStatement("INSERT INTO ListadeEspera" +
                "(Nome_aluno, Telefone, Horario, Modalidade_idModalidade, Observacao) VALUES (?,?,?,?,?) ")
        statement.setString(1, candidato.nome_aluno )
        statement.setString(2, candidato.telefone)
        statement.setString(3, candidato.horario)
        statement.setInt(4, candidato.idModality)
        statement.setString(5, candidato.observacao)
        statement.executeUpdate()

    }

    fun updatePriority(candidato: PriorityList){

        val statement = conn!!.prepareStatement("UPDATE ListadeEspera SET Nome_aluno = ?, Telefone = ?, Horario = ?, Modalidade_idModalidade = ?, Observacao = ? WHERE idListadeEspera = ?" )

        statement.setString(1, candidato.nome_aluno)
        statement.setString(2, candidato.telefone)
        statement.setString(3, candidato.horario)
        statement.setInt(4, candidato.idModality)
        statement.setString(5, candidato.observacao)
        statement.setInt(6, candidato.idLista)
        statement.executeUpdate()
    }

    fun deletePriority(id: Int) {
        val statement = conn!!.prepareStatement("DELETE FROM ListadeEspera WHERE idListadeEspera = ?")
        statement.setInt(1, id)
        statement.executeUpdate()
    }

    fun selectPriorityList():MutableList<PriorityList>{

        var priorityList :MutableList<PriorityList> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM ListadeEspera;")


            if(stat!!.execute("SELECT * FROM ListadeEspera;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idListadeEspera :Int = res!!.getInt("idListadeEspera")
                val nome_aluno :String = res!!.getString("Nome_aluno")
                val telefone :String = res!!.getString("Telefone")
                val horario :String = res!!.getString("Horario")
                val idmodalidade :Int = res!!.getInt("Modalidade_idModalidade")
                val observacao :String = res!!.getString("Observacao")

                val priority = PriorityList(idListadeEspera,nome_aluno,telefone,horario,idmodalidade,observacao)
                priorityList.add(priority)

            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }

        }

        return priorityList

    }

    fun selectPriorityByName(name: String):MutableList<PriorityList>{

        var listPriority :MutableList<PriorityList> = mutableListOf()

        try{
            var state =conn!!.prepareStatement("SELECT * FROM ListadeEspera WHERE Nome_aluno = ?;")
            state.setString(1,name)

            this.res = state.executeQuery()

            while (res!!.next()){
                val idListadeEspera :Int = res!!.getInt("idListadeEspera")
                val nome_aluno :String = res!!.getString("Nome_aluno")
                val telefone :String = res!!.getString("Telefone")
                val horario :String = res!!.getString("Horario")
                val idmodalidade :Int = res!!.getInt("Modalidade_idModalidade")
                val observacao :String = res!!.getString("Observacao")

                val priority = PriorityList(idListadeEspera,nome_aluno,telefone,horario,idmodalidade,observacao)
                listPriority.add(priority)
            }

        }catch (ex: SQLException){
            ex.printStackTrace()
        }finally {

            if (res!=null){
                try {
                    res!!.close()

                }catch (sqlEx: SQLException){

                }
                res = null
            }


            if (stat!=null){
                try {
                    stat!!.close()

                }catch (sqlEx: SQLException){

                }
                stat = null
            }

            if (conn!=null){
                try {
                    conn!!.close()

                }catch (sqlEx: SQLException){

                }
                conn = null
            }
        }
        return listPriority

    }

    //Crud Classs


}







