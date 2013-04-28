package beans;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class LocaleChanger {
	public String englishAction(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.GERMAN);
		return null;
	}
}
