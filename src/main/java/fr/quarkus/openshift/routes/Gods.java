package fr.quarkus.openshift.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.quarkus.openshift.models.God;

/*
 * God entity CRUD
 */
@Path("/god")
public class Gods {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return "Here is all gods";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("name") String name) {
        return "Here is " + name + " god: ";
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String add(God god) {
        return "I'm gonna add this god to the database: " + god.getName()
                + " from " + god.getCountry() + " living at " + god.getPlace() + " and " + god.getDivinityGroup()
                + " divinity group";
    }
}