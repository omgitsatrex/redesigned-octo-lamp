import employee.Employee;
import employee.EmployeeDao;
import employee.EmployeeDaoFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;

public class EmpLoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        Employee employee = employeeDao.getEmployeeByUsername(username);

        if(employee!=null && employee.getPassword().equals(password)){

            request.getRequestDispatcher("empNavbar.html").include(request, response);
//            out.println("<a href='Servlet6'>Click Here</a>");

            out.println("You are successfully logged in");
            out.println("<br>Welcome, " + employee.getPassword());

            //Http Session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        else{
            out.println("<br>Sorry! invalid details");
            request.getRequestDispatcher("/empLogin.html").include(request, response);
        }
        out.close();
    }
}
