//movieArray class

//create a array of movie object

//able to read CSV data and add into it, ReadCSV()
//insert() to add manually put a movie object, need to know the order and prop of tree 
//displayTree() to display entire array (uses displayStep() as secondary method)
//sortTree() to erase and create a new tree with selected sort configuration
//delete() to delete a item by id (uses getSucessor() as secondary method )
//find() for search in tree
//sizeArr to get tempArr array size

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

class MovieTreeList
   {
   private MovieTree root;             // first node of tree
   private Movie[] tempArr; 		//array to save data, shuffle then throw into tree 
// -------------------------------------------------------------
   public MovieTreeList()                  // constructor
      { root = null; }            // no nodes in tree yet
//--------------------------------------------------------------
   public int ReadCSV (String filename) { 	// load CSV File

		try
		{	this.root = null; //clean this MovieList so we can create a new one
			int counter = 0;
			
			Path filePath = Paths.get(filename); //path name
			
			BufferedReader fileReader=Files.newBufferedReader(filePath); //start reader
			String rows = fileReader.readLine(); // rows reading
			int rowsCounter =0; //rows counter
				
			while(rows!=null) {		//row's not empty
				rowsCounter++; // count row
				rows=fileReader.readLine(); //and read next
			}
	
			fileReader=Files.newBufferedReader(filePath); // reset reader
			
			int beginAt = ((tempArr==null) ? 0 : tempArr.length);//save old n elems
			Movie[] newMovieList = new Movie[rowsCounter + beginAt ]; //create a new array with size of old elems + new elems
			 
			
			for(counter=0; counter<beginAt;counter++) {
				newMovieList[counter] = tempArr[counter]; //add from old array to new array
			}
			
			for(counter=beginAt; counter<(beginAt+rowsCounter);counter++) { //now get also the new reading to the new array
				
				rows=fileReader.readLine();  // get line
				String[] info = rows.split(","); // split line
				newMovieList[counter] = new Movie((counter + 1), info[0], Integer.parseInt(info[1]), info[2], Float.parseFloat(info[3]), info[4]); //add line info to new array
				}
			
			for (int i = 0; i < newMovieList.length; i++) {
				Random random = new Random();
				int rand = random.nextInt(0, newMovieList.length); //get a random position
				Movie temp = newMovieList[i]; //swap term
				newMovieList[i] = newMovieList[rand]; // with the random position
				newMovieList[rand] = temp; // for every term
			}
			
			this.tempArr = newMovieList; // define old array as new array
			
			for(int i = 0; i <tempArr.length; i++) {
				this.insert(tempArr[i], 1, 1); //put every movie into tree
			}
			
			return (tempArr.length - beginAt); // return only the quantity of new info add
			
		}catch (IOException e) {
				e.printStackTrace();
				return (0);
			}

		}  
//--------------------------------------------------------------
   public void insert(Movie movie, int prop, int order) //insert in order
      {
      
	   MovieTree newNode = new MovieTree(movie.getId(), movie.getName(), 
			   movie.getYear(), movie.getDirector(), movie.getRating(), movie.getGenre());    // make new node

      if(root==null)                // no node in root
         root = newNode; //first object
      
      else                          // root occupied
         {
    	  MovieTree current = root;       // start at root
    	  MovieTree parent;
         while(true)                // (exits internally)
            {
            parent = current;
            switch(prop) { //the tree must have a defined order and propiety
            case (1):
            	if(order==1) {
	            if(movie.getId() < current.movie.getId())  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(movie.getId() > current.movie.getId())  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            case (2):
            	if(order==1) {
	            if( 0 > movie.getName().compareTo(current.movie.getName()))  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(0 < movie.getName().compareTo(current.movie.getName()))  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            case (3):
            	if(order==1) {
	            if(movie.getYear() < current.movie.getYear())  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(movie.getYear() > current.movie.getYear())  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            case (4):
            	if(order==1) {
	            if(0 > movie.getDirector().compareTo(current.movie.getDirector()))  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(0 < movie.getDirector().compareTo(current.movie.getDirector()))  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            case (5):
            	if(order==1) {
	            if(movie.getRating() < current.movie.getRating())  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(movie.getRating() > current.movie.getRating())  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            case (6):
            	if(order==1) {
	            if(0 > movie.getGenre().compareTo(current.movie.getGenre()))  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
            	}//end if
            	else {
    	            if(0 < movie.getGenre().compareTo(current.movie.getGenre()))  // go left?
 	               {
 	               current = current.leftChild;
 	               if(current == null)  // if end of the line,
 	                  {                 // insert on left
 	                  parent.leftChild = newNode;
 	                  return;
 	                  }
 	               }  // end if go left
 	            else                    // or go right?
 	               {
 	               current = current.rightChild;
 	               if(current == null)  // if end of the line
 	                  {                 // insert on right
 	                  parent.rightChild = newNode;
 	                  return;
 	                  }
 	               } //end 
            	}
    	            break;
            }//end switch
            }  // end while
         }  // end else not root
      }  // end insert()
//--------------------------------------------------------------
   public void displayTree() { //display every data
	   displayStep(root); // call recursive function
	  } 
//-------------------------------------------------------
   private void displayStep(MovieTree Tree) { //for displayTree method
	   if (Tree == null)
	     return; //if null do nothing
	   displayStep(Tree.leftChild); //try to go left
	   System.out.printf("\n%s ", Tree.movie.toString()); //print
	   displayStep(Tree.rightChild); //try to go right
  }
//---------------------------------------------------------------
  public void sortTree(int prop, int order) { //sort the three by creating a new sorted one
	  this.root = null; // clean tree
	  
		for(int i = 0; i <tempArr.length; i++) { //insert 1 by 1 in order
			this.insert(tempArr[i], prop, order);
		}
	  
  }
//-------------------------------------------------------------
  public boolean delete(int key) // delete with given key
     {                          
      //need to remove it from array before removing from tree
	  boolean finded = false;
	  int i;
	  for (i = 0; i<tempArr.length;i++) { //first verify if it exists
		  if(tempArr[i].getId()==key) {
			  finded = true;
			  break;
		  } //save position on i
	  }
	  if(finded==true) {
		  Movie[] newTempArr = new Movie[tempArr.length-1];
		  for(int j = 0; j<i; j++) {
			  newTempArr[j] = tempArr[j]; //new temporary array with every item <i
		  }
		  for(int j=i; j<newTempArr.length; j++) {
			  newTempArr[j] = tempArr[j+1]; //and every >i
		  }
		  this.tempArr = newTempArr;
	  }
	 
	  this.sortTree(1, 1);//need to sort it by iD so can delete by iD
	  
	 MovieTree current = root;
     MovieTree parent = root;
     boolean isLeftChild = true;

     while(current.movie.getId() != key)        // search for node
        {
        parent = current;
        if(key < current.movie.getId())         // go left?
           {
           isLeftChild = true;
           current = current.leftChild;
           }
        else                            // or go right?
           {
           isLeftChild = false;
           current = current.rightChild;
           }
        if(current == null)             // end of the line,
           return false;                // didn't find it
        }  // end while
     // found node to delete

     // if no children, simply delete it
     if(current.leftChild==null &&
                                  current.rightChild==null)
        {
        if(current == root)             // if root,
           root = null;                 // tree is empty
        else if(isLeftChild)
           parent.leftChild = null;     // disconnect
        else                            // from parent
           parent.rightChild = null;
        }

     // if no right child, replace with left subtree
     else if(current.rightChild==null)
        if(current == root)
           root = current.leftChild;
        else if(isLeftChild)
           parent.leftChild = current.leftChild;
        else
           parent.rightChild = current.leftChild;

     // if no left child, replace with right subtree
     else if(current.leftChild==null)
        if(current == root)
           root = current.rightChild;
        else if(isLeftChild)
           parent.leftChild = current.rightChild;
        else
           parent.rightChild = current.rightChild;

     else  // two children, so replace with inorder successor
        {
        // get successor of node to delete (current)
    	 MovieTree successor = getSuccessor(current);

        // connect parent of current to successor instead
        if(current == root)
           root = successor;
        else if(isLeftChild)
           parent.leftChild = successor;
        else
           parent.rightChild = successor;

        // connect successor to current's left child
        successor.leftChild = current.leftChild;
        }  // end else two children
     // (successor cannot have a left child)
     return true;                                // success
     }  // end delete()
//-------------------------------------------------------
  private MovieTree getSuccessor(MovieTree delNode) //for delete method
     {
	  MovieTree successorParent = delNode;
	  MovieTree successor = delNode;
	  MovieTree current = delNode.rightChild;   // go to right child
     while(current != null)               // until no more
        {                                 // left children,
        successorParent = successor;
        successor = current;
        current = current.leftChild;      // go to left child
        }
                                          // if successor not
     if(successor != delNode.rightChild)  // right child,
        {                                 // make connections
        successorParent.leftChild = successor.rightChild;
        successor.rightChild = delNode.rightChild;
        }
     return successor;
     }
//------------------------------------------------------------------
  public boolean find(String key, int prop, boolean print) { //find item method
	  
	  MovieTree current = root; //start from root             
	  switch(prop) { //what to find
	  	case(1):
	  		this.sortTree(prop, 1); //need to sort before search
	  		current = root; // start at root
	  		while(current.movie.getId() != Integer.parseInt(key))        // while no match,
				 {	
					if(Integer.parseInt(key) < current.movie.getId())         // go left?
						current = current.leftChild;
					else                            // or go right?
						current = current.rightChild;
					if(current == null)             // if no child,
						return false;                 // didn't find it
				 }
			break;
	  	case(2):	  	
	  	this.sortTree(prop, 1);
  		current = root;
  		while( 0 != current.movie.getName().compareTo(key))        // while no match,
	     {
		     if(0 > key.compareTo(current.movie.getName())) {        // go left?
		    	 current = current.leftChild;
		     }else {                            // or go right?
		    	 current = current.rightChild;
		    	 
		     }if(current == null)             // if no child,
		    	 return false;                 // didn't find it
	     }
			  	break; 
	  	case(3):
			  this.sortTree(prop, 1);
		  	  current = root;
			  while(current.movie.getYear() != Integer.parseInt(key))        // while no match,
			     {
				     if(Integer.parseInt(key)< current.movie.getYear()) {         // go left?
				        current = current.leftChild;
				     }else {                            // or go right?
				        current = current.rightChild;
				     }if(current == null)             // if no child,
				        return false;                 // didn't find it
			     }
		  		break;
	  	case(4):		  		
	  		this.sortTree(prop, 1);
	  		current = root;
	  		while( 0 != current.movie.getDirector().compareTo(key))        // while no match,
		     {
			     if(0 > key.compareTo(current.movie.getDirector())) {        // go left?
			    	 current = current.leftChild;
			     }else {                            // or go right?
			    	 current = current.rightChild;
			    	 
			     }if(current == null)             // if no child,
			    	 return false;                 // didn't find it
		     }
	  		  		break;
	  	case(5):
	  			this.sortTree(prop, 1);
				current = root;
				while(current.movie.getRating() != Float.parseFloat(key))        // while no match,
			     {
				     if(Float.parseFloat(key)< current.movie.getRating()) {         // go left?
				        current = current.leftChild;
				     }else {                            // or go right?
				        current = current.rightChild;
				     }if(current == null)             // if no child,
				        return false;                 // didn't find it
			     }
				break;
	  	case(6):	
		  		this.sortTree(prop, 1);
		  		current = root;
		  		while( 0 != current.movie.getGenre().compareTo(key))        // while no match,
			     {
				     if(0 > key.compareTo(current.movie.getGenre())) {        // go left?
				    	 current = current.leftChild;
				     }else {                            // or go right?
				    	 current = current.rightChild;
				    	 
				     }if(current == null)             // if no child,
				    	 return false;                 // didn't find it
			     }
					  break;
	  	} // end switch
	  if(print == true)
		  System.out.println(current.movie.toString());
	  return true;                    // found it
  	}  // end find()
//------------------------------------------------------------
  public int sizeArr() { //get size of tempArr
	  return tempArr.length;
  }
//------------------------------------------------------------
}  // end class MovieTreeList