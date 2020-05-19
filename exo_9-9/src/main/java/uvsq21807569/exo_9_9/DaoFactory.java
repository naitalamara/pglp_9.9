package uvsq21807569.exo_9_9;



public class DaoFactory {

	public DAO<Carré> getCarreDAO() {
		return new CarreJdbc( ) ;
	}
	
	
	
	public DAO<Triangle> getTriangleDAO() {
		return new TriangleJdbc( ) ;
	}
	
	public DAO<Cercle> getCercleDAO() {
		return new CercleJdbc( ) ;
	}
	
	public DAO<Rectangle> getRectangleDAO() {
		return new RectangleJdbc( ) ;
	}
	public DAO<Groupe> getGroupeDAO() {
		return new GroupeJdbc( ) ;
	}
}
