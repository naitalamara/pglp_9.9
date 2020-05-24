package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDrawingDeplacer {
	String cmd5="move(caaa,(1,1)) ";

	String ca =   "caaa=carre((1,2),3)"; ;
	Forme b = null ;
	Carré c2 = null ; ;
	@Test
	public void testDeplacement() {
		DrawingTUI c =new DrawingTUI()  ;
		b = (Forme) c.nextCommand(ca);
		System.out.println("au debut le carré etait carre((1,2), r=3) ");
		DAO<Carré> daoc =DaoFactory.getCarreDAO();
		c2=daoc.read("caaa");
		//c.nextCommand(cmd5);
		System.out.println("apre deplacement dx=1 et dy=1");
		c2.afficher();
		assertEquals(c2.getP().getX()  , 2);
		assertEquals(c2.getP().getY()  , 3);
	
		
	}

}
