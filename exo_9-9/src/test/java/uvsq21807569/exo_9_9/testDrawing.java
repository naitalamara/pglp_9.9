package uvsq21807569.exo_9_9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testDrawing {

	
	String ca =  "Ce1 = cercle((1,1),3)" ;
	Forme cer =null ;
	
	@Test
	public void test() {
		DrawingTUI c =new DrawingTUI()  ;
		cer =(Forme) c.nextCommand(ca);
		
		
		/*String []msg =ca.split("=") ;
		String []msg2=msg[1].split("cercle");
		
		InterpreteurCommandeSaisie a = new InterpreteurCommandeSaisie();
		cer=(Cercle) a.creation(msg2[1], msg[0], 0);
		System.out.println(cer.getRayon());
	
		*/
	}

}
