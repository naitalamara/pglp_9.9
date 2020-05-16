package uvsq21807569.exo_9_9;

public class Triangle extends Forme {

	 PositonDunPoint a ,b ,c ;
	 
	public Triangle(String nom,final  PositonDunPoint p1, final PositonDunPoint p2, final  PositonDunPoint p3) {
		super(nom);
		this.a=p1.dupliquer();
		this.b=p2.dupliquer();
		this.c=p3.dupliquer();
	}

	@Override
	public void afficher() {
		System.out.println("Triangle avec le  point a=" + a + ", le point  b=" + b + ",le point  c=" + c + "]");
		
	}

	@Override
	public void deplacer(String nom, int dx, int dy) {
		this.a.setX(this.a.getX()+dx);
		this.b.setX(this.b.getX()+dx);
		this.c.setX(this.c.getX()+dx);
		
		this.a.setY(this.a.getY()+dy);
		this.b.setY(this.a.getY()+dy);
		this.c.setY(this.a.getY()+dy);
	}

	public PositonDunPoint getA() {
		return a;
	}

	public PositonDunPoint getB() {
		return b;
	}

	public PositonDunPoint getC() {
		return c;
	}

	

	
}
