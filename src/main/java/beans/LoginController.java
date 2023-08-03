package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginController extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if (method.equals("GET")) {
			return mapping.findForward("success");
		} else if (method.equals("POST")) {
			Login myForm = (Login) form;
			String user_name = myForm.getUser_name();
			String password = myForm.getPassword();
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement pst = con
						.prepareStatement("select id,name,role from users where user_name=? and password =?");
				pst.setString(1, user_name);
				pst.setString(2, password);
				ResultSet result = pst.executeQuery();
				if (result.next()) {
					String name = result.getString("name");
					HttpSession session = request.getSession();

					session.setAttribute("uname", user_name);
					session.setAttribute("role", result.getString("role"));
					session.setAttribute("name", result.getString("name"));
					session.setAttribute("id", result.getString("id"));

					request.setAttribute("name", name);
					request.setAttribute("status", "success");
					request.setAttribute("successMessage", "Loged in Successfully");
					return mapping.findForward("success");
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("errorMessage", "Something went wrong");
					return mapping.findForward("failure");
				}

			}
		}
		return mapping.findForward("failure");
	}
}
