package mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import model.ModelDocumenti;

public interface DocumentiMapper {
	final String getAll = "SELECT * FROM documenti"; 
	final String getById = "SELECT * FROM documenti WHERE ID_DOCUMENTO = #{id}"; 
	final String insert = "INSERT INTO documenti (NOME_DOCUMENTO, DOCUMENTO) VALUES (#{nome}, #{documento})";
	   
	@Select(getAll)
	   @Results(value = {
	      @Result(property = "id", column = "ID_DOCUMENTO"),
	      @Result(property = "nome", column = "NOME_DOCUMENTO")
	   })
	List<ModelDocumenti> getAll();
	
	@Insert(insert)
	   @Options(useGeneratedKeys = true, keyProperty = "id")
	   void insert(ModelDocumenti documenti);
	
	@Select(getById)
	   @Results(value = {
	      @Result(property = "id", column = "ID_DOCUMENTO"),
	      @Result(property = "nome", column = "NOME_DOCUMENTO"),
	      @Result(property = "documento", column = "DOCUMENTO")
	   })
	@Options(keyProperty = "id")
	ModelDocumenti getById(int id);
}
