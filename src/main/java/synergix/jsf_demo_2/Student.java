package synergix.jsf_demo_2;

import java.util.Date;

public class Student {
    private int id ;
    private String name;
    private int age ;
    private String date_of_birth ;
    private String email;

    public Student()
    {
         id = 0;
         name = "Nguyen Van A";
         age= 0 ;
         date_of_birth="2000-1-1" ;
         email= "example@gmail.com";
    }

    public Student(Student a)
    {
        this.id = a.getId() ;
        this.name =a.getName() ;
        this.age =a.getAge() ;
        this.date_of_birth =a.getDate_of_birth() ;
        this.email =a.getEmail() ;
    }

    public Student(int id, String name, int age, String date_of_birth , String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date_of_birth = date_of_birth;
        this.email = email ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
