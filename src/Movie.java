//movie class

//object with every data about the movie (id, name, year, director, rate, genre)
//set and get for each one
//toString for display

public class Movie {
	
	//Movie data:
	private int id;
	private String name;
	private int year;
	private String director;
	private float rating;
	private String genre;
	
	//------------------------------------
	
	public Movie(int id, String name, int year, String director, float rating, String genre) { // movie constructor
		this.id=id;
		this.name = name;
		this.year = year;
		this.director = director;
		this.rating = rating;
		this.genre = genre;
	}//---------------------------------------
	//------------------------------------
	public int getId() { // get Id
		return id;
	}
	//------------------------------------
	public void setId(int id) { // set Id
		this.id = id;
	}
	//------------------------------------
	public String getName() { // get Name
		return name;
	}
	//------------------------------------
	public void setName(String name) { //set Name
		this.name = name;
	}
	//------------------------------------
	public int getYear() {// get Year
		return year;
	}
	//------------------------------------
	public void setYear(int year) { //set year
		this.year = year;
	}
	//------------------------------------
	public String getDirector() { // get Director
		return director;
	}
	//------------------------------------
	public void setDirector(String director) { // set Director
		this.director = director;
	}
	//------------------------------------
	public float getRating() { // get Rating
		return rating;
	}
	//------------------------------------
	public void setRating(float rating) { // set Rating
		this.rating = rating;
	}
	//------------------------------------
	public String getGenre() { // get Genre
		return genre;
	}
	//------------------------------------
	public void setGenre(String genre) { // set Genre
		this.genre = genre;
	}
	//------------------------------------	
	public String toString() { // return all data in a single String
		return "id:" + id + ", " + name + " (" + year + ") directed by " + director + " a "+ rating + " rated " + genre + " movie. ";
	} 
	//------------------------------------
	
} // end of class Movie
