package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ModelDocumenti;

public class DbTest {
	
	final static String sql = "INSERT INTO `documenti` (`NOME_DOCUMENTO`, `DOCUMENTO`,`TEST`) VALUES (?, ?,?)";
	 
	public static int upload(ModelDocumenti documenti) {
		int row = -1;
		String url = "jdbc:mysql://localhost:3306/server";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, documenti.getNome());
            statement.setBytes(2, documenti.getDocumento());
            statement.setBlob(3, documenti.getFile2());
            row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
	}
}
