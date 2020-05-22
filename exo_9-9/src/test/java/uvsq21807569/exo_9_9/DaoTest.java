package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.TableExisteDeja;






public class DaoTest {
	Triangle triangle ;
	Carré carre ;
	Cercle cercle ;
	Rectangle rectangle ,rec;
	Groupe grp ;
	
	
	@Before
	public void init() {
		cercle=new Cercle("cercle",new PositonDunPoint(0,0),2);
		triangle=new Triangle("triangle",new PositonDunPoint(0,0),new PositonDunPoint(-2,2),new PositonDunPoint(2,2));
		carre=new Carré("carre",new PositonDunPoint(3,3),5);
		rectangle =new Rectangle("rectangle",new PositonDunPoint(3,1),4,1);
		rec =new Rectangle("rec",new PositonDunPoint(5,1),9,2);
		grp=new Groupe("grp");
		grp.ajouterforme(cercle);
		grp.ajouterforme(triangle);
	}
	
	@Test(expected = TableExisteDeja.class) 
	public void test() throws TableExisteDeja{
		System.out.println(" *********Création de la BD *********************");
		DerbyBd b= new DerbyBd();
		b.createTables();
		
	}
	
	@Test
	public void testCreationCercle() throws TableExisteDeja {
		DAO<Cercle> daoc =DaoFactory.getCercleDAO();
		System.out.println(" *********tester la creation de cercle ************");
		Cercle c2=daoc.create(cercle);
		assertEquals(c2.getNom(), cercle.getNom());
		assertEquals(c2.getCentre(),cercle.getCentre());
		assertEquals(c2.getRayon(),cercle.getRayon());
	
	}
	@Test
	public void testCreationTriangle() throws TableExisteDeja {
		DAO<Triangle> daot =DaoFactory.getTriangleDAO();
		System.out.println(" *********tester la creation de triangle ************");
		Triangle triangle2=daot.create(triangle );
		assertEquals(triangle2.getNom(),triangle.getNom());
		
		assertEquals(triangle2.getA(),triangle.getA());
		assertEquals(triangle2.getB(),triangle.getB());
		assertEquals(triangle2.getC(),triangle.getC());
		
	}
	@Test
	public void testCreationCarre() throws TableExisteDeja {
		DAO<Carré> daoca =DaoFactory.getCarreDAO();
		System.out.println(" *********tester la creation de carre ************");
		Carré carre2=daoca.create(carre);
		assertEquals(carre2.getNom(),carre.getNom());
		assertEquals(carre2.getLongueur(),carre.getLongueur());
		assertEquals(carre2.getP(),carre.getP());
		
		}
	
	@Test
	public void testCreationRectangle() throws TableExisteDeja {
		DAO<Rectangle> daorec =DaoFactory.getRectangleDAO();
		System.out.println(" *********tester la creation de Rectangle ************");
		Rectangle rectangle2=daorec.create(rectangle);
		assertEquals(rectangle2.getNom(),rectangle.getNom());
		assertEquals(rectangle2.getLargeur(),rectangle.getLargeur());
		assertEquals(rectangle2.getLongueur(),rectangle.getLongueur());
		assertEquals(rectangle2.getP(),rectangle.getP());
		rectangle2=daorec.update(rec);
		assertEquals(rectangle2.getNom(),rec.getNom());
		assertEquals(rectangle2.getLargeur(),rec.getLargeur());
		assertEquals(rectangle2.getLongueur(),rec.getLongueur());
		assertEquals(rectangle2.getP(),rec.getP());
		
	}
	
	@Test
	public void testCreationGroupe() throws TableExisteDeja {
		DAO<Groupe> daogrp =DaoFactory.getGroupeDAO();
		System.out.println(" *********tester la creation de groupe ************");
		Groupe grp2 =daogrp.create(grp);
		assertEquals(grp2.getNom(),grp.getNom());
		assertEquals(grp2.retournerListforme().size(),grp.retournerListforme().size());
		
		
	}
	
	@Test
	public void testreadCercle() {
		DAO<Cercle> daoc =DaoFactory.getCercleDAO();
		System.out.println(" *********tester Read  cercle ************");
		Cercle cercleread=daoc.read("cercle");
		assertEquals(cercleread.getNom(), cercle.getNom());
		assertEquals(cercleread.getCentre().getX(),cercle.getCentre().getX());
		assertEquals(cercleread.getCentre().getY(),cercle.getCentre().getY());
		assertEquals(cercleread.getRayon(),cercle.getRayon());
	
	}
	
	@Test
	public void testreadcarrer() {
		DAO<Carré> daoca =DaoFactory.getCarreDAO();
		System.out.println(" *********tester read  carre ************");
		Carré carre22=daoca.read("carre");
		assertEquals(carre22.getNom(),carre.getNom());
		assertEquals(carre22.getLongueur(),carre.getLongueur());
		assertEquals(carre22.getP().getX(),carre.getP().getX());
		assertEquals(carre22.getP().getY(),carre.getP().getY());
		
		}

	@Test
	public void testreadRectangle() {
		DAO<Rectangle> daorec =DaoFactory.getRectangleDAO();
		System.out.println(" *********tester read Rectangle ************");
		Rectangle rectangle2=daorec.read("rectangle");
		assertEquals(rectangle2.getNom(),rectangle.getNom());
		assertEquals(rectangle2.getLargeur(),rectangle.getLargeur());
		assertEquals(rectangle2.getLongueur(),rectangle.getLongueur());
		assertEquals(rectangle2.getP().getX(),rectangle.getP().getX());
		assertEquals(rectangle2.getP().getY(),rectangle.getP().getY());
	}
	
	
	@Test
	public void testreadTriangle() {
		DAO<Triangle> dao =DaoFactory.getTriangleDAO();
		System.out.println(" *********tester read triangle ************");
		Triangle triangle23=dao.read("triangle");

		assertEquals(triangle23.getNom(),triangle.getNom());
		assertEquals(triangle23.getA().getX(),triangle.getA().getX());
		assertEquals(triangle23.getA().getY(),triangle.getA().getY());
		assertEquals(triangle23.getB().getX(),triangle.getB().getX());
		assertEquals(triangle23.getB().getY(),triangle.getB().getY());
		assertEquals(triangle23.getC().getX(),triangle.getC().getX());
		assertEquals(triangle23.getC().getY(),triangle.getC().getY());
		
	}
	@Test
	public void testGroupe() {
		System.out.println(" *********test Groupe ************");
		System.out.println("groupe fomé au depart d'un cercle et triangle");
		assertEquals(grp.getNom(),"grp");
		assertEquals(grp.retournerListforme().size(),2);
		System.out.println("ajoute forme rectangle au groupe ");
		grp.ajouterforme(rectangle);
		assertEquals(grp.retournerListforme().size(),3);
		System.out.println("supprime le rectangle du groupe ");
		grp.supprimerforme(rectangle);
		assertEquals(grp.retournerListforme().size(),2);
		System.out.println("deplacement des frome de goupe de dx=2 ,dy=2");
		grp.deplacer("grp", 2, 2);
		assertEquals(cercle.getCentre().getX() ,2);
		assertEquals(cercle.getCentre().getY() ,2);
		
		assertEquals(triangle.getA().getX(),2 );
		assertEquals(triangle.getA().getY(),2 );
		assertEquals(triangle.getB().getX(),0 );
		assertEquals(triangle.getB().getY(),4 );
		assertEquals(triangle.getC().getX(),4 );
		assertEquals(triangle.getC().getX(),4);
		
	}
	

}
	


