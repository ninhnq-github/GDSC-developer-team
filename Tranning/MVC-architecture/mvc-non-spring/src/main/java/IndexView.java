
public class IndexView {
	public String getView() {
		StringBuffer out = new StringBuffer();
		
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
			out.append("<meta charset=\"UTF_8\">");
			out.append("<title>home page</title>");
		out.append("</head>");
		out.append("<body>");
			out.append("<div>");
				out.append("<h1>Welcome to MVC demo application</h1>");
				out.append("<a href=\"view/login\">Go to login page</a>");
			out.append("</div>");
		out.append("</body>");
		
		return out.toString();
	}
}
