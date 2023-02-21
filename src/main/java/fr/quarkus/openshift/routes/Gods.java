package fr.quarkus.openshift.routes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@QueryParam("name") String name) {
        if (name == null || name.isEmpty())
            return "You must specify a name to get a god";

        return "Here is " + name + " god: ";
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String add(God god) {
        if (god == null)
            return "You must specify a god to add it to the database";

        return "I'm gonna add this god to the database: " + god.getName()
                + " from " + god.getCountry() + " living at " + god.getPlace() + " and " + god.getDivinityGroup()
                + " divinity group";
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("name") String name) {
        return "I'm gonna delete this god: " + name + " from the database";
    }
}