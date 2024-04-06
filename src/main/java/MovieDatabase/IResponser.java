package MovieDatabase;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("MovieDatabase")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface IResponser {
	@GET
	@Path("movies")
	public Movies getMovies();
	
	@GET
	@Path("movies/{id}")
	public Movie getMovie(@PathParam("id") int id);
	
	@POST
	@Path("movies")
	public int addMovie(@FormParam("title") String title, @FormParam("year") int year, @FormParam("director") String director, 
			@FormParam("actor") String[] actor);
}
