package uvsq21807569.exo_9_9;

public class PositonDunPoint {
	int x, y ;

	public PositonDunPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PositonDunPoint [x=" + x + ", y=" + y + "]";
	}
	
	public boolean MemePosition(PositonDunPoint p) {
		if(this.x==p.x && this.y== p.getY()) return true ; 
		else 
			return false ;
	}

	public  PositonDunPoint dupliquer() {
		return new  PositonDunPoint(this.x,this.y);
	}
}
