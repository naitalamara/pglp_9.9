package uvsq21807569.exo_9_9;

import java.util.ArrayList;
import java.util.UUID;





public class Groupe extends Forme {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Forme> listeForme ;
	private UUID id;

	public Groupe(String nom) {
		super(nom);
		listeForme=new ArrayList<Forme>();
		id = UUID.randomUUID();
		}

	public Groupe(String nom,String id) {
		super(nom);
		listeForme=new ArrayList<Forme>();
		this.id = UUID.fromString(id);
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
	public String getId() {
		return id.toString();
	}
	
}
