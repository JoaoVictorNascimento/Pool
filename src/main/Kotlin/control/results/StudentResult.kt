package control.results
import model.Student

enum class MessageType{SUCCESS,FAILED,EMPTY,WRONG_VALUES}

data class Result(val error: Int? = null,val msg: MessageType,val result: MutableList<Student>? = null)

//data class Error(val error: Int, val msg:String? = null)

enum class ErrorType{FAILED,BD_FULL}

data class Error(val error: Int? = null, val e: ErrorType? = null)