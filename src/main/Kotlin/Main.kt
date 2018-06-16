import com.sun.xml.internal.bind.v2.schemagen.episode.Klass
import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import control.db.DbConn
import dao.*
import model.*
import org.eclipse.jetty.util.MultiMap
import org.eclipse.jetty.util.UrlEncoded
import spark.ModelAndView
import spark.Spark
import spark.template.freemarker.FreeMarkerEngine
import java.io.File
import java.sql.Date


fun configureFreeMarker(): FreeMarkerEngine {
	val directory = "C:\\Users\\Thiago\\IdeaProjects\\thePool\\Pool\\src\\main\\resources\\bdstruct\\templates"
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
	val p = PersonDao()
	val freeMarkerEngine = configureFreeMarker()
	val date = Date.valueOf("1992-12-12")

	val stu = Student(nome = "Rosh",rg = 123,cpf = 94,aula = 1,modalidade = 1,idade = 22,sexo = "masc",
			endereco = "rosh pi",telefone = "981276",responsavel = "Lord gaben",nascimento = date,idoso = false)



	val s = StudentDao()
	//s.save(stu)
	println(s.selectAll())

	Spark.get("/people") { req, res ->
		val root: HashMap<String, String> = hashMapOf()
		val per: HashMap<String, Any> = hashMapOf()

		val lis: MutableList<Person> = mutableListOf()
		lis.add(personita)
		lis.add(personita2)
		//root["person"] = personita.name
		root.put("person", personita.name)
		per.put("person", lis)
		freeMarkerEngine.render(ModelAndView(per, "people.ftl"))
	}

	Spark.get("/create") { req, res ->
		val perr: HashMap<String, Any> = hashMapOf()
		perr.put("person", "OPA")
		val params: MultiMap<String> = MultiMap()

		println(req.body())
		println(UrlEncoded.decodeTo(req.body(), params, "UTF-8", -1))


		freeMarkerEngine.render(ModelAndView(perr, "opa.ftl"))

	}




//	val crossfit = ModalityDao()
//    val yoga = ModalityDao()
//    val natacao = ModalityDao()
//	//crossfit.save("Crossfit")
//    yoga.save("Yoga")
//    //natacao.save("Natacao")
//	//natacao.update(Modality(5,"Karate"))
//
//	//val denis = PriorityDao()
//    //denis.save("Denis","44998722516","terça",2, "Idoso")
//	//val ada = PriorityDao()
//	//ada.save("ada","44998722516","terça",2, "Idoso")
//	//val kevin = PriorityDao()
//	//denis.save("kevin","44998722516","terça",3, "Idoso")
//	//val jane = PriorityDao()
//	//denis.save("jane","44998722516","terça",1, "Idoso")
//    //denis.update(PriorityList(8,"Carlos","1561849298","Quinta",5,"Jovem"))
//	//val candidato = denis.findByName("Carlos")
//
//	val terca = ClassDao()
//	terca.save("15:20","Quinta",1,"Cloves",26)
//	terca.save("17:20","Terça",1,"Leon",26)
//	terca.save("14:50","Quarta",1,"Jim",26)
//	terca.save("12:40","Domingo",1,"Selena",26)
//
//
//	val mdf = terca.findByhorario("14:50")
//	for (i in mdf)
//		println(i.professor)


	//get("/hello") { req, res -> "Hello World" }

	//denis.delete(4)
}

/*
    fun shouldReturnHtml(request: Request):Boolean {

       val accept = request.headers("Accept")
    return accept != null && accept.contains("text/html")
*/
