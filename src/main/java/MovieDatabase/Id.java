package MovieDatabase;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="result")
@XmlAccessorType
@XmlType
public class Id {
	@XmlElement
	int id;
	
	public Id() {
		
	}
	
	public Id(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
