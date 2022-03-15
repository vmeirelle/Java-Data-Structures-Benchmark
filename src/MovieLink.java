//MovieLink class

//crate a movie object and a link reference
//displayLink() to show the movie in this link

class MovieLink
   {
   public Movie movie;              // data item 
   public MovieLink next;              // next link in list
// -------------------------------------------------------------
   
   public MovieLink(int id, String name, int year, String director, float rating, String genre) // constructor
      {
      movie = new Movie(id, name, year, director, rating, genre);
      }
   
// -------------------------------------------------------------
   public void displayLink()      // display 
      {
      System.out.println(movie.toString());
      } //end displayLink
   
   }  // end class MovieLink