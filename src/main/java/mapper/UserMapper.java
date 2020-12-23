package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.ModelUser;

public interface UserMapper {
	
	final String getAll = "SELECT * FROM `user`"; 
	final String insert = "INSERT INTO `user` (`USERNAME`, `PASSWORD` , `EMAIL`) VALUES (#{username}, #{password}, #{email});"; 
	
	@Select(getAll)
	   @Results(value = {
	      @Result(property = "id", column = "ID_USER"),
	      @Result(property = "username", column = "USERNAME"),
	      @Result(property = "email", column = "EMAIL")
	   })
	List<ModelUser> getAll();

	@Insert(insert)
	int insert(ModelUser user);
}
