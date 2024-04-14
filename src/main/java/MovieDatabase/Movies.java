package MovieDatabase;

import java.util.ArrayList;
import java.util.Comparator;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class Movies {
	@XmlElement(name="movie", type = Movie.class)
	ArrayList<Movie> movielist = new ArrayList<>();
	int id = 0;
	ArrayList<Id> ids = new ArrayList<>();
	ArrayList<Movie> sortedmovies = new ArrayList<>();
	@XmlElement
	ArrayList<Id> sortedids = new ArrayList<>();
	
	public ArrayList<Movie> getMovies(){
		return this.movielist;
	}
	
	public boolean checkIfExist(int id) {
		for (Id i: ids) {
			if (i.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void addMovie(Movie movie) {
		boolean exist = this.checkIfExist(id);
		if (exist) {
			id = ids.getLast().getID()+1;
			movie.setID(id);
			ids.add(new Id(id));
			movielist.add(movie);
			id++;
		}
		else {
			movie.setID(id);
			ids.add(new Id(id));
			movielist.add(movie);
			id++;
		}
	}
	
	public void addMovie(Movie movie, int id) {
		movie.setID(id);
		ids.add(new Id(id));
		movielist.add(movie);
		id++;
	}
	
	public Id addMovieResID(Movie movie) {
		this.addMovie(movie);
		return movie.getID();
	}
	
	public void updateMovie(int id, Movie movie) {
		boolean exist = this.checkIfExist(id);
		if (exist) {
			for (Movie mv: movielist) {
				if (mv.getID().getID() == id) {
					mv.setMovie(movie);
				}
			}
		}
		else {
			addMovie(movie, id);
		}
	}
	
	public Movie getMovie(int id) {
		boolean found = false;
		Movie mov = new Movie();
		for (Movie mv: movielist) {
			if (mv.getID().getID() == id) {
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
		Movie deletable = new Movie();
		for (Movie mv: movielist) {
			if (mv.getID().getID() == id) {
				deletable = mv;
			}
		}
		movielist.remove(deletable);
	}
	
	public ArrayList<Id> getMoviesIdByYear(int year, String field) {
		sortedmovies = new ArrayList<>();
		sortedids = new ArrayList<>();
		for (Movie mv: movielist) {
			if (year == mv.year) {
				sortedmovies.add(mv);
			}
		}
		if (sortedmovies.isEmpty()) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		else {
			if (field.equals("Title")) {
				sortedmovies.sort(Comparator.comparing(Movie::getTitle));
				for (Movie mv: sortedmovies) {
					sortedids.add(mv.getID());
				}
				return sortedids;
			}
			else if (field.equals("Director")) {
				sortedmovies.sort(Comparator.comparing(Movie::getDirector));
				for (Movie mv: sortedmovies) {
					sortedids.add(mv.getID());
				}
				return sortedids;
			}
			else {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}
			
		}
	}
}
