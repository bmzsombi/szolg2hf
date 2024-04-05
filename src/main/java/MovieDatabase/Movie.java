package MovieDatabase;

public class Movie {
	String title;
	int year;
	String director;
	String[] actor;
	
	public Movie(String title, int year, String director, String[] actors) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.actor = actors;
	}
}
