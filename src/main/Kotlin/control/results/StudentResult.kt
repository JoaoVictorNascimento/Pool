package control.results
import model.Student

enum class MessageType{SUCCESS,FAILED,EMPTY,WRONG_VALUES}//成功

data class Result(val error: Int? = null,val msg: MessageType,val result: MutableList<Student>? = null) {
    fun isEmpty(): Boolean {
        if (result != null) {
            return false
        }
        return true
    }
}

//data class Error(val error: Int, val msg:String? = null)

enum class ErrorType{FAILED,BD_FULL,DELETED,UNCHANGED}

data class Error(val error: Int? = null, val e: ErrorType? = null)