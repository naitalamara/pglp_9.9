package uvsq21807569.exo_9_9;

public class Carré extends Forme {

	private  PositonDunPoint  p ;
	private  final int longueur ;
	 
	public Carré(String nom,final  PositonDunPoint  a,final int longu) {
		super(nom);
		this.p=a.dupliquer();
		this.longueur=longu ;
	}

	@Override
	public void afficher() {
		System.out.println("Carré avec point p=" + p + ", longueur=" + longueur + "");
		
	}

	@Override
	public void deplacer(String nom, int dx, int dy) {
		p.setX(p.getX()+dx);
		p.setY(p.getY()+dy);
		
	}

	public PositonDunPoint getP() {
		return p;
	}

	public int getLongueur() {
		return longueur;
	}

	
	
}
