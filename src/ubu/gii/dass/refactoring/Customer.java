package ubu.gii.dass.refactoring;

/**
 * Tema  Refactorizaciones 
 *
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones genéricas de java 1.5
 *
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 *
 */
import java.util.*;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals;

	public Customer (String name)	{
		_name = name;
		_rentals = new Vector<Rental>();

	};
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName ()	{
		return _name;
	};
	
	public String statement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each._movie.getCharge(each)) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
	
	public String htmlStatement() {
		  Enumeration<Rental> rentals = _rentals.elements();
		  String result = "<H1>Rentals for <EM>" + getName() +
		    "</EM></H1><P>\n";
		  while (rentals.hasMoreElements()) {
		    Rental each = rentals.nextElement();
		    //show figures for each rental
		    result += each.getMovie().getTitle()+ ": " +
		           String.valueOf(each._movie.getCharge(each)) + "<BR>\n";
		  }
		  //add footer lines
		  result +=  "<P>You owe <EM>" + 
		         String.valueOf(getTotalCharge())+ "</EM><P>\n";
		  result += "On this rental you earned <EM>" +    
		         String.valueOf(getTotalFrequentRenterPoints()) +
		         "</EM> frequent renter points<P>";
		  return result;
	} 


	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each._movie.getCharge(each);
		}
		return result;
	}
	private int getTotalFrequentRenterPoints(){
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each._movie.getFrecuentRenterPoints(each);
		}
		return result;
	}
}

