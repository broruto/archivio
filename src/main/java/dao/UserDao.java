package dao;

import java.io.IOException;
import java.util.List;

import mapper.UserMapper;
import model.ModelUser;

public class UserDao extends BasicDao{

	private static UserDao dao;
	
	public static UserDao getInstance() {
		if(dao != null) {
			return dao;
		}else {
			return new UserDao();
		}
	}
	
	public List<ModelUser> getAll() throws IOException {
		UserMapper mapper=(UserMapper) sessione(UserMapper.class);
	    List<ModelUser> user=mapper.getAll();
	    return user;
	}
	
	public boolean insert(ModelUser user) throws IOException {
		UserMapper mapper=(UserMapper) sessione(UserMapper.class);
		int result = mapper.insert(user);
		if(result != 0) {
			return false;
		}
		return true;
	}
}
