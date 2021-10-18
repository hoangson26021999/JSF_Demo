package synergix.jsf_demo_2.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@FacesConverter("DateConverter")
public class DateConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        SimpleDateFormat formatter ;
        Date Date ;
        if(s.indexOf('/') != -1) {
             formatter = new SimpleDateFormat("dd/MM/yyyy");
        } else if (s.indexOf('-') != -1) {
            formatter= new SimpleDateFormat("dd-MM-yyyy");
        } else {
            formatter = new SimpleDateFormat("dd MM yyyy");
        }
        try {
            Date = formatter.parse(s);
        } catch (ParseException e) {

            HtmlInputText a = (HtmlInputText) uiComponent;
            a.resetValue();

            FacesMessage msg = new FacesMessage("Not support Date", "Invalid Date ");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);

        }
        return Date;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+7:00"));
        cal.setTime((Date) o);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1 ;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return day +"-"+month+"-"+year ;
    }
}
