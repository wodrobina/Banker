package eu.wodrobina;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ep")
public class Entrypoint {

  @GET
  @Path("/{param}")
  @Produces(MediaType.APPLICATION_JSON)
  public Greeting hello(@PathParam("param") String name) {
    return new Greeting(name);
  }
}
