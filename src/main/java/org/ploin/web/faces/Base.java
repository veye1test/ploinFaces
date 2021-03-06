package org.ploin.web.faces;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.Application;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 84 $<br>
 * $Date: 2009-11-12 15:18:32 +0100 (Thu, 12 Nov 2009) $<br>
 * <p/>
 * Created by: robert
 * Created date: Nov 11, 2009 - 10:46:45 PM
 * <p/>
 * Description:
 */
public class Base {

	private static Log log = LogFactory.getLog(Base.class);

	/**
	 * This method returns a instance of application's default resource bundle.
	 *
	 * @return instance of ResourceBundle
	 */
	public ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle(getApplication().getMessageBundle(), getLocale());
	}


	/**
	 * This method returns a instance of the application.
	 *
	 * @return instance of Application
	 */
	public static Application getApplication() {
		return getFacesContext().getApplication();
	}

	/**
	 * This method returns the current instance of the faces context.
	 *
	 * @return instance of FacesContext
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 *	This method returns the locale from the viewRoot.
	 *
	 * @return locale
	 */
	public Locale getLocale(){
		if (getViewRoot() != null){
			return getViewRoot().getLocale();
		} else {
			log.info("getLocale(), Viewroot is null");
			return null;
		}
	}

	/**
	 * set the locale in the viewRoot.
	 *
	 * @param locale
	 */
	public void setLocale(Locale locale){
		if (getViewRoot() != null){
			getViewRoot().setLocale(locale);
		} else {
			log.info("setLocale("+locale.toString()+") ViewRoot is null");
		}
	}

	/**
	 * This method returns the viewRoot from the currentInstance of the FacesContext
	 *
	 * @return the viewRoot
	 */
	public UIViewRoot getViewRoot(){
		return FacesContext.getCurrentInstance().getViewRoot();
	}

	/**
	 * Returns the actual ID of the ViewRoot.
	 *
	 * @return the actual ID of the ViewRoot
	 */
	public String getViewRootId(){
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}
}