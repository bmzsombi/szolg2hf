package MovieDatabase;

import java.util.ArrayList;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class Movies {
	@XmlElement(name="movie")
	ArrayList<Movie> movielist = new ArrayList<Movie>();
	int id = 0;
	@XmlElement(name="id")
	ArrayList<Integer> sortedmovies = new ArrayList<Integer>();
	
	public ArrayList<Movie> getMovies(){
		return this.movielist;
	}
	
	public void addMovie(Movie movie) {
		movie.setID(id);
		movielist.add(movie);
		id++;
	}
	
	public int addMovieResID(Movie movie) {
		movie.setID(id);
		movielist.add(movie);
		id++;
		return id-1;
	}
	
	public void addMovie(Movie movie, int id) {
		
		for (Movie mv: movielist) {
			if (mv.getID() == id) {
				mv = movie;
				mv.setID(id);
				return;
			}
		}
		
		Movie newmv = new Movie();
		newmv = movie;
		newmv.setID(id);
		movielist.add(newmv);
	}
	
	public Movie getMovie(int id) {
		boolean found = false;
		Movie mov = new Movie();
		for (Movie mv: movielist) {
			if (mv.getID() == id) {
				found = true;
				mov = mv;
			}
		}
		if (found) {
			return mov;
		}
		else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	
	public void removeMovieByID(int id) {
		for (Movie mv: movielist) {
			if (mv.getID() == id) {
				movielist.remove(mv);
			}
		}
	}
	
	public ArrayList<Integer> getMoviesIdByYear(int year) {
		for (Movie mv: movielist) {
			if (year == mv.year) {
				sortedmovies.add(mv.year);
			}
		}
		if (sortedmovies.isEmpty()) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		else {
			return sortedmovies;
		}
	}
}
