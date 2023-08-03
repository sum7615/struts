package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserController extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionErrors errors = form.validate(mapping, request);
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("failure");
		}

		User myForm = (User) form;
		String name = myForm.getName();
		String password = myForm.getPassword();
		String email = myForm.getEmail();
		String user_name = myForm.getUser_name();
		String dob1 = myForm.getDob();
		Date dob = Date.valueOf(dob1);
		Long mobile_no = Long.parseLong(myForm.getMobile_no());

		if (Utils.isValidDetails(password, email, myForm.getMobile_no())) {
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement pst = con.prepareStatement(
						"INSERT INTO users (name, password, email, user_name, dob,mobile_no)VALUES (?, ?, ?, ?, ?,?)");
				pst.setString(1, name);
				pst.setString(2, password);
				pst.setString(3, email);
				pst.setString(4, user_name);
				pst.setDate(5, dob);
				pst.setLong(6, mobile_no);
				int c = pst.executeUpdate();
				if (c > 0) {
					request.setAttribute("status", "success");
					request.setAttribute("successMessage", "User Created Successfully");
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("errorMessage", "Have you given all data?");
				}
			}
			return mapping.findForward("success");
		} else {
			request.setAttribute("status", "failed");
			request.setAttribute("errorMessage", "Have you given all data?");
			return mapping.findForward("failure");
		}

	}
}
