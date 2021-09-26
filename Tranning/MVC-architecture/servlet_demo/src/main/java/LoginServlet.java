
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", value = "/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Writer out = response.getWriter();
		//out.write(responseHtml);
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
			out.append("<meta charset=\"UTF_8\">");
			out.append("<title>Login form</title>");
		out.append("</head>");
		out.append("<body>");
			out.append("<div>");
				out.append("<h1>Login</h1>");
				out.append("<form action=\"LoginController\" method=\"post\">");
					out.append("<label> User-name or email address: </label><br>");
					out.append("<input type=\"text\" name=\"name\"/> <br>");
					out.append("<label> Password: </label><br>");
					out.append("<input type=\"password\" name=\"password\"/> <br>");
					out.append("<input type=\"submit\" value=\"Login\"/>");
				out.append("</form>");
			out.append("</div>");
		out.append("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
