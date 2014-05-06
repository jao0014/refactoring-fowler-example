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

public class Movie {
      public static final int  CHILDRENS = 2;
      public static final int  REGULAR = 0;
      public static final int  NEW_RELEASE = 1;

      private String _title;
      private Price _priceCode;

      public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
      }
      public Price getPriceCode() {
        return _priceCode;
      }
      public void setPriceCode(int arg) {
    	  
    	  switch(arg){
    	  case 0:
    		  _priceCode=new Regular();
    	  break;
    	  case 1:
    		  _priceCode=new NewRealease();
          break;
          case 2:
        	  _priceCode=new Childrens();
          break;
    	  }
      }
      public String getTitle () {
        return _title;
      }
	/**
	 * @param thisAmount
	 * @return
	 */
	public double getCharge(int daysRented) {
		double thisAmount = 0;
		//determine amounts for each line
		   switch (_priceCode.getPriceCode()) {
		     case Movie.REGULAR:
		       thisAmount += 2;
		       if (daysRented > 2)
		         thisAmount += (daysRented - 2) * 1.5;
		     break;
		     case Movie.NEW_RELEASE:
		       thisAmount += daysRented * 3;
		     break;
		     case Movie.CHILDRENS:
		       thisAmount += 1.5;
		       if (daysRented > 3)
		         thisAmount += (daysRented - 3) * 1.5;
		      break;
		    }
		return thisAmount;
	}
	/**
	 * @param frequentRenterPoints
	 * @return
	 */
	public int getFrecuentRenterPoints(int daysRented) {
		int frequentRenterPoints=1;
		// add bonus for a two day new release rental
	    if ((_priceCode.getPriceCode() == Movie.NEW_RELEASE) &&
	         daysRented > 1)
	        frequentRenterPoints ++;
		return frequentRenterPoints;
	}
    }

