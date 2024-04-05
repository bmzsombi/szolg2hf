package MovieDatabase;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.ArrayList;

@Path("MovieDatabase")
public interface IResponser {
	@GET
	@Path("movies")
	public ArrayList<Movie> getMovies();
}
