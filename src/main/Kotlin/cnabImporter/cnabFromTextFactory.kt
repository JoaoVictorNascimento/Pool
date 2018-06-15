package cnabImporter

import fileStructure.*
import java.io.File

class cnabFromTextFactory{

    public var cnabTrailer : Trailer
    public var cnabHeader : Header
    private var caminhoArquivo : File
    private var arquivo : List<String>

    constructor(fileName : String) {
        this.cnabTrailer = Trailer()
        this.cnabHeader = Header()
        this.caminhoArquivo = File(fileName) //abre o aquivo
        this.arquivo = caminhoArquivo.readLines() //passa o contudo do arquivo para a variavel
        this.caminhoArquivo.delete()

//        validando o tamanho das linhas
        if(validateLines() != "Linhas OK")
            println("Deu ruim aqui") //tem que colocar um try catch aqui
            println("Linhas fora do tamanho especificado")
    }


    private fun validateLines() : String{

//        println("Validando formato do arquivo")

        for(line in arquivo){
//            println("Tamanho da linha " + line.length.toString())
            if(line.length <= 240 && line.length > 0)
                return "Tamanho da linha fora do esperado"
        }

        return "Linhas OK"
    }

    fun constructTrailer(){
        var ultimaLinha = arquivo[arquivo.lastIndex]

        //obs: Posicoes de acordo com o manual do CNAB 240 da FEBRABAN
        this.cnabTrailer.codigoBancoCompensacao = ultimaLinha.substring(1-1, 3)
        this.cnabTrailer.loteServico = ultimaLinha.substring(4-1, 7)
        this.cnabTrailer.tipoRegistro = ultimaLinha[8-1].toString()
        this.cnabTrailer.quantidadeLotes = ultimaLinha.substring(18-1, 23)
        this.cnabTrailer.quantidadeRegistros = ultimaLinha.substring(24-1, 29)
        this.cnabTrailer.quantidadeContasConciliadas = ultimaLinha.substring(30-1,35)

    }


    fun constructHeader(){

        var header = arquivo[0] //e a primeira linha do arquivo

        //o motivo de eu colocar o "-1" e porque a contagem comeca em zero e nao em um
        this.cnabHeader.codigoBancoCompensacao = header.substring(1-1,3)
        this.cnabHeader.loteServico = header.substring(4-1,7)
        this.cnabHeader.tipoRegistro = header[8-1].toString()
        this.cnabHeader.tipoInscricaoEmpresa = header[18-1].toString()
        this.cnabHeader.codigoConvenioBanco = header.substring(33-1, 52)
        this.cnabHeader.agenciaMantenedoraConta = header.substring(53-1, 57)
        this.cnabHeader.digitoVerificadorAgencia = header[58-1].toString()
        this.cnabHeader.numeroContaCorrente = header.substring(59-1, 70)
        this.cnabHeader.digitoVerificadorConta = header[71-1].toString()
        this.cnabHeader.digitoVerificadorAgConta = header[72-1].toString()
        this.cnabHeader.nomeEmpresa = header.substring(73-1, 102)
        this.cnabHeader.nomeBanco = header.substring(103-1, 132)
        this.cnabHeader.codigoRemessaRetorno = header[143-1].toString()
        this.cnabHeader.dataGeracaoArquivo = header.substring(144-1, 151)
        this.cnabHeader.horaGeracaoArquivo = header.substring(152-1, 157)
        this.cnabHeader.numeroSequencialArquivo = header.substring(158-1, 163)
        this.cnabHeader.numeroVersaoLayoutArquivo = header.substring(164-1, 166)
        this.cnabHeader.densidadeGravacaoArquivo = header.substring(167-1, 171)


    }

}