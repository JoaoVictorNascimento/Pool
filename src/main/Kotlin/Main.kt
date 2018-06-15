import com.sun.xml.internal.bind.v2.schemagen.episode.Klass
import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import control.db.DbConn
import dao.ClassDao
import dao.ModalityDao
import dao.PriorityDao
import model.Classs
import model.Modality
import model.PriorityList
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
	//val personita = Person(10, "tobias", 11223, 124)
	//val persons: HashMap<String, String> = hashMapOf()
	/*
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

	*/
	val epa = DbConn() //Serie de testes da conexao do banco
	epa.supercon()
	//epa.supercon()
	//var lisss :MutableList<Person> = epa.selectPerson()
	//val test :Person = lisss[0]
	//println(test.printero())

	//val ptes = Person(100,"testerson",9742,321) create person
	//val auTest = model.Classs(1,"3:40","Segunda")

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
	//p.update(Person(15,"Alvo",156,215))
	//p.findById(13).printero()
	 //p.save("jack",318,42)
	 //var list = p.selectAll()
	 //for (i in list)
	//	 println(i.name)

	val crossfit = ModalityDao()
    val yoga = ModalityDao()
    val natacao = ModalityDao()
	//crossfit.save("Crossfit")
    yoga.save("Yoga")
    //natacao.save("Natacao")
	//natacao.update(Modality(5,"Karate"))

	//val denis = PriorityDao()
    //denis.save("Denis","44998722516","terça",2, "Idoso")
	//val ada = PriorityDao()
	//ada.save("ada","44998722516","terça",2, "Idoso")
	//val kevin = PriorityDao()
	//denis.save("kevin","44998722516","terça",3, "Idoso")
	//val jane = PriorityDao()
	//denis.save("jane","44998722516","terça",1, "Idoso")
    //denis.update(PriorityList(8,"Carlos","1561849298","Quinta",5,"Jovem"))
	//val candidato = denis.findByName("Carlos")

	val terca = ClassDao()
	terca.save("15:20","Quinta",1,"Cloves",26)
	terca.save("17:20","Terça",1,"Leon",26)
	terca.save("14:50","Quarta",1,"Jim",26)
	terca.save("12:40","Domingo",1,"Selena",26)


	val mdf = terca.findByhorario("14:50")
	for (i in mdf)
		println(i.professor)


	//get("/hello") { req, res -> "Hello World" }

	//denis.delete(4)
}

/*
    fun shouldReturnHtml(request: Request):Boolean {

       val accept = request.headers("Accept")
    return accept != null && accept.contains("text/html")
*/
