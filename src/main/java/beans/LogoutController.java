package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutController extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			request.setAttribute("status", "success");
			request.setAttribute("successMessage", "Loged out Successfully");
			return mapping.findForward("success");
		} else {
			request.setAttribute("status", "success");
			request.setAttribute("successMessage", "Login first");
			return mapping.findForward("failure");
		}
	}

}
