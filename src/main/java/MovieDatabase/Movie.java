package MovieDatabase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(Movie.class)
@XmlType
public class Movie {
	@XmlElement
	String title;
	@XmlElement
	int year;
	@XmlElement
	String director;
	@XmlElement(name="actor")
	String[] actor;
	private int id;
	
	public Movie() {
		
	}
	
	public Movie(String title, int year, String director, String[] actors) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.actor = actors;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
}
