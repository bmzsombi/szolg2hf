package MovieDatabase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"title", "year", "director", "actor"})
@XmlSeeAlso(Movie.class)
public class Movie {
	@XmlElement(name ="title", nillable=true)
	String title;
	@XmlElement(name="year", nillable=true)
	int year;
	@XmlElement(name= "director", nillable=true)
	String director;
	@XmlElement(name="actor", nillable=true)
	String[] actor;
	
	private Id id = new Id();
	
	public Movie() {
		
	}
	
	public Movie(String title, int year, String director, String[] actor) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.actor = actor;
	}

	public void setID(int id) {
		this.id.setId(id);
	}
	
	public Id getID() {
		return this.id;
	}
	
	public void setMovie(Movie movie){
		this.title = movie.title;
		this.year = movie.year;
		this.director = movie.director;
		this.actor = movie.actor;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String[] getActors() {
		return actor;
	}
	
}
