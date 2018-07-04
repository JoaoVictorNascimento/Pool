import control.db.JDBCClassDAO
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


fun configureFreeMarker(): FreeMarkerEngine {
	val directory = "C:\\Users\\Erica\\Downloads\\Pool-master\\src\\main\\resources\\templates"
	val configuration = Configuration(Configuration.VERSION_2_3_23)

	configuration.defaultEncoding = "UTF-8"
	configuration.numberFormat = "computer"
	configuration.templateLoader = FileTemplateLoader(File(directory))
	return FreeMarkerEngine(configuration)
}

fun main(args: Array<String>) {
	val personita = Person(10, "tobias", 11223, 124)
	val personita2 = Person(14, "jack", 23, 2124)
	val persons: HashMap<String, String> = hashMapOf()

	//persons["person"] = personita.name
	persons.put(personita.name,personita.cpf.toString())
	//val p = PersonDao()
	val freeMarkerEngine = configureFreeMarker()
	val date = Date.valueOf("1992-12-12")

	val stu = Student(nome = "dera",rg = 123,cpf = 94,aula = 1,modalidade = 1,idade = 13,sexo = "masc",
			endereco = "ecoaer",telefone = "981276",responsavel = "Lord gaben",nascimento = date,idoso = false)

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

    Spark.get("/") { req, res ->
        val home: HashMap<String, Any> = hashMapOf()
        freeMarkerEngine.render(ModelAndView(home, "home.ftl"))
    }

    Spark.get("/aluno") { req, res ->
        val aluno: HashMap<String, Any> = hashMapOf()
        aluno.put("students", sw.fetchAll().result!!)
        freeMarkerEngine.render(ModelAndView(aluno, "aluno.ftl"))
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

	Spark.post("/cadastro") { req, res ->	//pegar os dados inseridos na tela

        val nome = req.queryParams("nome")
        val idade = req.queryParams("idade")
        val cpf = req.queryParams("cpf")
        val endereco = req.queryParams("endereco")

//        val personita = Person(0, nome, cpf.toInt(), )

        personita.printero()
	}
	
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
