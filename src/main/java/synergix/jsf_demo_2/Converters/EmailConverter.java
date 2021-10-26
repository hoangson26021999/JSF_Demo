package synergix.jsf_demo_2.Converters;

import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("EmailConverter")
public class EmailConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        StringBuilder url = new StringBuilder();

        url.append(value);

        if(!value.endsWith("@gmail.com")) {
            url.append("@gmail.com");
        }
        try {
            new URI(url.toString());
        } catch (URISyntaxException e) {
            FacesMessage msg = new FacesMessage("Error converting URL",
                    "Invalid URL format");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        return url;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
    }
}
