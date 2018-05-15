package control.db


import control.filerino.Filer
import model.Contract
import model.Person
import model.Student
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
        this.res = this.stat!!.executeQuery("SELECT * FROM pessoa;")


        if(stat!!.execute("SELECT * FROM pessoa;")){
            res= stat!!.resultSet
        }
        while (res!!.next()){


            //val idP :Int = res!!.getInt("iDPessoa")
            val rg :Int = res!!.getInt("RG")
            val cpf :Int = res!!.getInt("CPF")
            val name :String = res!!.getString("Nome")

            val pe = Person(name,rg,cpf)

            listinha.add(pe)
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

    return listinha

}


    fun insertPessoa(person :Person){

            val statement = conn!!.prepareStatement("INSERT INTO pessoa" +
                    "(Nome, RG, CPF) VALUES (?,?,?) ")
        
            statement.setString(1, person.getNome())
            statement.setInt(2, person.getRg())
            statement.setInt(3, person.getCpf())
            statement.executeUpdate()

    }




    fun selectStudent():MutableList<Student>{

        var listinha :MutableList<Student> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM aluno;")


            if(stat!!.execute("SELECT * FROM aluno;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idA :Int = res!!.getInt("idAluno")
                val peP :Int = res!!.getInt("Pessoa_idPessoa")
                val aulIdA :Int = res!!.getInt("Aula_idAula")

                val pe = Student(idA,peP,aulIdA)
                listinha.add(pe)
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

        return listinha

    }




    fun insertStudent(student :Student){

        val statement = conn!!.prepareStatement("INSERT INTO aluno" +
                "(idAluno, Pessoa_idPessoa, Aula_idAula) VALUES (?,?,?) ")
        statement.setInt(1, student.getIdAluno())
        statement.setInt(2, student.getPessoaIdPessoa())
        statement.setInt(3, student.getAulaIdAula())
        statement.executeUpdate()

    }








    fun selectClass():MutableList<model.Class>{

        var listinha :MutableList<model.Class> = mutableListOf()

        try{
            this.stat = this.conn!!.createStatement()
            this.res = this.stat!!.executeQuery("SELECT * FROM aula;")


            if(stat!!.execute("SELECT * FROM aula;")){
                res= stat!!.resultSet
            }
            while (res!!.next()){

                val idA :Int = res!!.getInt("idAula")
                val horario :String = res!!.getString("Horario")
                val dia :String= res!!.getString("Dia")

                val pe = model.Class(idA,horario,dia)
                listinha.add(pe)
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

        return listinha

    }



    fun insertClasss(klass :model.Class){

        val statement = conn!!.prepareStatement("INSERT INTO aula" +
                "(idAula, Horario, Dia) VALUES (?,?,?) ")
        statement.setInt(1, klass.getIdAula())
        statement.setString(2, klass.getDia())
        statement.setString(3, klass.getHorario())
        statement.executeUpdate()

    }



    fun insertContract(cont :Contract){

        val statement = conn!!.prepareStatement("INSERT INTO contrato" +
                "(idContrato, Arquivo, Aluno_idAluno) VALUES (?,?,?) ")
        statement.setInt(1, cont.getIdContract() )
        statement.setString(2, cont.getFileContract())
        statement.setInt(3, cont.getAlunoIdAluno())
        statement.executeUpdate()

    }



    fun deleteClass(klass :model.Class){

        val statement = conn!!.prepareStatement("DELETE FROM aula WHERE idAula = ?")
        statement.setInt(1, klass.getIdAula())
        statement.executeUpdate()

    }


    fun deleteStudent(student :Student){

        val statement = conn!!.prepareStatement("DELETE FROM aluno WHERE idAluno = ?")
        statement.setInt(1, student.getIdAluno())
        statement.executeUpdate()

    }


    fun deletePerson(person :Person){

        val statement = conn!!.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ?")
        statement.setInt(1, person.getIdPessoa())
        statement.executeUpdate()
    }

}







