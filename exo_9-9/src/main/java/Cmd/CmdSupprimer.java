package Cmd;

import uvsq21807569.exo_9_9.Carré;
import uvsq21807569.exo_9_9.Cercle;
import uvsq21807569.exo_9_9.DAO;
import uvsq21807569.exo_9_9.DaoFactory;
import uvsq21807569.exo_9_9.Forme;
import uvsq21807569.exo_9_9.Groupe;
import uvsq21807569.exo_9_9.Rectangle;
import uvsq21807569.exo_9_9.Triangle;

public class CmdSupprimer implements Commande {
	Forme f ;
	
	public CmdSupprimer(Forme f) {
		this.f=f ;
	}
	@Override
	public void execute() {
		if(f instanceof Cercle) {
			DAO<Cercle> c =new DaoFactory().getCercleDAO();
			c.delete((Cercle) f);
		}else if(f instanceof Carré) {
			DAO<Carré> car =new DaoFactory().getCarreDAO();
			car.delete((Carré) f);
		}else if(f instanceof Rectangle) {
			DAO<Rectangle> rect =new DaoFactory().getRectangleDAO();
			rect.delete((Rectangle) f);
		}else if (f instanceof Triangle ) {
			DAO<Triangle> rect =new DaoFactory().getTriangleDAO();
			rect.delete((Triangle) f);
		}else if (f instanceof Groupe ) {
			DAO<Groupe> grp =new DaoFactory().getGroupeDAO();
			grp.delete((Groupe) f);
		}else {
			System.out.println("suppression  impossible impossible ");
		}
		
		
			
			
		
	}

}
