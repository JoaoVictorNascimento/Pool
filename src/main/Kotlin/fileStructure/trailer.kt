package fileStructure

class Trailer{

    //sao inicializados com os valores default do cnab204
    
    
    //parte Controle
    public var codigoBancoCompensacao = "000"
    public var loteServico = "9999"
    public var tipoRegistro  = "9"

    public var cnab1 /*9 caracteres em branco*/ = "         "
    
    //parte Totais
    public var quantidadeLotes = "000000"
    public var quantidadeRegistros = "000000"
    public var quantidadeContasConciliadas = "000000"

    public var cnab2 /*205 caracteres em branco*/ = "                                                                                                                                                                                                             "



    constructor(){}
}