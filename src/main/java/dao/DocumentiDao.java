package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.DocumentiMapper;
import model.ModelDocumenti;

public class DocumentiDao {

	private static DocumentiDao documentiDao;
	
	public static DocumentiDao getInstance() {
		if(documentiDao != null) {
			return documentiDao;
		}else {
	        return new DocumentiDao();
		}
	}
	
	private static Connection getConnection() {
		Connection conn= null;
		String url = "jdbc:mysql://localhost:3306/server";
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
	}
	
	final static String insert = "INSERT INTO `documenti` (`NOME_DOCUMENTO`, `DOCUMENTO`) VALUES (?, ?)";
	
	public DocumentiMapper sessione() throws IOException {
		Reader reader = Resources.getResourceAsReader("dao/SqlMapConfig.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    SqlSession session = sqlSessionFactory.openSession();
	    session.getConfiguration().addMapper(DocumentiMapper.class);
	    DocumentiMapper mapper = session.getMapper(DocumentiMapper.class);
	    return mapper;
	}
	
	public List<ModelDocumenti> getAll() throws IOException {
		DocumentiMapper mapper=sessione();
	    List<ModelDocumenti> documenti=mapper.getAll();
	    return documenti;
	}
	
	public ModelDocumenti getById(int id) throws IOException {
		DocumentiMapper mapper=sessione();
	    ModelDocumenti documenti=mapper.getById(id);
	    return documenti;
	}
	
	public int delById(int id) throws IOException {
		DocumentiMapper mapper=sessione();
	    int documenti=mapper.delById(id);
	    return documenti;
	}
	
	public int inserisci(ModelDocumenti documenti) throws Exception {
		int row = -1;
		try {
        PreparedStatement statement = getConnection().prepareStatement(insert);
        statement.setString(1, documenti.getNome());
        statement.setBytes(2, documenti.getDocumento());
        row = statement.executeUpdate();
        if (row > 0) {
            System.out.println("A contact was inserted with photo image.");
        }
        getConnection().close();
		}catch(Exception e) {
			System.out.println(e);
		}
        return row;
	}
}
