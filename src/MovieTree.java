//MovieLink class

//crate a movie object and a left/right child reference
//displayTree() to show the movie in this link



class MovieTree
   {
   public Movie movie;           // data item
   public MovieTree leftChild;         // this node's left child
   public MovieTree rightChild;        // this node's right child

   public MovieTree(int id, String name, int year, String director, float rating, String genre) // constructor
   {
   movie = new Movie(id, name, year, director, rating, genre);
   }
   
   public void displayTree()      // display 
      {
      System.out.print(movie.toString()); //print movie to string
      }
   } 

// end class MovieTree

