package uvsq21807569.exo_9_9;

public class InterpreteurCommandeSaisie {
	public Forme creation(final String position ,String nomForme , int nombre ) {
	Forme f= null ; ;
		if(nombre==0) {
			
			String[] msg =position.split("[, ( ) ]" );
			if (msg.length==6) {
				
				try {
					f= new Cercle(nomForme,new PositonDunPoint(Integer.parseInt(msg[2]),	Integer.parseInt(msg[3])),
							Integer.parseInt(msg[5]));
					
				}catch(Exception e ) {
				e.getMessage();
				System.out.println("eeeerrrroooooor");
									}
		}else {
			System.out.println("erreur lors de la saisie de la commande pour la creation d'un cercle ");
		}
			if (f != null ) return f; }
		return f;
	}
	
}
