import db.DbConn



fun main(args: Array<String>) {

    val epa = DbConn() //Serie de testes da conexao do banco
    epa.supercon()
    epa.selectNameFromP()



}