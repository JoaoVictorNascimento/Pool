import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import model.Person
import model.PersonDao
import spark.ModelAndView
import spark.Spark.*
import control.db.DbConn
import spark.template.freemarker.FreeMarkerEngine
import java.io.File


fun configureFreeMarker(): FreeMarkerEngine {
	val directory = "/home/neos/Documentos/Projetos/Pool3/Pool/src/main/resources/bdstruct/templates"
	val configuration = Configuration(Configuration.VERSION_2_3_23)

	configuration.defaultEncoding = "UTF-8"
	configuration.numberFormat = "computer"
	configuration.templateLoader = FileTemplateLoader(File(directory))

	return FreeMarkerEngine(configuration)
}

fun main(args: Array<String>) {
	val personita = Person(10, "tobias", 11223, 124)
	val persons: HashMap<String, String> = hashMapOf()

	persons["person"] = personita.name

	val p = PersonDao()
	val freeMarkerEngine = configureFreeMarker()

	get("/people") { req, res ->
		val root: HashMap<String, String> = hashMapOf()

		root["person"] = personita.name
		freeMarkerEngine.render(ModelAndView(root, "people.ftl"))
	}

	get("/id/:id") { req, res ->
		p.findById(req.params("id").toInt())
	}

	get("/name/:name") { req, res ->
		p.findByName(req.params("name"))
	}

	post("/create") { req, res ->
	}

	
	val epa = DbConn() //Serie de testes da conexao do banco
	epa.supercon()
	//epa.supercon()
	//var lisss :MutableList<Person> = epa.selectPerson()
	//val test :Person = lisss[0]
	//println(test.printero())

	//val ptes = Person(100,"testerson",9742,321) create person
	//val auTest = model.Class(1,"3:40","Segunda")

	// epa.supercon()
	//epa.insertClasss(auTest) insert class

	//epa.insertPessoa(ptes) insert person
	//val testStudent :Student = Student(1,test.getIdPessoa(),auTest.getIdAula()) create studant

	//epa.supercon()
	//epa.insertStudent(testStudent) insert student
	//  get("/opa") { "Hello World" }

	//var pt = Person(name="paos",rg =12,cpf = 42)
	//println(pt.name + pt.idPessoa)


	// val pe = p.findById(101)
	p.update(Person(15,"Alvo",156,215))
	//p.findById(13).printero()
	 p.save("jack",318,42)
	 var list = p.selectAll()
	 for (i in list)
		 println(i.name)
	//get("/hello") { req, res -> "Hello World" }
}

/*
    fun shouldReturnHtml(request: Request):Boolean {

       val accept = request.headers("Accept")
    return accept != null && accept.contains("text/html")
*/
