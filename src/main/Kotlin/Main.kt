import model.Person
import model.PersonDao
import javax.security.auth.login.Configuration.setConfiguration
import freemarker.cache.ClassTemplateLoader
import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler
import spark.ModelAndView
import spark.Spark.*

import spark.template.freemarker.FreeMarkerEngine
import java.io.File
import java.lang.System.out
import java.nio.file.Path
import java.io.OutputStreamWriter
import java.io.Writer
import freemarker.cache.WebappTemplateLoader
import javax.servlet.ServletContext

fun main(args: Array<String>) {

    if(args.size > 1){ //command line mode to insert person

        //process inputs
        val epa = DbConn()
        epa.supercon()
        //nome, rg, cpf
        val novaPessoa = Person(args[0],args[1].toInt(),args[2].toInt())
        epa.insertPessoa(novaPessoa)



    }    
    
    else{ //command line to list persons
    
        val epa = DbConn() //Serie de testes da conexao do banco
        //epa.supercon()
        // epa.selectNameFromP()

        epa.supercon()

        //pega lista de alunos
        var lisss: MutableList<Person> = epa.selectPerson()


        //listar alunos
        for(alunos in lisss)

            alunos.printero()

        //val ptes = Person(100,"testerson",9742,321) create person
        //val auTest = model.Class(1,"3:40","Segunda") create class

       // epa.supercon()
        //epa.insertClasss(auTest) insert class

        //epa.insertPessoa(ptes) insert person
        //val testStudent :Student = Student(1,test.getIdPessoa(),auTest.getIdAula()) create studant

        //epa.supercon()
        //epa.insertStudent(testStudent) insert student
        //var pt = Person(name="paos",rg =12,cpf = 42)
    //println(pt.name + pt.idPessoa)

    //var p = PersonDao()
    //p.findById(13).printero()
   // p.save("jack2",2418,4152)
    //get("/hello") { req, res -> "Hello World" }
    val personita = Person(10,"tobias",11223,124)
    val persons: HashMap<String,String> = hashMapOf()
    persons.put("person",personita.name)

    var p = PersonDao()
    val freeMarkerEngine = FreeMarkerEngine()
    val cfg = Configuration(Configuration.VERSION_2_3_27)
    cfg.setDirectoryForTemplateLoading(File("PATH TEMPLATES"))

    cfg.defaultEncoding = "UTF-8"
    cfg.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
    cfg.logTemplateExceptions = false
    cfg.wrapUncheckedExceptions = true

        
         get("/people"){req,res ->

            val temp: Template
            temp = cfg.getTemplate(ea)

            res.status(200)
            res.type("text/html")

            val out = OutputStreamWriter(System.out)
            //val root: HashMap<String,MutableList<Person>> = hashMapOf()
            val root: HashMap<String,String> = hashMapOf()
           // root.put("person",p.selectAll())
            root.put("person",personita.name)
                //p.selectAll()

            freeMarkerEngine.render(ModelAndView(root,"templates/people.ftl"))
            //temp.process(root,out)

        }

        get("/:id"){req,res ->
            p.findById(req.params("id").toInt())
        }

        get("/name/:name"){req,res->
            p.findByName(req.params("name"))

        }

        post("/create"){req,res->

        }
 
        
        
        

    }

}


