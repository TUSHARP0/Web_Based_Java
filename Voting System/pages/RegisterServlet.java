package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Users;
import dao.UserDaoImpl;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	Users NEWUSER;
	private UserDaoImpl userDAO;
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");

	
		try(PrintWriter PW = response.getWriter()){
			userDAO=new UserDaoImpl();
			String FNAME = request.getParameter("fnm");
			String LNAME = request.getParameter("lnm");
			String EMAIL = request.getParameter("em");
			String PASSWORD = request.getParameter("pass");
			String DATE = request.getParameter("dt");
			String STATUS = userDAO.registeredUser(FNAME,LNAME,EMAIL,PASSWORD,DATE);
			if(STATUS.equals("Success")) {
				response.sendRedirect("login.html");
			}else {
				PW.print("<h2> Registration Failed</h2>");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
