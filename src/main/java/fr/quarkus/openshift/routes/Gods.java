package fr.quarkus.openshift.routes;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.quarkus.openshift.database.DivinityGroup;
import fr.quarkus.openshift.database.God;

/*
 * God entity CRUD
 */
@Path("/god")
public class Gods {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        List<God> gods = God.listAll();
        if (gods == null || gods.isEmpty())
            return "There is no god in the database";

        StringBuilder sb = new StringBuilder();
        for (God god : gods) {
            sb.append("Name: " + god.name + "\n");
        }
        return "Here is all gods : \n" + sb.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@QueryParam("name") String name) {
        if (name == null || name.isEmpty())
            return "You must specify a name to get a god";

        God god = God.findByName(name);
        if (god == null)
            return "This god doesn't exist in the database";

        return "Here is " + name + " god: " + god.name + " from " + god.country + " living at " + god.place + " and "
                + god.idDivinityGroup + " divinity group";
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String add(God god) {
        if (god == null)
            return "You must specify a god to add it to the database";

        God.add(god.name, god.place, god.country, 1);

        return "I'm gonna add this god to the database: " + god.place
                + " from " + god.country + " living at " + god.place + " and " + god.idDivinityGroup
                + " divinity group";
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("name") String name) {
        God.delete(name);
        return "I'm gonna delete this god: " + name + " from the database";
    }
}