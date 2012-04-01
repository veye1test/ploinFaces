package mock;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Locale;

/**
 * <code><pre>
 *                                    ........
 *                                 .WHHUUVOOOOU&,
 *     dMMMMMMMMMMMa,   .MMMMF   .MHW0Oz+!``````?G.   .MMMM% .MMMMMMMMMMMN,
 *    .MMMMMMMMMMMMMMr  JMMMM   JHHXwOz;:^..```  `O,  JMMM#  dMMMMMMMMMMMMN
 *    JMMM#     ,MMMMF  MMMMF  .MHVXwOz++.^.````  +n .MMMM$ .MMMMt    dMMM#
 *   .MMMMt     .MMMMt .MMMM!  JMHWWXwOz++....  `.+X JMMMM  JMMMM    .MMMM%
 *   JMMM#     .MMMM@  dMMM#   ,MHHWWXwOzz+++....?df MMMMF .MMMMF    JMMM#
 *  .MMMMNNNNNMMMMMD   MMMMMNNm 4MHHWWXXwOOzzz1+1wX'.MMMM! .MMMM`   .MMMM$
 *  .MMMMMMMMMMMM"`    .YMMMMMF  TMHHHWWWXXXwwwwXK! MMMMF  MMMMF    JMMMM
 *  MMMMF                          TMMHHHHHWWWHY^
 * .MMMM'                             `7""""^`
 * dMMM#
 * </pre></code>
 * <p/>
 * $HeadURL: https://ploinscm.de/svn/ploinFaces/trunk/src/test/java/mock/ViewHandlerMock.java $<br>
 * $LastChangedBy: r.reiz $<br>
 * $Revision: 73 $<br>
 * $Date: 2009-04-27 17:39:05 +0200 (Mon, 27 Apr 2009) $<br>
 */
public class ViewHandlerMock extends ViewHandler {

	public Locale calculateLocale(FacesContext facesContext) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String calculateRenderKitId(FacesContext facesContext) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public UIViewRoot createView(FacesContext facesContext, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getActionURL(FacesContext facesContext, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public String getResourceURL(FacesContext facesContext, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void renderView(FacesContext facesContext, UIViewRoot uiViewRoot) throws IOException, FacesException {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public UIViewRoot restoreView(FacesContext facesContext, String s) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public void writeState(FacesContext facesContext) throws IOException {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
