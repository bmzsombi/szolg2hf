package MovieDatabase;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;


public class Responser implements IResponser{
	@XmlElement
	static Movies movies = new Movies();
	
	@Override
	public Movies getMovies() {
		return movies;
	}
	
	@Override
	public Movie getMovie(int id) {
		return movies.getMovie(id);
	}
	
	@Override
	public Id addMovie(Movie movie) {
		return movies.addMovieResID(movie);
	}
	
	@Override
	public void updateMovie(int id, Movie movie) {
		movies.updateMovie(id, movie);
	}
	
	@Override
	public void deleteMovie(int id) {
		movies.removeMovieByID(id);
	}
	
	@Override
	public ArrayList<Id> getMoviesByYear(int year, String field) {
		return movies.getMoviesIdByYear(year, field);
	}
	
}
