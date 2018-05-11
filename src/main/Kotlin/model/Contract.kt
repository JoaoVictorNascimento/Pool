package model



class Contract{



    private var idContract: Int
    private var fileContract: String
    private var alunoIdAluno: Int


    constructor(idContract: Int, fileContract: String,alunoIdAluno: Int){

        this.idContract = idContract
        this.fileContract = fileContract
        this.alunoIdAluno = alunoIdAluno

    }


    fun getIdContract():Int{
        return idContract
    }

    fun getFileContract() :String{
        return fileContract
    }
    fun getAlunoIdAluno() :Int{
        return alunoIdAluno
    }




}