import control.db.JDBCClassDAO
import control.db.JDBCPersonDAO
import control.db.JDBCStudentDAO
import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import model.dao.*
import model.*
import org.eclipse.jetty.util.MultiMap
import org.eclipse.jetty.util.UrlEncoded
import spark.ModelAndView
import spark.Spark
import spark.template.freemarker.FreeMarkerEngine
import java.io.File
import java.sql.Blob
import java.sql.Date
import java.text.SimpleDateFormat


fun configureFreeMarker(): FreeMarkerEngine {
	val directory = "src/main/resources/templates"
	val configuration = Configuration(Configuration.VERSION_2_3_23)

	configuration.defaultEncoding = "UTF-8"
	configuration.numberFormat = "computer"
	configuration.templateLoader = FileTemplateLoader(File(directory))
	return FreeMarkerEngine(configuration)
}

fun main(args: Array<String>) {
	
	/*
	// Exemplo de como cadastrar uma pessoa no banco
	//sendo que o dao foi alterado os campos IDOSO E ID
	val dateForm = SimpleDateFormat("MM-dd-yyyy")
	var dataNascimento : Date = java.sql.Date(dateForm.parse("02-04-2015").getTime())

	val novoEstudante = Student(0,null, null, null, null, "agnaldo",
			123,
			"1234".toInt(), 1, 1, 69, "indefinido",
			"eumesmo", "010101", "eumesmo", dataNascimento, false)

	val cadastradorEstudante = JDBCStudentDAO()

	cadastradorEstudante.insert(novoEstudante)
	*/	
	
	
	
	val personita = Person(10, "tobias", 11223, 124)
	val personita2 = Person(14, "jack", 23, 2124)
	val persons: HashMap<String, String> = hashMapOf()

	//persons["person"] = personita.name
	persons.put(personita.name,personita.cpf.toString())
	//val p = PersonDao()
	val freeMarkerEngine = configureFreeMarker()
	val date = Date.valueOf("1992-12-12")

	//val stu = Student(nome = "dera",rg = 123,cpf = 94,aula = 1,modalidade = 1,idade = 13,sexo = "masc", endereco = "ecoaer",telefone = "981276",responsavel = "Lord gaben",nascimento = date,idoso = false)

	val s = StudentDao()
	val sw= StudentDao()
	//s.save(stu)
	//println(sw.selectAll())
	//println(sw.selectAll().result!![1].nome)
	//println(s.selectName("Rosh"))
	//s.delete(3)
    //println(s.byIdoso(1))
	val c = ClassDao()
	println(c.fetchAll())

	val x :MutableList<Person> = mutableListOf()
	//println(x)
	
	
	Spark.get("/turmas"){req, res ->
		val parameters : HashMap<String, Any> = hashMapOf()
		val verTurmas = JDBCClassDAO()
		val listaTurmas = verTurmas.fetch().result
		parameters.put("turmas", listaTurmas!!)
		freeMarkerEngine.render(ModelAndView(parameters, "turmas.ftl"))
	}
	
	Spark.get("/modalidades"){req, res ->
		val parameters : HashMap<String, Any> = hashMapOf()
		val verModalidades = JDBCModalityDAO()
		val listaModalidades = verModalidades.fetch().result
		parameters.put("modalidades", listaModalidades!!)
		freeMarkerEngine.render(ModelAndView(parameters, "modalidades.ftl"))
	}
	
	Spark.get("/people") { req, res ->
		val root: HashMap<String, String> = hashMapOf()
		val per: HashMap<String, Any> = hashMapOf()

		val lis: MutableList<Person> = mutableListOf()
		lis.add(personita)
		lis.add(personita2)
		root["person"] = personita.name
		root.put("person", personita.name)
		per.put("person", lis)
		freeMarkerEngine.render(ModelAndView(root, "people.ftl"))	//era so passar o root aqui que funcionava
	}

	Spark.get("/create") { req, res ->
		val perr: HashMap<String, Any> = hashMapOf()
		perr.put("person", "OPA")
		val params: MultiMap<String> = MultiMap()

		println(req.body())
		println(UrlEncoded.decodeTo(req.body(), params, "UTF-8", -1))


		freeMarkerEngine.render(ModelAndView(perr, "opa.ftl"))

	}
	
	Spark.get("/home") { req, res ->
        	val home: HashMap<String, Any> = hashMapOf()
        	freeMarkerEngine.render(ModelAndView(home, "home.ftl"))
        }			    
			   			   		    
     

    	Spark.get("/"){req, res ->
        	res.redirect("/home")
    	}
    
	Spark.get("/aluno") { req, res ->
		val acessoBanco = JDBCStudentDAO()
		val listaStudents = acessoBanco.fetch().result

		val perr: HashMap<String, Any> = hashMapOf()

		if (listaStudents != null) {
			perr.put("students", listaStudents)
		}

		freeMarkerEngine.render(ModelAndView(perr, "aluno.ftl"))
    }


    //aqui o frnkalin mexeu, entao tem umas coisas que devem estar errado
	//como aquele perr

	Spark.get("/cadastro") { req, res ->
		val aluno: HashMap<String, Any> = hashMapOf()
		aluno.put("student","Student")
		val params: MultiMap<String> = MultiMap()

		println(req.body())
		println(UrlEncoded.decodeTo(req.body(), params, "UTF-8", -1))


		freeMarkerEngine.render(ModelAndView("student", "cadastro.ftl"))

	}

//	Spark.post("/cadastro") { req, res ->	//pegar os dados inseridos na tela
//
//        val nome = req.queryParams("nome")
//        val idade = req.queryParams("idade")
//        val cpf = req.queryParams("cpf")
//        val endereco = req.queryParams("endereco")
//		val rg =  req.queryParams("rg")
//		val dataNascimento =  req.queryParams("data")
//		val telefone = req.queryParams("telefone")
//		val modalidade = req.queryParams("modalidade")
//		val aula =  req.queryParams("aula")
//
//
//		val dateForm = SimpleDateFormat("MM-dd-yyyy")
//		var dataNascimentoFormatado : Date = java.sql.Date(dateForm.parse(dataNascimento).getTime())
//
//
//		val novoEstudante = Student(0,
//									null,
//									null,
//									null,
//									null,
//									 nome.toString(),
//				                     rg.toInt(),
//				                     cpf.toInt(),
//									 aula.toInt(),
//									 modalidade.toInt(),
//				                     idade.toInt(),
//								     "MulheraoDaPohaToda",
//				                     endereco.toString(),
//									 telefone,
//				                     "Me",
//				                     dataNascimentoFormatado,
//				                     false)
//
//
//		val cadastradorEstudante = JDBCStudentDAO()
//
//		cadastradorEstudante.insert(novoEstudante)
//
//		res.redirect("/home")
//
//        	println("")
//	}
	
	Spark.get("/lista_de_presenca") { req, res ->
		val perr: HashMap<String, Any> = hashMapOf()
		perr.put("student", "Student")
		val params: MultiMap<String> = MultiMap()

		println(req.body())
		println(UrlEncoded.decodeTo(req.body(), params, "UTF-8", -1))

		freeMarkerEngine.render(ModelAndView(perr, "lista_de_presenca.ftl"))

	}
	//até aqui o franklin mexeu
}
