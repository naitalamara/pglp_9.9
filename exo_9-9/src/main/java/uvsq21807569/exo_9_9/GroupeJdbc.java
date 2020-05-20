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
					e.getMessage();
					e.printStackTrace();
					
					}
				return obj;
				
				}
	

	@Override
	public Groupe read(String id) {
		Groupe a = null;	
		
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + id);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM possede WHERE id = ?");
			pre.setString(1, id);
			ResultSet res = pre.executeQuery();
			a=new Groupe(id);
			CercleJdbc jdbc = new CercleJdbc();
			CarreJdbc jdbc2 = new CarreJdbc();
			RectangleJdbc jdbc3  = new RectangleJdbc();
			TriangleJdbc jdbc4 = new TriangleJdbc();
			if(res.next()) {
				 a.ajouterforme(jdbc.read(res.getString("nom")));
				 a.ajouterforme(jdbc2.read(res.getString("nom")));
				 a.ajouterforme(jdbc3.read(res.getString("nom")));
				 a.ajouterforme(jdbc4.read(res.getString("nom")));
				 


			}else {
			System.out.println("le grp que vous chercher n'existe pas ");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
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
