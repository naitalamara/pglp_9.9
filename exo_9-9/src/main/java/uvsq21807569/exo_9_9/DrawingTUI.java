package uvsq21807569.exo_9_9;

import Cmd.CmdCreer;
import Cmd.CmdDeplacer;
import Cmd.Commande;

public class DrawingTUI {
	InterpreteurCommandeSaisie c  = new InterpreteurCommandeSaisie(); ; 
	
	
	
	
	public Commande nextCommand(final String cmd) {
		String[] position = null ; ;
		Forme forme = null ;
		if(cmd.contains("=")){
		//	cmd="c=cercle((1,6),2)"
		String[] contenucmd ;
		contenucmd=cmd.split("=");
		//contenucmd[0]= c
	    //		     [1]=cercle((1,6),2)
		if(contenucmd.length !=2) {
			System.out.println("erreur de la saisie commande ");
		}
		
		
		if(contenucmd[1].contains("cercle") ) {
				position=contenucmd[1].split("cercle");
				//position =((1,6),2)
			
				if(position.length != 0) {
				
				Cercle ca ;
				ca=  (Cercle) c.creation(position[1], contenucmd[0], 0);
			
				forme = ca ;
				}
			
		}else if(contenucmd[1].contains("triangle") ) {
				position=contenucmd[1].split("triangle");
				if(position.length != 0) {
				Triangle ca ;
				
				ca=(Triangle) c.creation(position[1], contenucmd[0], 1);
				forme = ca ;}
		}else if(contenucmd[1].contains("carre") ) {
				position=contenucmd[1].split("carre");
				
				if(position.length != 0) {
					Carré ca ;
					ca=(Carré) c.creation(position[1], contenucmd[0], 2);
					forme=ca ;
				}
				}
		else if (contenucmd[1].contains("rectangle") ) {
			position=contenucmd[1].split("rectangle");
		
		if(position.length != 0) {
			Rectangle ca ;
			
			ca=(Rectangle) c.creation(position[1], contenucmd[0], 3);
			
			forme=ca ;
			
		}

	}
	
		if(forme != null ) {
			
			 new CmdCreer(forme).execute();;
		}else {
			System.out.println("err lors de l creation ");
			return null ;
		}
	
		
		
		
	}else if(cmd.contains("move")) {
		// String cmd="move(caaa,(1,1)) ";
		String[] contenucmd ;
		contenucmd=cmd.split("move");
		/*contenucmd[0] =[]
				  [1] =(caaa,(1,1)) 
		*/
		forme =c.deplacer(contenucmd[1]);
		forme.afficher();
		if(forme!= null) {
			Commande c = new CmdDeplacer(forme);
			c.execute();
			return c ;
			
		}else {
			System.out.println("errr de deplacmnt ");
			return null ;
		}
		
	}
		
		
	

	
	
	
		return null;
	}
}
		
		
		
		
	
