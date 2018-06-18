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

	val stu = Student(nome = "dera",rg = 123,cpf = 94,aula = 1,modalidade = 1,idade = 13,sexo = "masc",
			endereco = "ecoaer",telefone = "981276",responsavel = "Lord gaben",nascimento = date,idoso = false)

	val s = StudentDao()
	val sw= StudentDao()
	//s.save(stu)
	//println(sw.selectAll())
	//println(sw.selectAll().result!![1].nome)
	//println(s.selectName("Rosh"))
	//s.delete(1)
    //println(s.byIdoso(1))

	val x :MutableList<Person> = mutableListOf()
	//println(x)

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

}