/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;


import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	public static TestSuite suite()
	{
		TestSuite suite= new TestSuite("raiz");
		suite.addTestSuite(ColeccionFichasTest.class);
		suite.addTestSuite(ArbolFichasPorAnhoTest.class);
		suite.addTestSuite(ArbolFichasPorPropietarioTest.class);
		return suite;
	}
}
