
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
	protected void doGet(HttpServletRequest vraag, HttpServletResponse aantword)
			throws ServletException, IOException {
		//HttpServletRequest ontvangen(vraag)
		//HttpServletResponse verzenden(aantword)
		String naam=vraag.getParameter("naamIndex");
		int leeftijd=Integer.valueOf(vraag.getParameter("leeftijdIndex"));
		
		//System.out.println("naam is: "+ naam + "en leeftijd is: "+ leeftijd);
		vraag.setAttribute("naamHome", naam);
		vraag.setAttribute("leeftijdHome", leeftijd);
		vraag.getRequestDispatcher("home.jsp").forward(vraag, aantword);;
		
		
		
	}

}
