package service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import common.StatusCode;
import dao.DndDao;
import model.ModelTabMostri;

@Path("/dnd")
public class Dnd {

	@GET
	@Path("/listaMostri")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListaMostri() throws IOException {
		Response res =  Response.status(StatusCode.BAD_REQUEST).build();
		DndDao dao =  DndDao.getInstance();
		List<ModelTabMostri> listaMob= dao.getAll();
		res= Response.ok(listaMob).build();
		return res;
	}
}
