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
public class CLassManagement implements Serializable {

    @Inject
    private PostgresData DataBase ;
    private ArrayList<Class> Classes;

    @PostConstruct
    public void setClasses() throws SQLException {
        DataBase.open();
        this.Classes = DataBase.getAllClasses();
    }

    public ArrayList<Class> getClasses() {
        return Classes;
    }
}
