package uvsq21807569.exo_9_9;

import Cmd.CmdDeplacer;
import Cmd.Commande;

public class InterpreteurCommandeSaisie {
	public Forme creation(final String position ,String nomForme , int nombre ) {
	Forme f= null ; ;
		if(nombre== 0) {
			//position =((1,6),2)
			String[] msg =position.split("[, ( ) ]" );
		/*	msg [0 ]=[]
				[1]=[]
				[2]=1
				[3]=6
				[4]=[]
				[5]=2	*/	
			if (msg.length==6) {
				
				try {
					f= new Cercle(nomForme,new PositonDunPoint(Integer.parseInt(msg[2]),Integer.parseInt(msg[3])),
							Integer.parseInt(msg[5]));
					
				}catch(Exception e ) {
				e.getMessage();
				System.out.println("eeeerrrroooooor");
									}
		}else {
			System.out.println("erreur lors de la saisie de la commande pour la creation d'un cercle ");
		}
			if (f != null ) return f; }
		
		
		
		else if( nombre == 1) {
			String[] msg =position.split("[, ( ) ]" );
			if (msg.length==12) {
				try {
					f= new Triangle(nomForme,new PositonDunPoint(Integer.parseInt(msg[2]),Integer.parseInt(msg[3])),
							new PositonDunPoint(Integer.parseInt(msg[6]),Integer.parseInt(msg[7])),
							new PositonDunPoint(Integer.parseInt(msg[10]),Integer.parseInt(msg[11])));
				}catch(Exception e ) {
					e.getMessage();
				}
			
		}else {
			System.out.println("erreur lors de la saisie de la commande pour la creation d'un triangle ");
		}
			if (f != null ) return f; }
		
	else if(nombre ==2) {
		String[] msg =position.split("[, ( ) ]" );
	     if (msg.length==6) {
	    	 try {
	    		f= new Carré(nomForme,new PositonDunPoint(Integer.parseInt(msg[2]),Integer.parseInt(msg[3])),
	    				 Integer.parseInt(msg[5])	);
	    	 }catch(Exception e ) {
					e.getMessage();
				}
	     }else {
				System.out.println("erreur lors de la saisie de la commande pour la creation d'un carré ");
			}
	     if (f != null ) return f; }
	 else if (nombre ==3) {
			String[] msg =position.split("[, ( ) ]" );
		     if (msg.length ==7) {
		    	 try {
		    		 f= new Rectangle(nomForme,new PositonDunPoint(Integer.parseInt(msg[2]),Integer.parseInt(msg[3])),
		    				 Integer.parseInt(msg[5]), Integer.parseInt(msg[6])	);
		    	 }catch(Exception e ) {
						e.getMessage();
					}
		     }else {
					System.out.println("erreur lors de la saisie de la commande pour la creation d'un rectangle ");
				}
		     if (f != null ) return f; }
		return f;
	
		
		
		
		     }
		
		public Forme deplacer(String cmd) {
			
			Forme forme=null ;
			String[] msg =cmd.split("[, ( ) ]" );  
			if(msg.length==5) {
				Forme a = null ;
				if(a== null) {
					DAO<Cercle> daoc =DaoFactory.getCercleDAO();
					forme = daoc.read(msg[1]);
					System.out.println(msg[1]);
					if (forme != null) {
						a = forme;
										}
					DAO<Triangle> daoca =DaoFactory.getTriangleDAO();
					forme=daoca.read(msg[1]);
					if (forme != null) {
						a = forme;
										}
					DAO<Carré> daocar =DaoFactory.getCarreDAO();
					forme=daocar.read(msg[1]);
					if (forme != null) {
						a = forme;
										}
					DAO<Rectangle> daor =DaoFactory.getRectangleDAO();
					forme=daor.read(msg[1]);
					if (forme != null) {
						a = forme;
			
										}
			}
				if(a!=null){
				
					a.deplacer(msg[1], Integer.parseInt(msg[3]),Integer.parseInt(msg[4]));
					
					System.out.println("a jours");
					return a;
			}
			
				
		}
			return null;
		
	
		
}
}

		
	
	





