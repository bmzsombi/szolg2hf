package MovieDatabase;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;


public class Responser implements IResponser{
	@XmlElement
	static Movies movies = new Movies();
	
	
	@Override
	public Movies getMovies() {
		String[] szineszek = new String[2];
		szineszek[0] = "pityu";
		szineszek[1] = "beci";
		movies.addMovie(new Movie("asd", 2001, "hghg", szineszek));
		String[] asd = new String[1];
		asd[0] = "lali";
		movies.addMovie(new Movie("ert", 2056, "ASDASD", asd));
		return movies;
	}
	
	@Override
	public Movie getMovie(int id) {
		String[] szineszek = new String[2];
		szineszek[0] = "pityu";
		szineszek[1] = "beci";
		movies.addMovie(new Movie("asd", 2001, "hghg", szineszek));
		String[] asd = new String[1];
		asd[0] = "lali";
		movies.addMovie(new Movie("ert", 2056, "ASDASD", asd));
		return movies.getMovie(id);
	}
	
	@Override
	public int addMovie(Movie movie) {
		return movies.addMovieResID(movie);
	}
	
	@Override
	public void deleteMovie(int id) {
		movies.removeMovieByID(id);
	}
	
	@Override
	public ArrayList<Integer> getMoviesByYear() {
		return movies.getMoviesIdByYear(2001);
	}
	
}
