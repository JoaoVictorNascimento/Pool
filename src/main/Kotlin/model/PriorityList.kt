package model
enum class Observacao{Idoso,Policial,Normal,IndicacaoMedica,Infantil}
class PriorityList (val idLista: Int = 0, val nome_aluno: String, val telefone: String, val horario: String, val idModality: Int, val observacao: Observacao)