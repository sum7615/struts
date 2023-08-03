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


public class AllUserController extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		HttpSession session = request.getSession();
		
		if (method.equals("GET")) {
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement pst = con.prepareStatement("select * from users");
				ResultSet result = pst.executeQuery();
				request.setAttribute("resultSet", result);
				return mapping.findForward("success");
			}
		}else 	if (method.equals("POST")) {
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement pst = con.prepareStatement("select * from users");
				ResultSet result = pst.executeQuery();
				request.setAttribute("resultSet", result);
				return mapping.findForward("success");
			}catch (Exception e) {
				return mapping.findForward("failure");
			}
			
		}else {
			return mapping.findForward("failure");
		}
		
		
		
	}
	
}
