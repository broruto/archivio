package dao;

import java.io.IOException;
import java.util.List;

import mapper.DndMapper;
import model.ModelTabMostri;

public class DndDao extends BasicDao{

	private static DndDao dndDao;
	
	public static DndDao getInstance() {
		if(dndDao != null) {
			return dndDao;
		}else {
	        return new DndDao();
		}
	}
	
	public List<ModelTabMostri> getAll() throws IOException {
		DndMapper mapper=(DndMapper) sessione(DndMapper.class);
	    List<ModelTabMostri> documenti=mapper.getAll();
	    return documenti;
	}
}
