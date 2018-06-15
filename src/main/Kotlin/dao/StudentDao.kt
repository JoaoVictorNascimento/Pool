package dao

import control.db.JDBCStudentDAO
import model.Student

class StudentDao{

    val dao = JDBCStudentDAO()

    fun save(){

      //  dao.insertStudent()
    }


    fun selectAll():MutableList<Student>{
        return dao.selectStudent()
    }

}