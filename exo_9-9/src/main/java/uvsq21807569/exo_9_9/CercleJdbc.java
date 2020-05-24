package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CercleJdbc implements DAO<Cercle> {
	private static String url =DerbyBd.url;
	@Override
	public Cercle create(Cercle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement pre = con.prepareStatement("INSERT INTO cercle (nom, centre_x, centre_y,rayon)" +
		"VALUES (?, ?, ?, ?)");

			pre.setString(1, obj.getNom());
			pre.setInt(2, obj.getCentre().getX());
			pre.setInt(3, obj.getCentre().getY());
			pre.setInt(4, obj.getRayon());
			System.out.println("Création du cercle   :" + obj.getNom());
			int res = pre.executeUpdate();
			assert res== 1; 
					}catch (SQLException e) {
						e.getMessage();
					}
		return obj;
		}
	

	@Override
	public Cercle read(String id) {
		Cercle a = null;
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + id);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM cercle WHERE nom = ?");
			pre.setString(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				a = new Cercle (
						res.getString("nom"),
					new PositonDunPoint(res.getInt("centre_x"),
						res.getInt("centre_y")),res.getInt("rayon"));
						res.close();

			}else {
			System.out.println("le cercle que vous chercher n'existe pas ");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	@Override
	public Cercle update(Cercle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM cercle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("mise a jours impossible car cercle que vous voulez metre a jours n'existe pas");
			}else {
			 PreparedStatement pre = con.prepareStatement(
					"UPDATE cercle SET centre_x = ?, "
							+ "centre_y = ?, "
							+ "rayon = ? WHERE nom = ?");
			pre.setInt(1, obj.getCentre().getX());
			pre.setInt(2, obj.getCentre().getY());
			pre.setInt(3, obj.getRayon());
			pre.setString(4, obj.getNom());
			int res = pre.executeUpdate();
		
			assert res == 1;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("modifications reussites " );
		return obj;
	}
	

	@Override
	public void delete(Cercle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM cercle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("suppression impossible car le cercle que vous voulez supprimer n'existe pas");
			}else {
			PreparedStatement stat = con.prepareStatement(
					"DELETE FROM cercle "
						+ "WHERE nom = ?");
			stat.setString(1, obj.getNom());
			int res = stat.executeUpdate();
			assert res == 1;
			System.out.println("suprresion reussite ");
		}
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		}
}
