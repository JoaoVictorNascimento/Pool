package InputTreatment



class PersonInput {

    //valida as entradas de uma pessoa a ser adicionada no banco


    fun validateInputs(name : String, rg : Int, cpf: Int) : Boolean{

        //para o nome apenas irei verificar se contem algum caracter que nao seja letra
        for(letter in name)
            if (!(letter.toInt() == 32 || 65 <= letter.toInt() && letter.toInt() <= 90 || 97 <= letter.toInt() && letter.toInt() <= 122 ))
                return false

        //para rg e cpf nao farei verificacao ainda

        return true
    }



}