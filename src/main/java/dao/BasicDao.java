package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BasicDao {

	private static BasicDao basicDao;
	
	public static BasicDao getInstance() {
		if(basicDao != null) {
			return basicDao;
		}else {
	        return new BasicDao();
		}
	}
	
	protected static Connection getConnection() {
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
	
	protected static <T> Object sessione(Class<T> mapperClass) throws IOException {
		Reader reader = Resources.getResourceAsReader("dao/config/SqlMapConfig.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    SqlSession session = sqlSessionFactory.openSession();
	    session.getConfiguration().addMapper(mapperClass);
	    Object mapper = session.getMapper(mapperClass);
	    return mapper;
	}
}
