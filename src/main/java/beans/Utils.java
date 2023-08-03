package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static Connection dbConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/struts";
		return DriverManager.getConnection(url, "postgres", "7615");
	}
	public static boolean isValidDetails(String password, String email, String contact) {
		String passPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		String contactPattern = "^\\d{10}$";

		Pattern pass_pattern = Pattern.compile(passPattern);
		Pattern email_pattern = Pattern.compile(emailPattern);
		Pattern contact_pattern = Pattern.compile(contactPattern);


		Matcher passMatcher = pass_pattern.matcher(password);
		Matcher emailMatcher = email_pattern.matcher(email);
		Matcher contactMatcher = contact_pattern.matcher(contact);


		if (passMatcher.matches() && emailMatcher.matches() && contactMatcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
