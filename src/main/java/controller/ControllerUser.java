package controller;

import java.io.IOException;
import java.util.List;

import dao.UserDao;
import model.ModelUser;

public class ControllerUser {
	private static ControllerUser documentiDao;
	
	public static ControllerUser getInstance() {
		if(documentiDao != null) {
			return documentiDao;
		}else {
	        return new ControllerUser();
		}
	}
	
	public List<ModelUser> listaUser() throws IOException {
		UserDao dao = UserDao.getInstance();
		List<ModelUser> lista = dao.getAll();
		return lista;
	}
	
	public boolean registrazioneUser(ModelUser user) throws IOException {
		UserDao dao = UserDao.getInstance();
		return dao.insert(user);
	}
}
