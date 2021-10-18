package synergix.jsf_demo_2.converters;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Locale;

@FacesConverter("NameConverter")
public class NameConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        char[] b = s.toLowerCase().toCharArray();
        b[0] -= 32 ;
        for(int i = 1; i < b.length; i++) {
            if ((b[i] == 32 )&&(b[i+1] >= 97 && b[i+1] <= 122)){
                b[i+1] -= 32;
            }
        }
        String name = String.valueOf(b);
        return name;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        char[] b = o.toString().toLowerCase().toCharArray();
        b[0] -= 32 ;
        for(int i = 1; i < b.length; i++) {
            if ((b[i] == 32 )&&(b[i+1] >= 97 && b[i+1] <= 122)){
                b[i+1] -= 32;
            }
        }
        String name = String.valueOf(b);
        return name;
    }
}
