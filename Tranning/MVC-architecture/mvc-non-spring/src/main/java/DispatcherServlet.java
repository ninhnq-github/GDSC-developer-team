

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 * 
 * 1) This is a dispatcher servlet which could be a powerful facilitator
 * All the request to server must be handled by this servlet
 * 
 * 2) The first method which have the highest priority to be called is <protected void service(...)>
 * <protected void service(...)> will first receive all the request and consider 
 * what is method it need to call (may be doPost, doGet, doPut, doDelete ...)
 * 
 * 3) when all the request come and reach this servlet it's objective is call the 
 * suitable controller / view which will actually process the user request.
 * 
 * OK, it's enough, let take a look at <protected void service(...)> to see 
 * How does it work? ... 
 * 
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step 1: get request URI 
		String app_name = "/mvc-non-spring";
		String uri = request.getRequestURI();
		if (uri.startsWith(app_name))
			uri = uri.substring(app_name.length());
		//response.getWriter().append("Served at: Dispatcher Servlet with requets path is:  " + uri);
		
		if (uri.equals("/") || uri.equals("/*")) {
			// index page view
			response.getWriter().append(new IndexView().getView());
			return;
		}	
		
		//Step 2: decode URI to get the actual destination
		if (uri.startsWith("/view"))
		{
			// so now we know that user call view :)) 
			// let call the exact view user want
			uri = uri.substring("/view".length());
			if (uri.startsWith("/login"))
			{
				// now that mean the request URI = /view/login/*
				// response.getWriter().append("Login view would be call here!");
				response.getWriter().append(new LoginView().getView());
			}
			else if (uri.startsWith("/profile"))
			{
				// now that mean the request URI = /view/profile/*
				// response.getWriter().append("Profile view would be call here!");
				response.getWriter().append(new ProfileView().getView());
			}
			else
			{
				// another things
				response.getWriter().append("Sorry the request is sent to a wrong place!");
				response.sendRedirect("/");
			}
		}
		else if (uri.startsWith("/control"))
		{
			// so now we know that user call controller :)) 
			// let call the exact controller user want
			uri = uri.substring("/control".length());
			if (uri.startsWith("/login"))
			{
				// now that mean the request URI = /control/login/*
				// response.getWriter().append("Login controller would be call here!");
				LoginController loginController = new LoginController();
				boolean login  = loginController.login(request.getParameter("name"), request.getParameter("pass"));
				if (login == true) {
					response.getWriter().append(new ProfileView().getView());
				}
				else {
					response.getWriter().append(new LoginView().getView());
				}
			}
			else if (uri.startsWith("/profile"))
			{
				// now that mean the request URI = /control/profile/*
				// response.getWriter().append("Profile controller would be call here!");
				ProfileController profile = new ProfileController();
				profile.updateProfile(request.getParameter("name"), request.getParameter("age"), request.getParameter("major"));
				response.getWriter().append(new ProfileView().getView());
			}
			else
			{
				// another things
				response.getWriter().append("Sorry the request is sent to a wrong place!");
				response.sendRedirect("/");
			}
		}
		else {
			response.getWriter().append("Sorry the request is sent to a wrong place!");
			response.sendRedirect("/");
		}
		
		/*
		 * Now you explored all the work of the dispatcher servlet
		 * This is very very simple application and you see how long this method is?
		 * Don't be worry, it's just a example 
		 * When you have your application powered by Spring Boot 
		 * Every things would be more nice and convenience to you !!!!!!!!
		 */
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
