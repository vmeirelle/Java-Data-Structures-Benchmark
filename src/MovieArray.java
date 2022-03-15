//movieArray class

//create a array of movie object

//able to read CSV data and add into it, ReadCSV()
//insert() to add manually
//getElems to get array size
//findById() and findByName() for search in array 
//display() to display entire array
//displaySlice() to display a specific section
//insertionSort() to sort it by specified prop and order (asc or desc)
//findKey() to find a key into specified prop
//removeById() to remove the item with specified Id

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MovieArray {
	
	private Movie[] movies;
	private int nElems;
	// -----------------------------------
	
	public MovieArray() { 	//constructor	
		nElems = 0;
	} // end constructor
	// -----------------------------------
	public int ReadCSV (String filename) { 	// load CSV File

		try
		{
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
			
			Movie[] newMovieList = new Movie[rowsCounter + this.nElems]; //create a new array with size of old elems + new elems
			int beginAt = nElems; //save old n elems
			nElems = 0; //renew nElems
			for(counter=0; counter<beginAt;counter++) {
				newMovieList[counter] = movies[counter]; //add from old array to new array
				nElems++;
			}
			for(counter=beginAt; counter<(beginAt+rowsCounter);counter++) { //now get also the new reading to the new array
				
				rows=fileReader.readLine();  // get line
				
				String[] info = rows.split(","); // split line
	
				newMovieList[counter] = new Movie((this.getElems() + 1), info[0], Integer.parseInt(info[1]), info[2], Float.parseFloat(info[3]), info[4]); //add line info to new array
				nElems ++;
				}
			
			this.movies = newMovieList; // define old array as new array
			return (counter-beginAt); // return only the quantity of new info add
			
		}catch (IOException e) {
				e.printStackTrace();
				return (0);
			}

		}
	// -----------------------------------
	public void insert(int id, String name, int year, String director, float rating, String genre)    // put element into array
	{	
		movies[nElems] = new Movie(id, name, year, director, rating, genre); //create new movie
		nElems++;                      // increment size
	}
	// -----------------------------------
	public int getElems() { 	// get number of movies in array
		return nElems;
	}
	// -----------------------------------
	public void display()       // displays array contents
	{
		for(int j=0; j<nElems; j++)       // for each element,
			System.out.println(movies[j].toString());  // display it

	}
	// -----------------------------------
	public void displaySlice(int start, int end)       // displays array contents
	{	if(end<=nElems) {
			for(int j=start; j<end; j++)       // for each element,
				System.out.println(movies[j].toString());  // display it
			}
		else {
			System.out.println("Error: Print out of range"); //if cant print, display error
		}
		
	}
	// -----------------------------------
	public void insertionSort(int order, int prop) { 		// sort the array, order (1 -ascending, 2-descending), prop(1-id, 2-name, 3-year, 4-director, 5-rate, 6-genre)

      for (int j = 1; j < this.nElems; j++) {  				
	         Movie aux = this.movies[j];  						
	         int i = j-1; 
	         
	         switch(prop) {
	         case 1:
	        	 if(order==1) {
	        		 while ( (i > -1 && this.movies[i].getId() > aux.getId() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while ( (i > -1 && this.movies[i].getId() < aux.getId() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
		         break;
	         case 2:
	        	 if(order==1) {
	        		 while (i > -1 && 0 < this.movies[i].getName().compareTo(aux.getName())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while (i > -1 &&  0 > this.movies[i].getName().compareTo(aux.getName())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
		         break;
	         case 3:
	        	 if(order==1) {
	        		 while ( (i > -1 && this.movies[i].getYear() > aux.getYear() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while ( (i > -1 && this.movies[i].getYear() < aux.getYear() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
		         break;	         
		     case 4:
	        	 if(order==1) {
	        		 while (i > -1 && 0 < this.movies[i].getDirector().compareTo(aux.getDirector())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while (i > -1 &&  0 > this.movies[i].getDirector().compareTo(aux.getDirector())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
	        	 break;
	         case 5:
	        	 if(order==1) {
	        		 while ( (i > -1 && this.movies[i].getRating() > aux.getRating() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while ( (i > -1 && this.movies[i].getRating() < aux.getRating() ) ){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
		         break;	         
	         case 6:
	        	 if(order==1) {
	        		 while (i > -1 && 0 < this.movies[i].getGenre().compareTo(aux.getGenre())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         } else {
	        		 while (i > -1 &&  0 > this.movies[i].getGenre().compareTo(aux.getGenre())){  	
	        			 this.movies[i+1] = this.movies[i];  		
	        			 i--;
	        		 }
		         }
	        	 break;
	         }
	         
	         this.movies[i+1] = aux; 

      }
	}
	// -----------------------------------
	public void mergeSort(int order, int prop) {
		mergeSortDiv(order, prop, 0, nElems-1);
	}
	//-------------------------------------
	private void mergeSortDiv(int order, int prop, int low, int high) { //sort the array order (1-ascending, 2-descending), prop(1-id, 2-name, 3-year, 4-director, 5-rate, 6-genre)
		
		if ((high - low) >= 1) 
		{
			int mid1 = (low + high) / 2; 
			int mid2 = mid1 + 1; 
			mergeSortDiv(order, prop, low, mid1); 
			mergeSortDiv(order, prop, mid2, high); 
			merge(low, mid1, mid2, high, order, prop);
		}
	}
	//---------------------------------
	private void merge(int low, int mid1, int mid2, int high, int order, int prop) {
		int aLeft = low; 
		int aRight = mid2; 
		int aCombined = low; 
		Movie[] Combined = new Movie[nElems];
		
		while (aLeft <= mid1 && aRight <= high){
			switch(prop) {
				case(1):
					if(order==1) {
						if (movies[aLeft].getId() <= movies[aRight].getId())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (movies[aLeft].getId() >= movies[aRight].getId())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
				case(2):
					if(order==1) {
						if (0 < movies[aLeft].getName().compareTo(movies[aRight].getName()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (0 > movies[aLeft].getName().compareTo(movies[aRight].getName()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
				
				case(3):
					if(order==1) {
						if (movies[aLeft].getYear() <= movies[aRight].getYear())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (movies[aLeft].getYear() >= movies[aRight].getYear())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
				case(4):
					if(order==1) {
						if (0 < movies[aLeft].getDirector().compareTo(movies[aRight].getDirector()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (0 > movies[aLeft].getDirector().compareTo(movies[aRight].getDirector()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
				case(5):
					if(order==1) {
						if (movies[aLeft].getRating() <= movies[aRight].getRating())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (movies[aLeft].getRating() >= movies[aRight].getRating())
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
				case(6):
					if(order==1) {
						if (0 < movies[aLeft].getGenre().compareTo(movies[aRight].getGenre()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					else {
						if (0 > movies[aLeft].getGenre().compareTo(movies[aRight].getGenre()))
							Combined[aCombined++] = movies[aLeft++];
						else
							Combined[aCombined++] = movies[aRight++];
					}
					break;
			}

		} 
		if (aLeft == mid2)  
			while (aRight <= high)
				Combined[aCombined++] = movies[aRight++];
		else
			while (aLeft <= mid1)
				Combined[aCombined++] = movies[aLeft++]; 
		for (int i = low; i <= high; i++)
			movies[i] = Combined[i];
		
	}
	//---------------------------------
	public boolean findKey (String searchKey, int prop, boolean print){ // return true or false if find the searchKey in defined prop
		int j;
		int counter = 0;
		boolean find = false;
		for(j=0; j<nElems; j++) { //search for key into it proper propriety
			switch (prop) {
			case 1:
				if(movies[j].getId() == Integer.parseInt(searchKey)) { 
					find = true; //if find mark find as true
					counter++; //and counter how many time it have been find
					if(print == true)
						System.out.println(movies[j].toString());} //print every time it finds a item that matches
				break;
			case 2:
				if(0 == movies[j].getName().compareTo(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(movies[j].toString());}
				break;
			case 3:
				if(movies[j].getYear() == Integer.parseInt(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(movies[j].toString());}
				break;
			case 4:
				if(0 == movies[j].getDirector().compareTo(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(movies[j].toString());}
				break;
			case 5:
				if(movies[j].getRating() == Float.parseFloat(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(movies[j].toString());}
				break;
			case 6:
				if(0 == movies[j].getGenre().compareTo(searchKey)) {
					find = true;
					counter++;
					if(print == true)
						System.out.println(movies[j].toString());}
				break;
			}
	}	

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
		System.out.printf("Find: %d elements matching with searched key: %s in prop: %s \n", counter, searchKey, propName); // print how many items find
		return find; 
	}
	//----------------------------------------
	public boolean removeById (int id, boolean print) {
		boolean find = false;
		int i;
		for(i = 0; i<this.nElems; i++) {
			if(movies[i].getId() == id) { //find the movie
				find = true; //mark as finded
				if(print == true)
					System.out.printf("Removing: %s.\n", movies[i].toString()); //print out what movie is
				break;
			}
		}
		if(find == true) { //push movie to the end of array and decrement size
			for(int j = i; j<this.nElems-1; j++) {
				Movie aux = movies[j];
				movies[j] = movies [j+1];
				movies[j+1] = aux;
				}
			this.nElems--;
			}
		
		return find;
	}
}  // end class MovieArray