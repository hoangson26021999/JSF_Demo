package synergix.jsf_demo_2;

import synergix.jsf_demo_2.PostgresData.PostgresData;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

@Named("classTable")
@ConversationScoped
public class ClassManagement implements Serializable {

    @Inject
    private PostgresData DataBase ;
    private Class currentClass;
    private ArrayList<Class> Classes;

    public static int count = 0 ;

    public void deleteClass(int idClass) throws SQLException {
        DataBase.deleteClass(idClass);
        Classes = DataBase.getAllClasses();
    }

    public void openfixingClass(Class a) {
        currentClass = a ;
    }

    public void openaddingClass() throws SQLException {
        currentClass = new Class() ;
        currentClass.setId(DataBase.maxIdClass()+1);
        // add
        DataBase.addClass(currentClass);
    }

    public void submit() throws SQLException {
        DataBase.fixClass(currentClass);
    }

    public void back()  {
        //reload
        Classes = DataBase.getAllClasses();
        // clean currentStudent
        currentClass = null;
    }

    public Class getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(Class currentClass) {
        this.currentClass = currentClass;
    }

    @PostConstruct
    public void setClasses() throws SQLException {
        DataBase.open();
        this.Classes = DataBase.getAllClasses();
        System.out.println(count);
        count++;
    }

    public ArrayList<Class> getClasses() {
        return Classes;
    }
}
