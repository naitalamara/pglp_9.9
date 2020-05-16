package uvsq21807569.exo_9_9;

public class Rectangle extends Forme {
	
	private final int largeur , longueur ;
	private  PositonDunPoint  p ;
	
	public Rectangle(String nom,final int larg , final int longue ,PositonDunPoint  b) {
		super(nom);
		this.largeur=larg ;
		this.longueur=longue ;
		this.p=b.dupliquer();
		
	}

	@Override
	public void afficher() {
		System.out.println("Rectangle de largeur=" + largeur + ", et de longueur=" + longueur + ",et position du point  p=" + p + "");
		
	}

	@Override
	public void deplacer(String nom, int dx, int dy) {
		p.setX(p.getX()+dx);
		p.setY(p.getY()+dy);
		
	}

	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public PositonDunPoint getP() {
		return p;
	}

	

	
}
