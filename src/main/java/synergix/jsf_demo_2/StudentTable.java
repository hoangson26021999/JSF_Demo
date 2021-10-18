package synergix.jsf_demo_2;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import synergix.jsf_demo_2.PostgresData.PostgresData;

import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

@Named("studentTable")
@SessionScoped
public class StudentTable implements Serializable {

    @Inject
    private PostgresData DataBase ;
    private Student currentStudent;
    private ArrayList<Student> students;

    public void deleteStudent(int idStudent) throws SQLException {
        DataBase.deleteStudent(idStudent);
        students = DataBase.getAllStudent();
    }

    public void openfixingStudent(Student a) {
        currentStudent = a ;
    }

    public void openaddingStudent() throws SQLException {
        currentStudent = new Student() ;
        currentStudent.setId(DataBase.maxId()+1);
        // add
        DataBase.addStudent(currentStudent);
    }

    public void submit() throws SQLException {
        DataBase.fixStudent(currentStudent);
    }

    public void back()  {
        // clean currentStudent
        currentStudent = null;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    @PostConstruct
    public void setStudents() throws SQLException {
        DataBase.open();
        this.students = DataBase.getAllStudent();
    }

    public ArrayList<Student> getStudents() { return students; }

}