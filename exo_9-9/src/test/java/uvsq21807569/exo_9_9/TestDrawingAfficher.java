package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDrawingAfficher {
	String cmd="afficher(Ce1) ";
	String cmd2="afficher(trr) ";
	String cmd3="afficher(Carr) ";
	@Test
	public void testDrawingAfficher() {
		DrawingTUI c =new DrawingTUI()  ;
		c.affichage(cmd);
		
		c.affichage(cmd2);
		
		c.affichage(cmd3);
		
	}

}
