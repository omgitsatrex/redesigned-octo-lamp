import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<a href=\"/RevatureProject_1\">Home</a><br>");
//        request.getRequestDispatcher("empNavbar.html").include(request, response);

        request.getSession(false).invalidate();
        //someone mentioned they used 'session.invalidate();'

        out.println("you are logged out successfully");
    }
}
