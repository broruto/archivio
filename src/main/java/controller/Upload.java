package controller;

import java.io.IOException;

import dao.DocumentiDao;
import model.ModelDocumenti;

public class Upload {

	public static int uploadDocumenti(ModelDocumenti documenti) throws Exception {
		DocumentiDao dao = DocumentiDao.getInstance();
		try {
			if(documenti != null && documenti.getDocumento() != null) {
				int result = dao.inserisci(documenti);
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return -1;
	}
}
