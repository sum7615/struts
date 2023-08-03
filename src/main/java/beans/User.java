package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class User extends ActionForm {
	private static final long serialVersionUID = -308590102916342695l;
	private String name, password, email, user_name, dob, mobile_no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (name == null || name.trim().isEmpty()) {
			errors.add("name", new org.apache.struts.action.ActionMessage("error.name.required"));
		}
		if (password == null || password.trim().isEmpty()) {
			errors.add("password", new org.apache.struts.action.ActionMessage("error.password.required"));
		}
		if (email == null || email.trim().isEmpty()) {
			errors.add("email", new org.apache.struts.action.ActionMessage("error.email.required"));
		} else if (!email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
			errors.add("email", new org.apache.struts.action.ActionMessage("error.email.invalid"));
		}
		if (user_name == null || user_name.trim().isEmpty()) {
			errors.add("user_name", new org.apache.struts.action.ActionMessage("error.user_name.required"));
		}
		if (dob == null || dob.trim().isEmpty()) {
			errors.add("dob", new org.apache.struts.action.ActionMessage("error.dob.required"));
		}
		if (mobile_no == null || mobile_no.trim().isEmpty()) {
			errors.add("mobile_no", new org.apache.struts.action.ActionMessage("error.mobile_no.required"));
		} else if (!mobile_no.matches("\\d+")) {
			errors.add("mobile_no", new org.apache.struts.action.ActionMessage("error.mobile_no.invalid"));
		}

		return errors;
	}

}
