package synergix.jsf_demo_2.CustomComponent;

import javax.faces.component.FacesComponent;

import javax.faces.component.UIComponentBase;


@FacesComponent(createTag = true, tagName = "cusComponent" , namespace = "http://java.sun.com/jsf/composite")
public class UICusComponent extends UIComponentBase {
    @Override
    public String getFamily() {
        return "Greeting";
    }

}
