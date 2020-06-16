package service;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DocumentiDao;
import model.ModelDocumenti;

@Path("/file/documenti")
public class Documenti {
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response selectById(@PathParam("id") int id) throws IOException {
		DocumentiDao dao = new DocumentiDao();
		ModelDocumenti result= dao.getById(id);
		return Response.ok(result.getDocumento()).build();
	}

	
	
}
