package Cmd;

import uvsq21807569.exo_9_9.Carré;
import uvsq21807569.exo_9_9.Cercle;
import uvsq21807569.exo_9_9.DAO;
import uvsq21807569.exo_9_9.DaoFactory;
import uvsq21807569.exo_9_9.Forme;
import uvsq21807569.exo_9_9.Groupe;
import uvsq21807569.exo_9_9.Rectangle;
import uvsq21807569.exo_9_9.Triangle;

public class CmdCreer implements Commande{
	Forme f ;
	
	public CmdCreer(Forme f) {
		this.f=f ;
	}
	
	
	
	@Override
	public void execute() {
	Forme forme=null ;
		if(f instanceof Cercle) {
			DAO<Cercle> c =new DaoFactory().getCercleDAO();
			forme=c.create((Cercle) f);
		}else if(f instanceof Carré) {
			DAO<Carré> car =new DaoFactory().getCarreDAO();
			forme=car.create((Carré) f);
		}else if(f instanceof Rectangle) {
			DAO<Rectangle> rect =new DaoFactory().getRectangleDAO();
			forme=rect.create((Rectangle) f);
		}else if (f instanceof Triangle ) {
			DAO<Triangle> rect =new DaoFactory().getTriangleDAO();
			forme=rect.create((Triangle) f);
		}else if (f instanceof Groupe ) {
			DAO<Groupe> grp =new DaoFactory().getGroupeDAO();
			forme=grp.create((Groupe) f);
		}else {
			System.out.println("creation impossible ");
		}
		
	}

}
