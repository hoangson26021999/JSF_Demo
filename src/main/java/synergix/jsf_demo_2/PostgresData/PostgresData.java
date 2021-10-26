package synergix.jsf_demo_2.PostgresData;

import synergix.jsf_demo_2.Class;
import synergix.jsf_demo_2.Student;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;


public class PostgresData implements Serializable {
    private Connection db;
    private Statement query ;

    public void open() throws SQLException {
        db =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyStudent", "postgres", "hoangson99");
        query = db.createStatement();
    }

    public void close() throws SQLException {
        db.close();
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> table = new ArrayList<>() ;
        try {
            ResultSet student_table = query.executeQuery("SELECT id , name , age , date_of_birth ,email from student_table");
            while (student_table.next()) {
                table.add(new Student(student_table.getInt(1) , student_table.getString(2) , student_table.getInt(3) , student_table.getDate(4), student_table.getString(5))) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table ;
    }

    public ArrayList<Class> getAllClasses() {
        ArrayList<Class> table = new ArrayList<>() ;
        try {
            ResultSet class_table = query.executeQuery("SELECT id , name , monitor  from class_table");
            while (class_table.next()) {
                table.add(new Class(class_table.getInt(1) , class_table.getString(2) , class_table.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table ;
    }

    public int maxId() throws SQLException {

        ResultSet maxid = query.executeQuery("SELECT MAX(id) FROM student_table");
        int max = -1 ;
        while (maxid.next()) {
            max = maxid.getInt(1) ;
        }
        return max ;

    }

    public void deleteStudent(int idStudent) throws SQLException {
        // Cau lenh delete vao database
        String deletequery = "DELETE FROM student_table WHERE id = " + idStudent ;
        query.executeUpdate(deletequery);
    }

    public void addStudent(Student a) throws SQLException {

        // Cau lenh add vao database
        String addquery = "INSERT INTO student_table( name, age , date_of_birth ,email ) "
                + "VALUES ('"+  a.getName() + "'," + a.getAge() + ",'"+ a.getDate_of_birth() + "','"+a.getEmail()+"')" ;
        query.executeUpdate(addquery);

    }
    public void fixStudent(Student a) throws SQLException {

        // Cau lenh query update
        String fixquery = "UPDATE student_table "
                + "SET " + "name ='"+  a.getName() + "', age =" + a.getAge() + ",date_of_birth= '"+ a.getDate_of_birth() + "'" +", email ='"+a.getEmail()+"'"
                + "WHERE id =" + a.getId();
        query.executeUpdate(fixquery);

    }
}
