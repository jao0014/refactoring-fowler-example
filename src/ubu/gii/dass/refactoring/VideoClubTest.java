package ubu.gii.dass.refactoring;
import junit.framework.*;

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
public class VideoClubTest extends TestCase {
	protected Movie m0, m11, m12, m2;
	protected Customer c1;
	
	protected void setUp() {
	    m11 = new Movie("Sky Captain",1);
		m12 = new Movie("Alejandro Magno",1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso",2);
		
		c1 = new Customer("Manuel");
	}
	public static Test suite() {

		return new TestSuite(VideoClubTest.class);
	}
	public void testAlquiler() {

		Rental r1 = new Rental(m11,5);
		Rental r2 = new Rental(m0,1);
		Rental r3 = new Rental(m2,10);
		
		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		
		String salida= c1.statement();
		
		String salidaEsperada = new String ("Rental Record for Manuel\n" +
		"\tSky Captain\t15.0\n"+
        "\tAccion Mutante\t2.0\n" +
        "\tHermano Oso\t12.0\n" +
        "Amount owed is 29.0\n" +
        "You earned 4 frequent renter points");
 
        assertTrue("Calcula mal el alquiler",salidaEsperada.equals(salida));
        
	}
	
	public void testAlquilerHtml() {

		Rental r1 = new Rental(m11,5);
		Rental r2 = new Rental(m0,1);
		Rental r3 = new Rental(m2,10);
		
		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		
		String salida= c1.htmlStatement();
		
		
		String salidaEsperada = new String ("<H1>Rentals for <EM>Manuel</EM></H1><P>\n" +
		"Sky Captain: 15.0<BR>\n"+
        "Accion Mutante: 2.0<BR>\n" +
        "Hermano Oso: 12.0<BR>\n" +
        "<P>You owe <EM>29.0</EM><P>\n" +
        "On this rental you earned <EM>4</EM> frequent renter points<P>");
		
		System.out.println(salida);
		System.out.println(salidaEsperada);
		
 
        assertTrue("Calcula mal el alquiler",salidaEsperada.equals(salida));
        
	}
	
	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}