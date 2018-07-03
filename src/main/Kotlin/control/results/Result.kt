package control.results
import model.Classs
import model.Modality
import model.Student

enum class MessageType{SUCCESS,FAILED,EMPTY,WRONG_VALUES}//成功
enum class ErrorType{FAILED,BD_FULL,DELETED,UNCHANGED}
enum class Type{STUDENT,CLASS}
data class Error(val error: Int? = null, val e: ErrorType? = null)

 data class Result (val error: Int? = null,val msg: MessageType,val result: MutableList<Student>? = null) {

    fun isEmpty(): Boolean {
        if (result != null) {
            return false
        }
        return true
    }
}

data class ResultC (val error: Int? = null,val msg: MessageType,val result: MutableList<Classs>? = null){
    fun isEmpty(): Boolean {
        if (result != null) {
            return false
        }
        return true
    }
}

data class ResultM (val error: Int? = null,val msg: MessageType,val result: MutableList<Modality>? = null){
    fun isEmpty(): Boolean {
        if (result != null) {
            return false
        }
        return true
    }
}


