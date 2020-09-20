package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.StatusCode;
import model.ModelUser;
import utils.StringUtils;


@Path("/user")
public class User {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserInfo() {
		Response res = Response.status(StatusCode.INTERNAL_ERROR).build();
		//al momento non disponibile
		res = Response.status(StatusCode.NOT_IMPLEMENTED).build();
		return res;
	}
	
	@POST
	@Path("/registrazione")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrazione(ModelUser user) {
		Response res = Response.status(StatusCode.INTERNAL_ERROR).build();
		if(user != null && StringUtils.isNotEmpty(user.getUsername()) && StringUtils.isNotEmpty(user.getEmail())) {
			res = Response.status(StatusCode.NOT_IMPLEMENTED).build();
		}else {
			res = Response.status(StatusCode.BAD_REQUEST).build();
		}
		return res;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(ModelUser user) {
		Response res = Response.status(StatusCode.INTERNAL_ERROR).build();
		//al momento non disponibile
		res = Response.status(StatusCode.NOT_IMPLEMENTED).build();
		return res;
	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout(ModelUser user) {
		Response res = Response.status(StatusCode.INTERNAL_ERROR).build();
		//al momento non disponibile
		res = Response.status(StatusCode.NOT_IMPLEMENTED).build();
		return res;
	}
}
