package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import common.StatusCode;
import dao.DocumentiDao;
import model.ModelDocumenti;

@Path("/file/documenti")
public class Documenti {
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response selectById(@PathParam("id") int id) throws IOException {
		ResponseBuilder res = Response.status(StatusCode.BAD_REQUEST);
		ModelDocumenti result= DocumentiDao.getInstance().getById(id);
		res =  Response.ok(result.getDocumento());
		res.header("Content-Disposition", "attachment; filename=\"" + result.getNome() + "\"");
		return res.build();
	}
	@DELETE
	@Path("/id/{id}")
	public Response deleteById(@PathParam("id") int id) throws IOException {
		int result= DocumentiDao.getInstance().delById(id);
		return Response.ok(result).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAll() throws IOException {
		List<ModelDocumenti> result= DocumentiDao.getInstance().getAll();
		return Response.ok(result).build();
	}
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(@MultipartForm MultipartFormDataInput id) throws Exception {
		
		List<InputPart> test = id.getParts();
		for(InputPart part : test) {
			InputStream inputStream = part.getBody(InputStream.class,null);
			MultivaluedMap<String, String> header = part.getHeaders();
			String fileName = getFileName(header);
			byte [] bytes = IOUtils.toByteArray(inputStream);
			ModelDocumenti documento= new ModelDocumenti();
			documento.setDocumento(bytes);
			documento.setNome(fileName);
			int response = DocumentiDao.getInstance().insert(documento);
			return Response.ok(response).build();
		}
		return Response.ok().build();
	}

	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}	
}
