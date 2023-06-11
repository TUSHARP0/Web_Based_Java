package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojo.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDaoImpl userDao;
	
	public void init() throws ServletException {
		try {
		userDao=new UserDaoImpl();
		}catch(Exception e){
			throw new ServletException("Error occured in connecting"+getClass(),e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
		}catch(Exception e) {
			System.out.println("Error occured in disconnecting"+getClass()+" "+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String email=request.getParameter("login");
			String password=request.getParameter("passwd");
			Users user=userDao.authenticateUser(email, password);
			if(user==null) {
				pw.print("</h2>Invalid Email and Password<a href='login.html'>Retry</a></h2>");
			}
			else {
				Cookie c1=new Cookie("user_dtls",user.toString());
				response.addCookie(c1);
				pw.print("<h2>User Details"+user+"</h2>");
				if(user.getRole()=="admin") {
					response.sendRedirect("admin_page");
				}else {
					if(user.isStatus()) {
						response.sendRedirect("logout");
					}else {
						response.sendRedirect("candidate_page");
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Error occured in service"+getClass()+" "+e);
		}
	}

}
