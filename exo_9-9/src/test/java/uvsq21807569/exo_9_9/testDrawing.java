package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testDrawing {

	
	String ca =  "Ce1 = cercle((1,1),3)" ;
	String cmd2 ="Ce2 = cercle((4,6),90)" ;
	
	Forme cer =null ;
	Cercle c2, c3 ; 
	Triangle tr1 ;
	Forme cer2 = null ;
	Carré car ;
	
	
	String cmd3= "trr=triangle((2,2),(0,0),(7,5))";
	String cmd4 = "Carr=carre((3,5),9)";
	
	
	@Test
	public void testCreationCercle() {
		System.out.println("********test creation d cercle************");
		DrawingTUI c =new DrawingTUI()  ;
		cer =(Forme) c.nextCommand(ca);
		DAO<Cercle> daoc =DaoFactory.getCercleDAO();
		c2=daoc.read("Ce1");
		assertEquals(c2.getRayon() , 3);
		assertEquals(c2.getCentre().getX() , 1);
		assertEquals(c2.getCentre().getY() , 1);
	
		cer2 =(Forme) c.nextCommand(cmd2);
		c2=daoc.read("Ce2");
		assertEquals(c2.getRayon() , 90);
		assertEquals(c2.getCentre().getX() ,4);
		assertEquals(c2.getCentre().getY() ,6);
		
	}
	@Test
	public void testCreationTriangle() {
		System.out.println("********test creation d triangle*****************");
		DrawingTUI c =new DrawingTUI()  ;
		cer =(Forme) c.nextCommand(cmd3);
		DAO<Triangle> daoc =DaoFactory.getTriangleDAO();
		tr1=daoc.read("trr");
		assertEquals(tr1.getA().getX() , 2);
		assertEquals(tr1.getA().getY() , 2);
		assertEquals(tr1.getB().getX() , 0);
		assertEquals(tr1.getB().getY() , 0);
		assertEquals(tr1.getC().getX() , 7);
		assertEquals(tr1.getC().getY() , 5);
		
		
	}
	@Test
	public void testCreationCarré() {
		System.out.println("********test creation d Carree*****************");
		DrawingTUI c =new DrawingTUI()  ;
		cer =(Forme) c.nextCommand(cmd4);
		DAO<Carré> daoc =DaoFactory.getCarreDAO();
		car=daoc.read("Carr");
		assertEquals(car.getLongueur() , 9);
		assertEquals(car.getP().getX() , 3);
		assertEquals(car.getP().getY() , 5);
		
		
		
	}
	

	

}
