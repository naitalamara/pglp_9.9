package uvsq21807569.exo_9_9;

public abstract class Forme {

	private String nom ;

	public Forme(String nom) {
		super();
		this.nom = nom;
	}
	
	public abstract void  afficher();
	public abstract void deplacer(String nom ,int dx , int dy );

	
	
	
	
}
