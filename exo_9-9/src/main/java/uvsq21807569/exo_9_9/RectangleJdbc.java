package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleJdbc implements DAO<Rectangle> {
	private static String url =DerbyBd.url;
	@Override
	public Rectangle create(Rectangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement pre = con.prepareStatement("INSERT INTO rectangle (nom, point_x, point_y,longueur,largeur)" +
		"VALUES (?, ?, ?, ?)");

			pre.setString(1, obj.getNom());
			pre.setInt(2, obj.getP().getX());
			pre.setInt(3, obj.getP().getY());
			pre.setInt(4, obj.getLongueur());
			pre.setInt(5, obj.getLargeur());
			System.out.println("Création du rectangle   :" + obj.getNom());
			int res = pre.executeUpdate();
			assert res== 1; 
					}catch (SQLException e) {
						e.getMessage();
					}
		return obj;
		}

	@Override
	public Rectangle read(String id) {
		Rectangle a = null;
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + id);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM rectangle WHERE nom = ?");
			pre.setString(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				a = new Rectangle (
						res.getString("nom"),
					new PositonDunPoint(res.getInt("point_x"),
						res.getInt("point_y")),res.getInt("longueur"),res.getInt("largeur"));
						res.close();

			}else {
			System.out.println("le rectangle que vous chercher n'existe pas ");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
		
	

	@Override
	public Rectangle update(Rectangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM rectangle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("mise a jours impossible car le rectangle que vous voulez metre a jours n'existe pas");
			}else {
			 PreparedStatement pre = con.prepareStatement(
					"UPDATE rectangle SET point_x = ?, "
							+ "point_y = ?, "
							+ "longueur = ?,"
							+ "largeur  = ? WHERE nom = ?");
			pre.setInt(1, obj.getP().getX());
			pre.setInt(2, obj.getP().getY());
			pre.setInt(3, obj.getLongueur());
			pre.setInt(4, obj.getLargeur());
			pre.setString(5, obj.getNom());
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
	public void delete(Rectangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM rectangle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("suppression impossible car le rectangle que vous voulez supprimer n'existe pas");
			}else {
			PreparedStatement stat = con.prepareStatement(
					"DELETE FROM rectangle "
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
