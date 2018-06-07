package fileStructure

class Header{

    //parte Controle
    public var codigoBancoCompensacao = "000"
    public var loteServico = "0000"
    public var tipoRegistro = "0"

    public var cnab1 = "         "

    //parte Empresa
    public var tipoInscricaoEmpresa = "0"
    public var numeroInscricaoEmpresa = "              "
    public var codigoConvenioBanco = "                    "
    public var agenciaMantenedoraConta = "00000"
    public var digitoVerificadorAgencia = " "
    public var numeroContaCorrente = "000000000000"
    public var digitoVerificadorConta = " "
    public var digitoVerificadorAgConta = " "
    public var nomeEmpresa = "                              "

    public var nomeBanco = "                              "

    public var cnab2 = "          "


    //parte Arquivo
    public var codigoRemessaRetorno = "0"
    public var dataGeracaoArquivo = "00000000"
    public var horaGeracaoArquivo = "000000"
    public var numeroSequencialArquivo = "000000"
    public var numeroVersaoLayoutArquivo = "084"
    public var densidadeGravacaoArquivo = "00000"

    public var reservadoBanco = "                    "
    public var reservadoEmpresa = "                    "
    public var cnab3 = "                             "

}