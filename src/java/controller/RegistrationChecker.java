package controller;
import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;
import model.RegistrationAuthenticator;

public class RegistrationChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.sendRedirect("login.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String eid = request.getParameter("eid");
        String salary = request.getParameter("salary");
        String city = request.getParameter("city");
        String password = request.getParameter("password");
        
        UserDTO user = new UserDTO();
        
        user.setUsername(username);
        user.setPassword(password);
        user.setEid(eid);
        user.setCity(city);
        user.setSalary(salary);
        
        RegistrationAuthenticator ra = new RegistrationAuthenticator();
        boolean register = ra.isRegister(user);
        
        if(register)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            response.sendRedirect("home.jsp");
        }
        else
        {
            response.sendRedirect("login.html");
        }
    }
}
