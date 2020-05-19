package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class GroupeJdbc implements DAO<Groupe>{
	private static String url =DerbyBd.url;
	@Override
	public Groupe create(final Groupe obj) {
		try (Connection con = DriverManager.getConnection(url)){
			PreparedStatement pre= con.prepareStatement(
					"INSERT INTO groupe (id)" +"VALUES (?)");
			pre.setString(1, obj.getId());
			int result = pre.executeUpdate();
			assert result == 1;

			List<Forme> list = obj.retournerListforme();
		for(Forme pers : list) {
						pre = con.prepareStatement(
							"INSERT INTO POSSEDE "	+ "VALUES (?, ?)");
					pre.setString(1, obj.getId());
					pre.setString(2, pers.getNom());
					pre.addBatch();
					}
					pre.executeBatch();
					System.out.println("groupe creer" );
				}
				catch (SQLException e) {
					e.printStackTrace();
					}
				return obj;
				
				}
	

	@Override
	public Groupe read(String id) {
		Groupe groupe = null;
		try(Connection con = DriverManager.getConnection(url))  {

			PreparedStatement prepares = con.prepareStatement(

					"SELECT * FROM possede WHERE id = ?");

			prepares.setString(1,id);

			ResultSet result = prepares.executeQuery();
			ArrayList<Cercle> grpCercles = new ArrayList<Cercle>();
			ArrayList<Rectangle> grpRectangles = new ArrayList<Rectangle>();
			ArrayList<Carré> grpCarres = new ArrayList<Carré>();
			ArrayList<Triangle> grpTriangles = new ArrayList<Triangle>();

			while (result.next()){

					try {
						groupe = new Groupe(id);
						PreparedStatement prepare = con.prepareStatement(
						"SELECT * FROM cercle WHERE nom = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet res = prepare.executeQuery();
						if(res.next()) {
							Cercle cercle = new Cercle (
									res.getString("nom"),

					new PositonDunPoint(res.getInt("centre_x"),res.getInt("centre_y")),
					res.getInt("rayon"));
					res.close();

							grpCercles.add(cercle);

							}

						}  catch (SQLException e) { e.getMessage(); }
					try (Connection conn = DriverManager.getConnection(url)){
						PreparedStatement prepare = conn.prepareStatement(
								"SELECT * FROM carre WHERE Nom = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resu = prepare.executeQuery();

						if(resu.next()) {

							Carré carre =   new Carré (
									resu.getString("nom"),
									new PositonDunPoint(resu.getInt("point_x"),resu.getInt("point_y")), 

										resu.getInt("longueur"));

							resu.close();

							grpCarres.add(carre);

							}

						}  catch (SQLException e) { e.getMessage(); }

					try (Connection conx = DriverManager.getConnection(url))  {
						PreparedStatement prepare = conx.prepareStatement(
						"SELECT * FROM triangle WHERE nom = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultat = prepare.executeQuery();
						if(resultat.next()) {

							Triangle triangle =	new Triangle (

									 	resultat.getString("nom"),
									 	new PositonDunPoint(resultat.getInt("point1_x"),
									 			resultat.getInt("point1_y")),
									 	new PositonDunPoint(resultat.getInt("point2_x"),
									 			resultat.getInt("point2_y")),
									 	new PositonDunPoint(resultat.getInt("point3_x"),
									 			resultat.getInt("point3_y")));
							resultat.close();
							grpTriangles.add(triangle);

							}

						}  catch (SQLException e) { e.getMessage(); }

					try  (Connection conx = DriverManager.getConnection(url)) {
						PreparedStatement prepare = conx.prepareStatement(
								"SELECT * FROM rectangle WHERE nom = ?  ");
						prepare.setString(1, result.getString("nom"));
						ResultSet resultt = prepare.executeQuery();
						if(resultt.next()) {
							Rectangle rectangle = new Rectangle(resultt.getString("nom"),
									new PositonDunPoint(resultt.getInt("point_x"),resultt.getInt("point_y")),
									resultt.getInt("longueur"),resultt.getInt("largeur"));
							resultt.close();
							grpRectangles.add(rectangle);
						}
					} catch (SQLException e) {
						e.getMessage();
	}
}

		         for (Cercle a: grpCercles) {
		        	 groupe.ajouterforme(a);
		         }
		         for (Carré b: grpCarres) {
		        	 groupe.ajouterforme(b);
		         }

		         for (Triangle c: grpTriangles) {
		        	 groupe.ajouterforme(c);
		        	 }

		         for (Rectangle d: grpRectangles) {
		        	 groupe.ajouterforme(d);
 }

		}catch (SQLException e) { e.printStackTrace(); }

		return groupe;
	}

	@Override
	public Groupe update(Groupe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Groupe obj) {
		try (Connection con = DriverManager.getConnection(url)) {

			PreparedStatement pre = con.prepareStatement(

					"DELETE  FROM Groupe "
					+ "WHERE id = ?");

			pre.setString(1, obj.getId());
			int result = pre.executeUpdate();
			assert result == 1;

			System.out.println("Suppression du groupe  ");
			}catch (SQLException e) {

			e.printStackTrace();

		}
		
	}

}
