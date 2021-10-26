import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("HomeControler")
@SessionScoped
public class HomeControler implements Serializable {
    private Conversation conversation;

    private String viewID;

    public void goStudentManagement() {

        conversation.begin();

        viewID = "Student Management" ;
    }
    public void goClassManagement() {
        conversation.begin();
        viewID = "Class Management" ;
    }
    public void back() {
        conversation.end();
        viewID = null ;
    }

    public String getViewID() {
        return viewID;
    }

    public void setViewID(String viewID) {
        this.viewID = viewID;
    }
}
