package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import mapper.DocumentiMapper;
import model.ModelDocumenti;

public class DocumentiDao extends BasicDao{

	private static DocumentiDao documentiDao;
	
	public static DocumentiDao getInstance() {
		if(documentiDao != null) {
			return documentiDao;
		}else {
	        return new DocumentiDao();
		}
	}
	
	final static String insert = "INSERT INTO `documenti` (`NOME_DOCUMENTO`, `DOCUMENTO`) VALUES (?, ?)";
	
	
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
	
	public int insert(ModelDocumenti documenti) throws IOException {
		DocumentiMapper mapper=sessione();
	    int result=mapper.insert(documenti);
	    return result;
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
