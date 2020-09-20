package mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import model.ModelDocumenti;

public interface DocumentiMapper {
	final String getAll = "SELECT ID_DOCUMENTO,NOME_DOCUMENTO FROM documenti"; 
	final String getById = "SELECT * FROM documenti WHERE ID_DOCUMENTO = #{id}"; 
	final String delById = "DELETE FROM `documenti` WHERE `ID_DOCUMENTO` = #{id}"; 
	final String insert = "INSERT INTO `documenti` (`NOME_DOCUMENTO`, `DOCUMENTO`) VALUES (?, ?)";

	   
	@Select(getAll)
	   @Results(value = {
	      @Result(property = "id", column = "ID_DOCUMENTO"),
	      @Result(property = "nome", column = "NOME_DOCUMENTO")
	   })
	List<ModelDocumenti> getAll();
	
	@Select(getById)
	   @Results(value = {
	      @Result(property = "id", column = "ID_DOCUMENTO"),
	      @Result(property = "nome", column = "NOME_DOCUMENTO"),
	      @Result(property = "documento", column = "DOCUMENTO")
	   })
	@Options(keyProperty = "id")
	ModelDocumenti getById(int id);
	
	@Delete(delById)
	@Options(keyProperty = "id")
	int delById(int id);
	
	@Insert(insert)
		@Results(value = {
		      @Result(property = "nome", column = "NOME_DOCUMENTO"),
		      @Result(property = "documento", column = "DOCUMENTO")
		   })
	int insert(ModelDocumenti documenti);
}
