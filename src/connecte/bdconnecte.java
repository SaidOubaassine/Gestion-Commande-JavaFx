package connecte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.client;
import model.commande;

public class  bdconnecte {
	public static Connection connecte() {
	try {
		String url="jdbc:mysql://localhost:3306/gestioncommande";
		String user= "root";
		String password= "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,user, password);
	    System.out.println("base de donneés connecte");
		return connection;
	}catch(ClassNotFoundException |SQLException e) {
		 System.out.println("base de donneés non connecte");
		Logger.getLogger(bdconnecte.class.getName()).log(Level.SEVERE,null, e);
	}
	
	return null;
	}
	
	
	public static int save(client cln) {
		int cl=0;
		try{
			String sql="INSERT INTO client (nom, email, numTel, genre) VALUES(?,?,?,?)";
			Connection con=connecte();
			PreparedStatement stat;
			stat=con.prepareStatement(sql);
		//	stat.setInt(1, cln.getIdClient());
			stat.setString(1, cln.getNom());
			stat.setString(2, cln.getEmail());
			stat.setInt(3, cln.getNumTel());
			stat.setString(4, cln.getGenre());
			cl=stat.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cl;
		
	}
		
}

