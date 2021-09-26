
public class LoginView {
	
	public String getView() {
		StringBuffer out = new StringBuffer();
		
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
			out.append("<meta charset=\"UTF_8\">");
			out.append("<title>Login form</title>");
		out.append("</head>");
		out.append("<body>");
			out.append("<div>");
				out.append("<h1>Login</h1>");
				out.append("<form action=\"../control/login\" method=\"post\">");
					out.append("<label> User-name or email address: </label><br>");
					out.append("<input type=\"text\" name=\"name\"/> <br>");
					out.append("<label> Password: </label><br>");
					out.append("<input type=\"password\" name=\"pass\"/> <br>");
					out.append("<input type=\"submit\" value=\"Login\"/>");
				out.append("</form>");
			out.append("</div>");
		out.append("</body>");
		
		return out.toString();
	}

}
