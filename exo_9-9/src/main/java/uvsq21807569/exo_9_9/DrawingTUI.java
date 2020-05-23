package uvsq21807569.exo_9_9;

import Cmd.CmdCreer;
import Cmd.Commande;

public class DrawingTUI {
	InterpreteurCommandeSaisie c  = new InterpreteurCommandeSaisie(); ; 
	
	
	
	
	public Commande nextCommand(final String cmd) {
		String[] position = null ; ;
		Forme forme = null ;
		if(cmd.contains("=")){
			
		String[] contenucmd ;
		contenucmd=cmd.split("=");
		
		if(contenucmd.length !=2) {
			System.out.println("erreur de la saisie commande ");
		}
		
		
		if(contenucmd[1].contains("cercle") ) {
				position=contenucmd[1].split("cercle");
			
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
		
	}
		
		
	

	
	
	
		return null;
	}
}
		
		
		
		
	
