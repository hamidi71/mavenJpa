/**
 * 
 */
package nl.programIt.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Baddi
 *22-08-2016
 */
public class PersoonServlet extends HttpServlet{
	//get en post methoden zit in de class HttpServlet
	@Override
	protected void doGet(HttpServletRequest vraag, HttpServletResponse aantwoord)
			throws ServletException, IOException {
		String naam=vraag.getParameter("naam");
		System.out.println(naam);
		
		/*PrintWriter exit =aantwoord.getWriter();
		exit.println("salaam")*/;
	}

}
