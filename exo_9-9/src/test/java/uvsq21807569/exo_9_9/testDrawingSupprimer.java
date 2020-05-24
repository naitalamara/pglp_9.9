package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDrawingSupprimer {
	String cmd="delete(c) ";
	String cmd2 =  "c = cercle((1,1),3)" ;
	Cercle cercle = null ;
	@Test
	public void testsuprimer() {
		
		DrawingTUI c =new DrawingTUI()  ;
		c.nextCommand(cmd2);
		DAO<Cercle> daoc =DaoFactory.getCercleDAO();
		System.out.println("**************avant la suppression**********");
		daoc.read("c");
		c.nextCommand(cmd);
		System.out.println("**************Aprés la suppression**********");
		
		
		daoc.read("c");
	}

}
