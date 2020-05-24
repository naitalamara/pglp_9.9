package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreJdbc implements DAO<Carré>{
	private static String url =DerbyBd.url;
	@Override
	public Carré create(Carré obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement pre = con.prepareStatement("INSERT INTO carre (nom, point_x, point_y,longueur)" +
		"VALUES (?, ?, ?, ?)");

			pre.setString(1, obj.getNom());
			pre.setInt(2, obj.getP().getX());
			pre.setInt(3, obj.getP().getY());
			pre.setInt(4, obj.getLongueur());
			System.out.println("Création du carre   :" + obj.getNom());
			int res = pre.executeUpdate();
			assert res== 1; 
					}catch (SQLException e) {
						e.getMessage();
					}
		return obj;
		}
	@Override
	public Carré read(String id) {
		Carré a = null;
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + id);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM carre WHERE nom = ?");
			pre.setString(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				a = new Carré (
						res.getString("nom"),
					new PositonDunPoint(res.getInt("point_x"),
						res.getInt("point_y")),res.getInt("longueur"));
						res.close();

			}else {
			System.out.println("le carre que vous chercher n'existe pas ");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	@Override
	public Carré update(Carré obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM carre WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("mise a jours impossible car le carre que vous voulez metre a jours n'existe pas");
			}else {
			 PreparedStatement pre = con.prepareStatement(
					"UPDATE carre SET point_x = ?, "
							+ "point_y = ?, "
							+ "longueur = ? WHERE nom = ?");
			pre.setInt(1, obj.getP().getX());
			pre.setInt(2, obj.getP().getY());
			pre.setInt(3, obj.getLongueur());
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
	public void delete(Carré obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM carre WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("suppression impossible car le carre que vous voulez supprimer n'existe pas");
			}else {
			PreparedStatement stat = con.prepareStatement(
					"DELETE FROM carre "
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
