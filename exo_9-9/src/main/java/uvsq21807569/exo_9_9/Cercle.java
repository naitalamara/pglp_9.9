package uvsq21807569.exo_9_9;

public class Cercle extends Forme {

	private PositonDunPoint centre ;
	private final int rayon ;
	
	public Cercle(String nom,final PositonDunPoint p,final int r) {
		super(nom);
		this.rayon=r ;
		centre=p.dupliquer();
		}

	@Override
	public void afficher() {
		System.out.println( " Cercle de centre :" + centre + ", rayon :" + rayon + "");
		
	}

	@Override
	public void deplacer(String nom, int dx, int dy) {
		centre.setX(centre.getX()+dx);
		centre.setY(centre.getY()+dy);
		}

	public PositonDunPoint getCentre() {
		return centre;
	}

	public int getRayon() {
		return rayon;
	}

	

	
}
