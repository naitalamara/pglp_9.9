package uvsq21807569.exo_9_9;

import java.util.ArrayList;
import java.util.List;



public class Groupe extends Forme {
	private List<Forme> listeForme ;

	public Groupe(String nom) {
		super(nom);
		listeForme=new ArrayList<Forme>();
		}

	
	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deplacer(String nom, int dx, int dy) {
		for(Forme a :listeForme) {
			a.deplacer(nom, dx, dy);
		}
		
	}
	
	
	
	
	
}
