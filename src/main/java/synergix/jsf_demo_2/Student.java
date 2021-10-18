package synergix.jsf_demo_2;

import java.util.Date;

public class Student {
    private int id ;
    private String name;
    private int age ;
    private Date date_of_birth ;
    private String email;

    public Student()
    {
         id = 0;
         name = "Nguyen Van A";
         age= 0 ;
         date_of_birth= new Date() ;
         email= "example@gmail.com";
    }

    public Student(int id, String name, int age, Date date_of_birth , String email) {
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

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
