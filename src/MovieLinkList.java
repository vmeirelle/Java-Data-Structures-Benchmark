//MovieLinkList

//create a list of links


//able to read CSV data and add into it, ReadCSV()
//getElems to get number of elements in list
//insertLast() to add manually in last position
//findById() and findByName() for search in list 
//displayList() to display entire list
//displaySlice() to display a specific section
//insertionSort() to sort it by specified prop and order (asc or desc)
//findKey() to find a key into specified prop
//removeById() to remove the item with specified Id

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class MovieLinkList
   {
   private MovieLink first;		// reference to first link on list

// -----------------------------------
   public MovieLinkList()		// constructor
      {
      first = null;               // no links on list yet
      }
// -----------------------------------
   public void insertLast(int id, String name, int year, String director, float rating, String genre) //insert a item in last position
   {
	   
       MovieLink newLink= new MovieLink(id, name, year, director, rating, genre); //create movie link with data
       
       if(first == null)
    	   first = newLink; //if first set it
       else
       {
    	   MovieLink temp = first;
    	   while(temp.next != null)
    	   {
    		   temp = temp.next; //get to current
    	   }
    	   temp.next = newLink; //set at current
       }

   }
// -----------------------------------
   public void insertionSort(int order, int prop) {		// sort the array, order (1 -ascending, 2-descending), prop(1-id, 2-name, 3-year, 4-director, 5-rate, 6-genre)
	   

       MovieLink current = first;
       MovieLink sorted = null;
    
       while (current != null) {
    	   
    	   MovieLink next = current.next;
    	   MovieLink newnode = current;
    	   
    	   switch(prop) {
    	   case 1:    		   
    		    if(order==1) {
  		        if (sorted == null || sorted.movie.getId() >= newnode.movie.getId())  
  		        { 
  		            newnode.next = sorted; 
  		            sorted = newnode; 
  		        } 
  		        else 
  		        { 
  		            current = sorted; 
  		            /* Locate the node before the point of insertion */
  		            while (current.next != null && current.next.movie.getId() < newnode.movie.getId())  
  		            { 
  		                current = current.next; 
  		            } 
  		            newnode.next = current.next; 
  		            current.next = newnode; 
  		         }}
      		   else {
     		        if (sorted == null || sorted.movie.getId() <= newnode.movie.getId())  
     		        { 
     		            newnode.next = sorted; 
     		            sorted = newnode; 
     		        } 
     		        else 
     		        { 
     		            current = sorted; 
     		            /* Locate the node before the point of insertion */
     		            while (current.next != null && current.next.movie.getId() > newnode.movie.getId())  
     		            { 
     		                current = current.next; 
     		            } 
     		            newnode.next = current.next; 
     		            current.next = newnode; 
     		         }
      		   	}
	        	break;
	        case 2:    		   
    		    if(order==1) {
      		        if (sorted == null || 0 < sorted.movie.getName().compareTo(newnode.movie.getName()))  
      		        { 
      		            newnode.next = sorted; 
      		            sorted = newnode; 
      		        } 
      		        else 
      		        { 
      		            current = sorted; 
      		            /* Locate the node before the point of insertion */
      		            while (current.next != null &&  0 > current.next.movie.getName().compareTo(newnode.movie.getName()))  
      		            { 
      		                current = current.next; 
      		            } 
      		            newnode.next = current.next; 
      		            current.next = newnode; 
      		         }}
          		   else {
         		        if (sorted == null || 0 > sorted.movie.getName().compareTo(newnode.movie.getName()))  
         		        { 
         		            newnode.next = sorted; 
         		            sorted = newnode; 
         		        } 
         		        else 
         		        { 
         		            current = sorted; 
         		            /* Locate the node before the point of insertion */
         		            while (current.next != null && 0 < current.next.movie.getName().compareTo(newnode.movie.getName()))  
         		            { 
         		                current = current.next; 
         		            } 
         		            newnode.next = current.next; 
         		            current.next = newnode; 
         		         }
          		   	}
    	        	break;
	        case 3:
	        	if(order==1) {
   		        if (sorted == null || sorted.movie.getYear() >= newnode.movie.getYear())  
   		        { 
   		            newnode.next = sorted; 
   		            sorted = newnode; 
   		        } 
   		        else 
   		        { 
   		            current = sorted; 
   		            /* Locate the node before the point of insertion */
   		            while (current.next != null && current.next.movie.getYear() < newnode.movie.getYear())  
   		            { 
   		                current = current.next; 
   		            } 
   		            newnode.next = current.next; 
   		            current.next = newnode; 
   		         }}
       		   else {
      		        if (sorted == null || sorted.movie.getYear() <= newnode.movie.getYear())  
      		        { 
      		            newnode.next = sorted; 
      		            sorted = newnode; 
      		        } 
      		        else 
      		        { 
      		            current = sorted; 
      		            /* Locate the node before the point of insertion */
      		            while (current.next != null && current.next.movie.getYear() > newnode.movie.getYear())  
      		            { 
      		                current = current.next; 
      		            } 
      		            newnode.next = current.next; 
      		            current.next = newnode; 
      		         }
       		   	}
	        	break;
	        case 4:    		   
    		    if(order==1) {
      		        if (sorted == null || 0 < sorted.movie.getDirector().compareTo(newnode.movie.getDirector()))  
      		        { 
      		            newnode.next = sorted; 
      		            sorted = newnode; 
      		        } 
      		        else 
      		        { 
      		            current = sorted; 
      		            /* Locate the node before the point of insertion */
      		            while (current.next != null &&  0 > current.next.movie.getDirector().compareTo(newnode.movie.getDirector()))  
      		            { 
      		                current = current.next; 
      		            } 
      		            newnode.next = current.next; 
      		            current.next = newnode; 
      		         }}
          		   else {
         		        if (sorted == null || 0 > sorted.movie.getDirector().compareTo(newnode.movie.getDirector()))  
         		        { 
         		            newnode.next = sorted; 
         		            sorted = newnode; 
         		        } 
         		        else 
         		        { 
         		            current = sorted; 
         		            /* Locate the node before the point of insertion */
         		            while (current.next != null && 0 < current.next.movie.getDirector().compareTo(newnode.movie.getDirector()))  
         		            { 
         		                current = current.next; 
         		            } 
         		            newnode.next = current.next; 
         		            current.next = newnode; 
         		         }
          		   	}
    	        	break;
	        case 5:
    		   if(order==1) {
   		        if (sorted == null || sorted.movie.getRating() >= newnode.movie.getRating())  
   		        { 
   		            newnode.next = sorted; 
   		            sorted = newnode; 
   		        } 
   		        else 
   		        { 
   		            current = sorted; 
   		            /* Locate the node before the point of insertion */
   		            while (current.next != null && current.next.movie.getRating() < newnode.movie.getRating())  
   		            { 
   		                current = current.next; 
   		            } 
   		            newnode.next = current.next; 
   		            current.next = newnode; 
   		         }}
       		   else {
      		        if (sorted == null || sorted.movie.getRating() <= newnode.movie.getRating())  
      		        { 
      		            newnode.next = sorted; 
      		            sorted = newnode; 
      		        } 
      		        else 
      		        { 
      		            current = sorted; 
      		            /* Locate the node before the point of insertion */
      		            while (current.next != null && current.next.movie.getRating() > newnode.movie.getRating())  
      		            { 
      		                current = current.next; 
      		            } 
      		            newnode.next = current.next; 
      		            current.next = newnode; 
      		         }
       		   	}
	        	break;
	        case 6:    		   
    		    if(order==1) {
      		        if (sorted == null || 0 < sorted.movie.getGenre().compareTo(newnode.movie.getGenre()))  
      		        { 
      		            newnode.next = sorted; 
      		            sorted = newnode; 
      		        } 
      		        else 
      		        { 
      		            current = sorted; 
      		            /* Locate the node before the point of insertion */
      		            while (current.next != null &&  0 > current.next.movie.getGenre().compareTo(newnode.movie.getGenre()))  
      		            { 
      		                current = current.next; 
      		            } 
      		            newnode.next = current.next; 
      		            current.next = newnode; 
      		         }}
          		   else {
         		        if (sorted == null || 0 > sorted.movie.getGenre().compareTo(newnode.movie.getGenre()))  
         		        { 
         		            newnode.next = sorted; 
         		            sorted = newnode; 
         		        } 
         		        else 
         		        { 
         		            current = sorted; 
         		            /* Locate the node before the point of insertion */
         		            while (current.next != null && 0 < current.next.movie.getGenre().compareTo(newnode.movie.getGenre()))  
         		            { 
         		                current = current.next; 
         		            } 
         		            newnode.next = current.next; 
         		            current.next = newnode; 
         		         }
          		   	}
    	        	break;
    	   }
    	        
    	   current = next;
           
       }
       first = sorted; 
   }
// -----------------------------------
   public void mergeSort(int order, int prop) {
	  this.first = mergeSortDiv(order, prop, first);
  }
   
   private MovieLink mergeSortDiv( int order, int prop, MovieLink head) {
	  if(head==null || head.next == null)
	  {
		  return head;
	  		}
	  else {
		  
		  MovieLink temp = head;
		  MovieLink slow = head;
		  MovieLink fast = head;
		  
		  while ( fast != null && fast.next !=null) {
			  temp = slow; //end of first half
			  slow = slow.next; //start of second half
			  fast = fast.next.next; //end of second half
		  }
		  
		  temp.next = null;
		  
		  MovieLink left = mergeSortDiv(order, prop, head);
		  MovieLink right =  mergeSortDiv(order, prop, slow);
		  
		  return merge(left, right, order, prop); //merge first and second half
	  }
   }
	  public MovieLink merge(MovieLink a, MovieLink b, int order, int prop) {
		  
		MovieLinkList temp = new MovieLinkList();
		temp.first = new MovieLink(0,"",0,"",0,"");
		MovieLink current = temp.first;
		
		while (a != null && b !=null) {
			switch(prop) {
				case(1):
					if(order == 1) {
						if (a.movie.getId() < b.movie.getId()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (a.movie.getId() > b.movie.getId()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
				case(2):
					if(order == 1) {
						if (0 < a.movie.getName().compareTo(b.movie.getName())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (0 > a.movie.getName().compareTo(b.movie.getName())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
				case(3):
					if(order == 1) {
						if (a.movie.getYear() < b.movie.getYear()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (a.movie.getYear() > b.movie.getYear()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
				case(4):
					if(order == 1) {
						if (0 < a.movie.getDirector().compareTo(b.movie.getDirector())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (0 > a.movie.getDirector().compareTo(b.movie.getDirector())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
				case(5):
					if(order == 1) {
						if (a.movie.getRating() < b.movie.getRating()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (a.movie.getRating() > b.movie.getRating()) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
				case(6):
					if(order == 1) {
						if (0 < a.movie.getGenre().compareTo(b.movie.getGenre())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
					else {
						if (0 > a.movie.getGenre().compareTo(b.movie.getGenre())) { current.next = a; 	a = a.next;	}
						else { current.next = b; b = b.next; }	
						current = current.next;
					}
				break;
			}

		}
		
		if (a != null) { current.next = a;a = a.next;}
		if (b != null) { current.next = b; b = b.next; }

		return temp.first.next;
		  
	  }
  
   //--------------------------------
  
   public int ReadCSV(String filename) {		// load CSV File
	   int counter = 0;
	   try
		{	
			Path filePath = Paths.get(filename); //path name
			
			BufferedReader fileReader=Files.newBufferedReader(filePath); //start reader
			String rows = fileReader.readLine(); // rows reading
			int rowsCounter =0; //rows counter
				
			while(rows!=null) {		//row's not empty
				rowsCounter++; // count row
				rows=fileReader.readLine(); //and read next
			}
	
			fileReader=Files.newBufferedReader(filePath); // reset reader
			
			for(counter=0; counter<rowsCounter;counter++) { //read for each row
			
				rows=fileReader.readLine();  // get line
				String[] info = rows.split(","); // split line
				this.insertLast(this.getElems()+1, info[0], Integer.parseInt(info[1]), info[2], Float.parseFloat(info[3]), info[4]); //add line info to array
	
				}
			return counter;
			
		}catch (IOException e) {
				e.printStackTrace();
				return counter;
			}

   }
// -----------------------------------
  public void displayList()		// display the list
      {
      MovieLink current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }//end displayList()
//-----------------------------------
   public void displaySlice(int start, int end)		 // display the list
      {
	   if(end<= this.getElems()) {
	      MovieLink current = first;       // start at beginning of list
	      int i = 0;
	      while(i != start) {
	    	  current = current.next;
	    	  i++;
	      }
	      while( i< end)      // until end of list,
	         {
	         current.displayLink();   // print data
	         current = current.next;  // move to next link
	         i++;
	         }
	   }
	   else {
		   System.out.println("Error: Print out of range");
	   }
      }//end displayList()   
// -----------------------------------
   public int getElems() { 		// get number of movies in list
	   int nElems = 0;
	   MovieLink current = first;       // start at beginning of list
	   while(current != null)      // until end of list,
	     {
	     nElems++;   // count data
	     current = current.next;  // move to next link
	     }
	   return nElems;
   }
// -----------------------------------
   public boolean findKey (String searchKey, int prop, boolean print){ // return true or false if find the searchKey in defined prop
		int counter = 0; //n of finded items
		boolean find = false; //already find one
		MovieLink current = first; //start at first
		while(current!= null) {
			switch (prop) { //select wich prop to search for
			case 1:
				if(current.movie.getId() == Integer.parseInt(searchKey)) { //compare
					find = true; //mark if find
					counter++;  //count how many times it found
					if(print == true) //if print its true display it
						System.out.println(current.movie.toString());}
				break;
			case 2:
				if(0 == current.movie.getName().compareTo(searchKey)) { //same ahead but for each prop
					find = true;
					counter++;
					if(print == true)
						System.out.println(current.movie.toString());}
				break;
			case 3:
				if(current.movie.getYear() == Integer.parseInt(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(current.movie.toString());}
				break;
			case 4:
				if(0 == current.movie.getDirector().compareTo(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(current.movie.toString());}
				break;
			case 5:
				if(current.movie.getRating() == Float.parseFloat(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(current.movie.toString());}
				break;
			case 6:
				if(0 == current.movie.getGenre().compareTo(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(current.movie.toString());}
				break;

			}
			current = current.next;
	}	 //display format...

		String propName = "";
		switch (prop) {
		case 1:
			propName = "id";
			break;
		case 2:
			propName = "name";
			break;
		case 3:
			propName = "year";
			break;
		case 4:
			propName = "director";
			break;
		case 5:
			propName = "rating";
			break;
		case 6:
			propName = "genre";
			break;
		}
		System.out.printf("Find: %d elements matching with searched key: %s in prop: %s \n", counter, searchKey, propName); //print how many itens find 
		return find;
	}
//----------------------------------------
	public boolean removeById (int id, boolean print) { //remove a item by specified iD
	  if(first == null)
		  return false;							//if its empty do not search
	  
      MovieLink current = first;              // search for link
      MovieLink previous = first;
      while(current.movie.getId() != id)
         {
         if(current.next == null)
            return false;                 // didn't find it
         else
            {
            previous = current;          // go to next link
            current = current.next;
            }
         }                               // found it
	if(print == true)
		System.out.printf("Removing: %s.\n", current.movie.toString());
      if(current == first)               // if first link,
         first = first.next;             //    change first
      else                               // otherwise,
         previous.next = current.next;   //    bypass it
      return true;
		
	}
 
   }  // end class MovieLinkList
