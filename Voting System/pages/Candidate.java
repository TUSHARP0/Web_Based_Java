package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Candidate
 */
@WebServlet("/candidate_page")
public class Candidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			Cookie[] cookie=request.getCookies();
			if(cookie!=null) {
				for(Cookie c:cookie) {
					if(c.getName().equals("user_dtls")) {
					pw.print("<h2>User Details : "+c.getValue()+"</h2>");
					}else {
						pw.print("<h2>Session tracking failed</h2>");
					}
					}
			}
		}
	}

}
