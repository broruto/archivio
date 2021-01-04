package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.ModelTabMostri;

public interface DndMapper {
	final String getAll = "SELECT * FROM `mostri_fast` ORDER BY NOME ASC"; 
	
	@Select(getAll)
	   @Results(value = {
	      @Result(property = "id", column = "ID_MOSTRI"),
	      @Result(property = "nome", column = "NOME"),
	      @Result(property = "scheda", column = "SCHEDA"),
	      @Result(property = "img", column = "IMG"),
	      @Result(property = "token", column = "TOKEN")
	   })
	List<ModelTabMostri> getAll();
}
