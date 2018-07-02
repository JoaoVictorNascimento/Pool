package control.results
import model.Classs
import model.Student

enum class MessageType{SUCCESS,FAILED,EMPTY,WRONG_VALUES}//成功
enum class ErrorType{FAILED,BD_FULL,DELETED,UNCHANGED}
enum class Type{STUDENT,CLASS}


 data class Result (val error: Int? = null,val msg: MessageType,val result: MutableList<Student>? = null) {

    fun isEmpty(): Boolean {
        if (result != null) {
            return false
        }
        return true
    }
}

data class ResultC (val error: Int? = null,val msg: MessageType,val result: MutableList<Classs>? = null)


//data class test(val error: Int? = null,val msg: MessageType,val result: MutableList<Any>? = null,val type: Type){
//
//    fun change(){
//        if (type == Type.STUDENT)
//
//    }
//
//}


//data class Error(val error: Int, val msg:String? = null)


data class Error(val error: Int? = null, val e: ErrorType? = null)