package uvsq21807569.exo_9_9;



public class DaoFactory {

	public static DAO<Carré> getCarreDAO() {
		return new CarreJdbc( ) ;
	}
	
	
	
	public static DAO<Triangle> getTriangleDAO() {
		return new TriangleJdbc( ) ;
	}
	
	public static  DAO<Cercle> getCercleDAO() {
		return new CercleJdbc( ) ;
	}
	
	public static  DAO<Rectangle> getRectangleDAO() {
		return new RectangleJdbc( ) ;
	}
	public static  DAO<Groupe> getGroupeDAO() {
		return new GroupeJdbc( ) ;
	}
}
