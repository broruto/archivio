package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/file")
public class Archivio {

	@GET
    public String file() {
        return "file";
    }
}
