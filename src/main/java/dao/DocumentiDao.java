package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.DocumentiMapper;
import model.ModelDocumenti;

public class DocumentiDao {

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
	
	public void inserisci(ModelDocumenti documenti) throws IOException {
		DocumentiMapper mapper=sessione();
	    mapper.insert(documenti);
	}
}
