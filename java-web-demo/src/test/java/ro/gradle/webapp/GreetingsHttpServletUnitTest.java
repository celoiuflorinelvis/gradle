package ro.gradle.webapp;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GreetingsHttpServletUnitTest {

	@Mock
	private HttpServletRequest req;
	
	@Mock
	private HttpServletResponse resp;
	
	@Mock
	private RequestDispatcher disp;
	
	
	@Before
	public void  setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void doGetTest01() throws Exception {
		StringWriter writer = new StringWriter();
		PrintWriter printer = new PrintWriter(writer);
		
		Mockito.when(req.getParameter("name")).thenReturn("ion");
		Mockito.when(resp.getWriter()).thenReturn(printer);
		
		new GreetingsHttpServlet().doGet(req, resp);
		
		Assert.assertTrue(writer.toString().contains("Greetings ion!"));
	}
	
	
	@Test
	public void doPostTest01() throws Exception {
		
		Mockito.when(req.getParameter("name")).thenReturn("popa");
		Mockito.when(req.getRequestDispatcher("greetings?name=popa")).thenReturn(disp);
		
		new SayGreetingsHttpServlet().doPost(req, resp);
		
		Mockito.verify(disp).forward(req, resp);
		
	}
	
}
