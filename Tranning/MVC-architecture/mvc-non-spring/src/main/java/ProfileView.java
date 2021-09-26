
public class ProfileView {
	
	private UserModel user;
	
	public ProfileView() {
		user = UserModel.loadUserData();
	}
	
	public String getView() {
		StringBuffer out = new StringBuffer();
		
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
			out.append("<meta charset=\"UTF_8\">");
			out.append("<title>Profile view</title>");
		out.append("</head>");
		out.append("<body>");
			out.append("<div>");
				out.append("<h1>Profile</h1>");
				out.append("<form action=\"../control/profile\" method=\"post\">");
					
					out.append("<label> Name: </label><br>");
					out.append("<input type=\"text\" name=\"name\" value=\"" + user.getName() + "\"/><br>");
					
					out.append("<label> Age: </label><br>");
					out.append("<input type=\"text\" name=\"age\" value=\"" + user.getAge() + "\" /><br>");
					
					out.append("<label> Major: </label><br>");
					out.append("<input type=\"text\" name=\"major\" value = \"" + user.getMajor() + "\" /><br>");
					
					out.append("<input type=\"submit\" value=\"Change\"/>");
				out.append("</form>");
			out.append("</div>");
		out.append("</body>");
		
		return out.toString();
	}
}
