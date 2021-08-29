package ninhnq.app.Hello_App;

import sun.rmi.server.Dispatcher;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NinhServlet", value = "/ninh-servlet")
public class NinhServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String age_string = request.getParameter("age");
        Integer age = Integer.valueOf(age_string);

        request.setAttribute("age",age);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String age_string = request.getParameter("age");
        Integer age = Integer.valueOf(age_string);

        request.setAttribute("age",age);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(request,response);
    }
}