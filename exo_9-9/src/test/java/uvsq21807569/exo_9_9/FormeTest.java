package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormeTest {

	@Test
	public void Cercletest() {
		Cercle c =new Cercle("c",new PositonDunPoint(0,0),2);
		assertEquals(c.getCentre().getX() , 0);
		assertEquals(c.getCentre().getY() , 0);
		assertEquals(c.getRayon(), 2);
	
		c.deplacer("c", 1, 2);
		assertEquals(c.getCentre().getX() , 1);
		assertEquals(c.getCentre().getY() , 2);
		assertEquals(c.getRayon(), 2);
		c.deplacer("c", -1, -2);
		assertEquals(c.getCentre().getX() , 0);
		assertEquals(c.getCentre().getY() , 0);
		assertEquals(c.getRayon(), 2);
		c.afficher();
	}


	@Test
	public void Triangletest() {
		Triangle b=new Triangle("b", new PositonDunPoint(0,0),new PositonDunPoint(-2,2),new PositonDunPoint(2,2));
		// le 1er point
		assertEquals(b.getA().getX() , 0);
		assertEquals(b.getA().getY() , 0);
		// le 2 point
		assertEquals(b.getB().getX() , -2);
		assertEquals(b.getB().getY() , 2);
		//le 3 point 
		assertEquals(b.getC().getX() , 2);
		assertEquals(b.getC().getY() , 2);
		
		b.deplacer("b", 1, 1);
		
		assertEquals(b.getA().getX() , 1);
		assertEquals(b.getA().getY() , 1);
		// le 2 point
		
		assertEquals(b.getB().getX() , -1);
		assertEquals(b.getB().getY() ,3);
		
		//le 3 point 
		assertEquals(b.getC().getX() , 3);
		assertEquals(b.getC().getY() , 3);
		
		b.afficher();
	}
	
	@Test
	public void Rectangletest() {
		Rectangle a=new Rectangle("a",new PositonDunPoint(1,1),10,2);
		assertEquals(a.getLongueur(), 10);
		assertEquals(a.getLargeur(), 2);
		a.deplacer("a", 2, 3);
		assertEquals(a.getP().getX(),3);
		assertEquals(a.getP().getY(),4);
		assertEquals(a.getLongueur(), 10);
		assertEquals(a.getLargeur(), 2);
		a.deplacer("a", 5, 5);
		assertEquals(a.getP().getX(),8);
		assertEquals(a.getP().getY(),9);
		a.afficher();
	}
	@Test
	public void Carretest() {
		Carré d = new Carré("d",new PositonDunPoint(3,1),5);
		assertEquals(d.getLongueur(),5);
		assertEquals(d.getP().getX(),3);
		assertEquals(d.getP().getY(),1);
		d.deplacer("d", 2, 4);
		assertEquals(d.getLongueur(),5);
		assertEquals(d.getP().getX(),5);
		assertEquals(d.getP().getY(),5);
		d.deplacer("d", 1, 1);
		assertEquals(d.getLongueur(),5);
		assertEquals(d.getP().getX(),6);
		assertEquals(d.getP().getY(),6);
		d.afficher();
		
		
	
	}
	
}
