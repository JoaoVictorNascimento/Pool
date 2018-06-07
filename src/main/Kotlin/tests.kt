import package Model.Person
import package db

//Casos de teste



//Retorna um nome aleatorio
fun nameGenerator() : String {
  
  var nome = ""
  
  var i = 0
  val size = Math.random()*1000)%100
  while(i < size){
    val letra = Math.random()*1000)%25 + 65
    nome = nome + letra.toChar()
  }
  
  return nome
}

//retorna uma idade entre 0 e 100
fun idadeGenerator() : Int{
  
  val number = Math.random()*10000)%100

  return number.toInt()
  
}

//retorna um cpf de 11 digitos
fun cpfGenerator() : Int{
  
  val number = Math.random()*100000000000000)%100000000000

  return number.toInt()
  
}


//retorna uma pessoa
fun testCreatePerson() : Person{

  var pessoa = Person(0, nameGenerator(), cpfGenerator(), cpfGenerator())

  return pessoa
}


fun testAddPerson() : Int{

//se falhar terá um throw do banco
  
  val epa = DbConn()
  epa.supercon()
  val novaPessoa = testCreatePerson()
  epa.insertPessoa(novaPessoa)

  return 1 //um para sucesso
}


