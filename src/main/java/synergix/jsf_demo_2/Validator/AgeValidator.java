package synergix.jsf_demo_2.Validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("AgeValidator")
public class AgeValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        int age =  Integer.parseInt(o.toString()) ;
        if (age < 18 ) {

            HtmlInputText a = (HtmlInputText) uiComponent;
            a.resetValue();

            FacesMessage msg = new FacesMessage(" You are too young", "Invalid Age");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
