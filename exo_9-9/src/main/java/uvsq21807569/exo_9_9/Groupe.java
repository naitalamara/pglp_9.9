package uvsq21807569.exo_9_9;

import java.util.ArrayList;





public class Groupe extends Forme {
	private ArrayList<Forme> listeForme ;

	public Groupe(String nom) {
		super(nom);
		listeForme=new ArrayList<Forme>();
		}

	
	@Override
	public void afficher() {
		for(Forme a :listeForme) {
			a.afficher();
		}
		}
		
	

	@Override
	public void deplacer(String nom, int dx, int dy) {
		for(Forme a :listeForme) {
			a.deplacer(nom, dx, dy);
		}
		
	}
	
	
	public void ajouterforme(Forme a ) {
		listeForme.add(a);
	}
	
	
	public void supprimerforme(Forme a) throws IllegalArgumentException {
		if(listeForme.contains(a)) {
			listeForme.remove(a);
		}else {throw new IllegalArgumentException("la Forme que vous essayer de supprimer n'existe pas au sein du Groupe");
			
		}
	}
	
	public ArrayList<Forme> retournerListforme(){
		return this.listeForme;
	}
	
}
