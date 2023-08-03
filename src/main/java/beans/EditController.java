package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EditController extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String method = request.getMethod();
		if (method.equals("GET")) {
			String pathInfo = request.getRequestURI();
			String[] pathParts = pathInfo.split("/");
			String s = pathParts[3];
			String[] idParameter1 = s.split("\\.");
			String idParameter = idParameter1[0];
			if (pathParts.length > 1) {
				long id = Long.parseLong(idParameter);
				try (Connection con = Utils.dbConnection()) {
					PreparedStatement pst = con.prepareStatement("select * from users where id =?");
					pst.setLong(1, id);
					ResultSet result = pst.executeQuery();
					if (result.next()) {
						request.setAttribute("user", result);
						return mapping.findForward("success");
					} else {
						return mapping.findForward("failure");
					}
				}
			} else {
				return mapping.findForward("failure");
			}

		} else if (method.equals("POST")) {
			Edit myForm = (Edit) form;
			String name = myForm.getName();
			String email = myForm.getEmail();
			Long mobile_no = Long.parseLong(myForm.getMobile_no());
			String user_name = myForm.getUser_name();
			String date = myForm.getDob();
			Date dob = Date.valueOf(date);
			long id = Long.parseLong(myForm.getId());
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement qst = con
						.prepareStatement("UPDATE users SET name=?, email=?, mobile_no=?, dob=?, user_name=? WHERE id=?");
				qst.setString(1, name);
				qst.setString(2, email);
				qst.setLong(3, mobile_no);
				qst.setDate(4, dob);
				qst.setString(5, user_name);
				qst.setLong(6,id);
				int row = qst.executeUpdate();
				qst.close();
				if (row > 0) {
					request.setAttribute("status", "success");
					request.setAttribute("successMessage", "User Updated Successfully");
					return mapping.findForward("success");
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("errorMessage", "Error happend");
					return mapping.findForward("failure");
				}

			}
		} else {
			return mapping.findForward("failure");
		}

	}
}
