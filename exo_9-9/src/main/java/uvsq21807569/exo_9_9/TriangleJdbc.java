package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleJdbc  implements DAO<Triangle>  {
	private static String url =DerbyBd.url;
	@Override
	public Triangle create(Triangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement pre = con.prepareStatement("INSERT INTO triangle (nom, point1_x, point1_y, point2_x, point2_y,point3_x, point3_y)" +
		"VALUES (?, ?, ?, ? , ?, ?, ?)");

			pre.setString(1, obj.getNom());
			pre.setInt(2, obj.getA().getX());
			pre.setInt(3, obj.getA().getY());
			pre.setInt(4, obj.getB().getX());
			pre.setInt(5, obj.getB().getY());
			pre.setInt(4, obj.getC().getX());
			pre.setInt(5, obj.getC().getY());
			System.out.println("Création du triangle   :" + obj.getNom());
			int res = pre.executeUpdate();
			assert res== 1; 
					}catch (SQLException e) {
						e.getMessage();
					}
		return obj;
		}
	

	@Override
	public Triangle read(String id) {
		Triangle a = null;
		try (Connection con = DriverManager.getConnection(url)) {
			System.out.println("Recherche " + id);
			PreparedStatement pre = con.prepareStatement(
					"SELECT * FROM triangle WHERE nom = ?");
			pre.setString(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				a = new Triangle (
						res.getString("nom"),
					new PositonDunPoint(res.getInt("point1_x"),res.getInt("point1_y")),
					new PositonDunPoint(res.getInt("point2_x"),res.getInt("point2_y")),
					new PositonDunPoint(res.getInt("point3_x"),res.getInt("point3_y")));
						res.close();

			}else {
			System.out.println("le triangle que vous chercher n'existe pas ");
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
		

	@Override
	public Triangle update(Triangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM triangle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("mise a jours impossible car le triangle que vous voulez metre a jours n'existe pas");
			}else {
			 PreparedStatement pre = con.prepareStatement(
					"UPDATE triangle SET point1_x = ?, "
									+ "point1_y = ?, "
									+ "point2_x = ?, "
									+ "point2_y = ?, "
									+ "point3_x = ?, "
									+ "point3_y = ?  WHERE nom = ?");
			 	pre.setInt(1, obj.getA().getX());
				pre.setInt(2, obj.getA().getY());
				pre.setInt(3, obj.getB().getX());
				pre.setInt(4, obj.getB().getY());
				pre.setInt(5, obj.getC().getX());
				pre.setInt(6, obj.getC().getY());
				pre.setString(7, obj.getNom());
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
	public void delete(Triangle obj) {
		try (Connection con = DriverManager.getConnection(url)) {
			PreparedStatement statmnt = con.prepareStatement(
					"SELECT * FROM triangle WHERE nom = ?  ");
			statmnt.setString(1, obj.getNom());
			ResultSet resu = statmnt.executeQuery();
			if(!resu.next()) { 
				System.out.println("suppression impossible car le triangle que vous voulez supprimer n'existe pas");
			}else {
			PreparedStatement stat = con.prepareStatement(
					"DELETE FROM triangle "
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
