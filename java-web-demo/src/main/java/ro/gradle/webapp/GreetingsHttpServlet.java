package ro.gradle.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "greetings", urlPatterns = {"greetings"}, loadOnStartup = 1)
public class GreetingsHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 7905699734546951L;

	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = 
				req.getParameter("name");
		if (name != null && name.equals("error") == true){
			throw new RuntimeException("ERROR - CUSTOM");
		}
		String message = 
				String.format("Greetings %s!", (name == null)?" (please insert NAME) ":name );
		resp.getWriter().println("<html><head><title>Greetings!</title></head><body><b>" + message + "</b><br/><br/><br/><a href=\"index.html\">Back</a></body></html>");
	}

	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
