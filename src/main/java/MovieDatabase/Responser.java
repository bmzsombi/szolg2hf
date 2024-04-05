package MovieDatabase;

import java.util.ArrayList;

public class Responser implements IResponser{
	ArrayList<Movie> movielist = new ArrayList<Movie>();
	
	
	@Override
	public ArrayList<Movie> getMovies() {
		String[] szineszek = new String[1];
		szineszek[0] = "pityu";
		movielist.add(new Movie("asd", 2001, "hghg", szineszek));
		return movielist;
	}
}
