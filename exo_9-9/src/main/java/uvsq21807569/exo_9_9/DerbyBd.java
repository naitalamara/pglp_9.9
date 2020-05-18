package uvsq21807569.exo_9_9;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Exception.TableExisteDeja;




public class DerbyBd {
	private static final String userName = "";
	private static final String password = "";

	public static String url = "jdbc:derby:bd;create=true";
	
	
	public DerbyBd() {

		Properties connectionProps = new Properties(); 
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}

	public void createTables() throws TableExisteDeja {

		try (Connection connect = DriverManager.getConnection(url)) {
			Statement statement = connect.createStatement();
		    DatabaseMetaData data = connect.getMetaData();
		    ResultSet result = data.getTables(null, null, "CERCLE", null);
		    if (result.next()){
		    	throw new TableExisteDeja ("table  deja existante ");
		    	}else {
		    		statement.addBatch(
		    		"CREATE TABLE cercle("

							+ "nom VARCHAR(100) not null,"
							+ "centre_x int ,"
							+ "centre_y int ,"
							+ "rayon int , "
							+ "PRIMARY KEY(nom)"
							+ ")");
		    	}
	
	
		    ResultSet re = data.getTables(null, null, "CARRE", null);
		    if (re.next()){
		    	throw new TableExisteDeja ("table  deja existante ");
		    	}else {
		    		statement.addBatch(
		    		"CREATE TABLE carre("

							+ "nom VARCHAR(100) not null,"
							+ "point_x int ,"
							+ "point_y int ,"
							+ "longueur int ,"
							+ "PRIMARY KEY(nom)"
							+ ")");
		    	}
		    
		    ResultSet resu = data.getTables(null, null, "RECTANGLE", null);
		    if (resu.next()){
		    	throw new TableExisteDeja ("table  deja existante ");
		    	}else {
		    		statement.addBatch(
		    		"CREATE TABLE rectangle("

							+ "nom VARCHAR(100) not null,"
							+ "point_x int ,"
							+ "point_y int ,"
							+ "longueur int ,"
							+ "largeur int ,"
							+ "PRIMARY KEY(nom)"
							+ ")");
		    	}
		    
		    
		    ResultSet resul = data.getTables(null, null, "TRIANGLE", null);
		    if (resul.next()){
		    	throw new TableExisteDeja ("table  deja existante ");
		    	}else {
		    		statement.addBatch(
		    		"CREATE TABLE triangle("

							+ "nom VARCHAR(100) not null,"
							+ "point1_x int ,"
							+ "point1_y int ,"
							+ "point2_x int ,"
							+ "point2_y int ,"
							+ "point3_x int ,"
							+ "point3_y int ,"
							+ "PRIMARY KEY(nom)"
							+ ")");
		    	}
		    
		   
		    ResultSet resultat = data.getTables(null, null, "GROUPE", null);
		    if (result.next()) {
		    	throw new TableExisteDeja("table  deja existante ");
		    } else {			

			statement.addBatch("CREATE TABLE Groupe ("
					+ "id VARCHAR(100) PRIMARY KEY"
					+ ")");}
		    
		    
		    ResultSet resus = data.getTables(null, null, "POSSEDE", null);
		    if (resus.next()) {
		    	throw new TableExisteDeja ("table deja existante ");
		    } else {

			statement.addBatch( 
								"CREATE TABLE Possede("
								+ "id VARCHAR(100),"
								+ "nom VARCHAR(100)"
								+ ")");
					  }

		statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

