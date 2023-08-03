package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DeleteController extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pathInfo = request.getRequestURI();
		String[] pathParts = pathInfo.split("/");
		String s = pathParts[3];
		String[] idParameter1 = s.split("\\.");
		String idParameter = idParameter1[0];
		if (pathParts.length > 1) {
			long id = Long.parseLong(idParameter);
			try (Connection con = Utils.dbConnection()) {
				PreparedStatement pst = con.prepareStatement("delete from users where id =?");
				pst.setLong(1, id);
				int rowCount = pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "success");
					request.setAttribute("successMessage", "User Deleted Successfully");
				} else {
					request.setAttribute("status", "failed");
					request.setAttribute("errorMessage", "User not found or could not be deleted!");
				}
			}
		}
		return mapping.findForward("success");

	}
}
