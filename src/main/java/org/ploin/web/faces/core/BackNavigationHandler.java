/**
 * Copyright [2008] [PLOIN GmbH -> http://www.ploin.de]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.ploin.web.faces.core;

import com.sun.faces.application.NavigationHandlerImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Stack;

/**
 * This Class handle the navigation
 * <p/>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 126 $<br>
 * $Date: 2010-05-22 18:46:29 +0200 (Sat, 22 May 2010) $<br>
 */
public class BackNavigationHandler extends NavigationHandlerImpl implements Serializable{

	private static final long serialVersionUID = 4582130084496276001L;
	private static Log log = LogFactory.getLog(BackNavigationHandler.class);

	public BackNavigationHandler(){
		log.debug("construct BackNavigationHandler");
	}

	@Override
	public void handleNavigation(FacesContext facesContext, String fromAction, String outcome) {
		String viewId = facesContext.getViewRoot().getViewId();
		log.debug("outcome " + outcome);

		HttpServletRequest request =  (HttpServletRequest)facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		Stack<String> lastViewIds = (Stack<String>) session.getAttribute("lastViewIds");
		if (lastViewIds == null)
			lastViewIds = new Stack<String>();

		session.setAttribute("ploinFacesFromViewId", viewId);

		if (outcome != null){
			if ("back".equals(outcome)){
				String lastViewId = lastViewIds.pop();
				navigateToViewId(facesContext, lastViewId);
				return;
			}else if ("backback".equals(outcome)){
				lastViewIds.pop();
				String lastViewId = lastViewIds.pop();
				navigateToViewId(facesContext, lastViewId);
				return;
			}else if ("backbackback".equals(outcome)){
				lastViewIds.pop();
				lastViewIds.pop();
				String lastViewId = lastViewIds.pop();
				navigateToViewId(facesContext, lastViewId);
				return;
			}else if ("back4".equals(outcome)){
				lastViewIds.pop();
				lastViewIds.pop();
				lastViewIds.pop();
				String lastViewId = lastViewIds.pop();
				navigateToViewId(facesContext, lastViewId);
				return;
			}else if ("back5".equals(outcome)){
				lastViewIds.pop();
				lastViewIds.pop();
				lastViewIds.pop();
				lastViewIds.pop();
				String lastViewId = lastViewIds.pop();
				navigateToViewId(facesContext, lastViewId);
				return;
			}else {

				String out = outcome;
				if (out == null)
					out = "";
				out = out.replaceFirst("->", "");

				if (lastViewIds.isEmpty())
					lastViewIds.push(viewId);
				else if (!lastViewIds.peek().equals(viewId) && !out.equals(viewId))
					lastViewIds.push(viewId);

				if (lastViewIds.size() > 10)
					lastViewIds.remove(0);

				if (outcome.startsWith("->")){
					outcome = outcome.replaceFirst("->", "");
					navigateToViewId(facesContext, outcome);
					return ;
				}
			}
		}
		session.setAttribute("lastViewIds", lastViewIds);
		super.handleNavigation(facesContext, fromAction, outcome);
		log.debug("after navigation");
	}


	private void navigateToViewId(FacesContext facesContext, final String lastViewId){
		log.debug("navigateToViewId to " + lastViewId);
		ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(facesContext, lastViewId);
		facesContext.setViewRoot(viewRoot);
		facesContext.renderResponse();
	}

}
