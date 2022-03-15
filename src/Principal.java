//MovieData Manipulation App
//by Vinicius Meirelles (@vmeirelle)

//This application makes easier to work with a .csv movie database.
//Upload your .csv into this folder. Make sure your database info are in this order: Name, Year, Director, Rating, Genre.

//Here you can:

//1. Import csv movie data
//2. Show the data (show everything or slice it into smaller pieces)
//3. Sort data by any prop you want.
//4. Find data by any prop you want.
//5. Remove a data by its id.

//Check out the TesteDeSistema file for some demo.

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		MovieArray MovieListArray = new MovieArray(); // create array (default max size = 1000)
		MovieLinkList MovieListLink = new MovieLinkList(); // create link
		MovieTreeList MovieTreeList = new MovieTreeList();
		System.out.println("Welcome to MovieData Manipulation App");
		
		//Create input
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		
		int aux = 0;
		while (aux != 1 && aux!=2 && aux !=3) {
		    try{ //loop for correct input
		    	System.out.println("Enter 1 for Array List, 2 for Link List or 3 for Binary Tree");
		    	String auxString = input.nextLine(); 
		    	aux = Integer.parseInt(auxString);  // Read user option
			    System.out.println("Chosen: " + aux);  // Output user input
			    if (aux != 1 && aux!=2 && aux!=3)
			    	System.out.println("Invalid input. Try again");
			}
		    catch (NumberFormatException e) {
		    	
		    	System.out.println("Invalid input. Try again");
		    	aux = 0;
		    }
		}
		
		boolean exit = false;
		while(exit == false) {

			int menu = 0;
			while (menu!=1 && menu!=2 && menu!=3 && menu!=4 && menu!=5 && menu!=6) { //main menu choice
				try{ //loop for correct choice
				System.out.println("Please, choose one: \n1. Import data.\n2. Show Data\n3. Sort data.\n4. Find data.\n5. Remove data.\n6. Exit. ");
				String menuString = input.nextLine();
				menu = Integer.parseInt(menuString); // Read user option
				System.out.printf("Selected: %d.\n", menu); // Output user input
				}
				catch(NumberFormatException e) {
					menu = 0;
			    	System.out.println("Invalid input. Try again");
				}
				
				}
	
			switch(menu) {
			case 1: //LOAD
			    System.out.println("Enter CSV filename:");
			    String filename = input.nextLine(); //Read filename
			    System.out.println("Filename: " + filename);  // Output user input
			    
			    if(aux == 1) {
			    	try{ // ensures a correct filename
			    		float startTime = System.nanoTime();
						int loaded = MovieListArray.ReadCSV(filename); //load CSV into array
						float endTime = System.nanoTime();
						System.out.printf("Loaded. Eplased time: %.2f ms, number of imported data: %d, number of data: %d\n", (endTime-startTime)/1000000, loaded ,MovieListArray.getElems()); 
					}
			    	catch (Exception e) {
				    	System.out.println("Invalid file, please try again. ");
			    	}}
			    if(aux ==2){
			    	try { //ensures a correct filename
						float startTime = System.nanoTime();
						int loaded = MovieListLink.ReadCSV(filename); //load CSV into link
						float endTime = System.nanoTime();
						System.out.printf("Loaded. Eplased time: %.2f ms, number of imported data: %d, number of data: %d\n", (endTime-startTime)/1000000, loaded, MovieListLink.getElems());
				    }
			    catch (Exception e) {
			    	System.out.println("Invalid file, please try again. ");
			    }}
			    if(aux == 3){
			    	try { //ensures a correct filename
						float startTime = System.nanoTime();
						int loaded = MovieTreeList.ReadCSV(filename); //load CSV into link
						float endTime = System.nanoTime();
						System.out.printf("Loaded. Eplased time: %.2f ms, number of imported data: %d, number of data: %d\n", (endTime-startTime)/1000000, loaded, MovieTreeList.sizeArr());
				    }
			    catch (Exception e) {
			    	System.out.println("Invalid file, please try again. ");
			    }}
			    break;
			case 2:	//PRINT
				if(aux ==1) {
					String printChoiceS;
					int printCounter = 10;
					int printChoice = 0;
					System.out.println("Printing first 10 items: "); //print 10 items
					MovieListArray.displaySlice(0, 10); //display
					while (printCounter <= MovieListArray.getElems() && printChoice != 3) { //keep printing options till it gets to the end
						try { //ensure correct option
							System.out.println("1. To print 10 more.\n2. To print every lasting data.\n3. Back menu. ");
							printChoiceS = input.nextLine();
							printChoice = Integer.parseInt(printChoiceS);
							
							switch (printChoice) { 
							case 1:
								MovieListArray.displaySlice(printCounter, printCounter+10); //display
								printCounter = printCounter + 10; //counter to where it stops
								break;
							case 2:
								MovieListArray.displaySlice(printCounter, MovieListArray.getElems()); //print from where it stops to the end
								printChoice = 3; //exit menu
								break;
							case 3:
								break;
							default:
								System.out.printf("Invalid input (%d) \n", printChoice);
							}
							
					}
						catch (Exception e) {
							System.out.println("Invalid input, try again");
							printChoice = 0;
						}
					
				}}
				if (aux == 2) { //same as above but for linked list
					String printChoiceS;
					int printCounter = 10;
					int printChoice = 0;
					System.out.println("Printing first 10 items: ");
					MovieListLink.displaySlice(0,10); //display
					while (printCounter <= MovieListLink.getElems() && printChoice != 3) {
						try {
							System.out.println("1. To print 10 more.\n2. To print every lasting data.\n3. Back menu. ");
							printChoiceS = input.nextLine();
							printChoice = Integer.parseInt(printChoiceS);
							switch (printChoice) {
							case 1:
								MovieListLink.displaySlice(printCounter, printCounter + 10); //display
								printCounter = printCounter + 10;
								break;
							case 2:
								MovieListLink.displaySlice(printCounter, MovieListLink.getElems());
								printChoice = 3;
								break;
							case 3:
								break;
							default:
								System.out.printf("Invalid input (%d) \n", printChoice);
							}
							
					}
					catch (Exception e) {
						System.out.println("Invalid input, try again.");
						printChoice = 0;
					}
					}}
					if (aux == 3) { //same as above but for linked list

						System.out.println("Printing full tree list.... .... ... "); //cant print sliced tree list
						MovieTreeList.displayTree();
						}
					break;
			case 3:				//SORT 
				int order = 0;
				String orderS;
				int sortType = 3;
				String sortTypeS;
				while (sortType!=1 && sortType!=2) {
					try {
						if(aux != 3) {	
						System.out.println("Please select: \n1. Insertion Sort.\n2. Merge Sort. "); //GET ORDER FOR ORDENATION
							sortTypeS = input.nextLine(); //read input
							sortType = Integer.parseInt(sortTypeS); }
						}
					catch (Exception e){
						System.out.println("Invalid input, try again.");
						order = 0;
					}}
				
				while (order!=1 && order!=2) {
					try {
						System.out.println("Please select: \n1. For ascending sorting.\n2. For descending sorting. "); //GET ORDER FOR ORDENATION
						orderS = input.nextLine(); //read input
						order = Integer.parseInt(orderS); 
						}
					catch (Exception e){
						System.out.println("Invalid input, try again.");
						order = 0;
					}}
				int prop = 0;
				String propS;
				while (prop!=1 && prop!=2 && prop!=3 && prop!=4 && prop!=5 && prop!=6) { //GET PROP FOR INSERTIONSORT ORDENATION
					try{
						System.out.println("Please select: \n1. Sort by id.\n2. Sort by name.\n3. Sort by year.\n4. Sort by Director\n5. Sort by Rate\n6. Sort by Genre");
						propS = input.nextLine();
						prop = Integer.parseInt(propS);
						}
					catch(Exception e) {
						System.out.println("Invalid input, try again.");
						prop = 0;
					}
				}
				if(sortType == 1) {
					if(aux==1) {
						float startTime = System.nanoTime();					
						MovieListArray.insertionSort(order,prop); // ORDENATION FOR ARRAY
						float endTime = System.nanoTime();
						System.out.printf("Sorted. Eplased time: %.2f ms\n", (endTime-startTime)/1000000);
	
					}
					else {
						float startTime = System.nanoTime();							
						MovieListLink.insertionSort(order,prop); // OORDENATION FOR LINKLIST
						float endTime = System.nanoTime();
						System.out.printf("Sorted. Eplased time: %.2f ms\n", (endTime-startTime)/1000000);
	
					}
				}
				else {
					if(aux==1) {
						float startTime = System.nanoTime();					
						MovieListArray.mergeSort(order,prop); // ORDENATION FOR ARRAY
						float endTime = System.nanoTime();
						System.out.printf("Sorted. Eplased time: %.2f ms\n", (endTime-startTime)/1000000);
	
					}
					if(aux==2) {
						float startTime = System.nanoTime();							
						MovieListLink.mergeSort(order,prop); // OORDENATION FOR LINKLIST
						float endTime = System.nanoTime();
						System.out.printf("Sorted. Eplased time: %.2f ms\n", (endTime-startTime)/1000000);
	
					}
					if(aux==3) {

						float startTime = System.nanoTime();							
						MovieTreeList.sortTree(prop,order); // OORDENATION FOR TREE
						float endTime = System.nanoTime();
						System.out.printf("Sorted. Eplased time: %.2f ms\n", (endTime-startTime)/1000000);
					}
				}
			
				break;
			case 4: // FIND
				int propFind = 0;
				String propFindS;
				while(propFind!=1 && propFind!=2 && propFind!=3 && propFind!=4 && propFind!=5 && propFind!=6) { // SELECT PROP TO SEARCH IN
					try {  //ensures no error
					System.out.println("Please select: \n1. Find by id.\n2. Find by name.\n3. Find by year.\n4. Find by Director\n5. Find by Rate\n6. Find by Genre");
					propFindS = input.nextLine(); //read input
					propFind = Integer.parseInt(propFindS);
					System.out.printf("Selected: %d\n", propFind);
					}
					catch (Exception e) {
						System.out.println("Invalid input, try again");
					}
				}
				System.out.println("Type search key:"); 
				String searchKey = input.nextLine(); //read search key
				if(aux==1) {
					float startTime = System.nanoTime();
					boolean finded = MovieListArray.findKey(searchKey, propFind,true); // searchKey for Array
					float endTime = System.nanoTime();
					System.out.printf("Searched. Finded: %b. Eplased time: %.2f ms\n", finded, (endTime-startTime)/1000000);			
				}
				if(aux==2) {
					float startTime = System.nanoTime();
					boolean finded = MovieListLink.findKey(searchKey, propFind,true); // searchKey for LinkedList
					float endTime = System.nanoTime();
					System.out.printf("Searched. Finded: %b. Eplased time: %.2f ms\n", finded, (endTime-startTime)/1000000);
				}
				if(aux==3){
					float startTime = System.nanoTime();
					boolean finded = MovieTreeList.find(searchKey, propFind, true); // searchKey for Tree
					float endTime = System.nanoTime();
					System.out.printf("Searched. Finded: %b. Eplased time: %.2f ms\n", finded, (endTime-startTime)/1000000);
				}
				break;
			case 5: // REMOVE
				int idRemove = 0;
				String idRemoveS; 
				while(idRemove == 0 ) {
					try { // ensure no error
					System.out.println("Please type a movie id to remove it: ");
					idRemoveS = input.nextLine(); //read ID for remove
					idRemove = Integer.parseInt(idRemoveS);
					System.out.printf("Selected: %d\n", idRemove);
				} catch (Exception e) {
					System.out.println("Invalid input, try again. ");
				}}
				if(aux==1) {
					float startTime = System.nanoTime();
					boolean removed = MovieListArray.removeById(idRemove,true); // remove for Array
					float endTime = System.nanoTime();
					System.out.printf("Removed: %b. Eplased time: %.2f ms\n", removed, (endTime-startTime)/1000000);
				}
				if(aux==2) {
					float startTime = System.nanoTime();
					boolean removed = MovieListLink.removeById(idRemove,true); // remove for LinkList
					float endTime = System.nanoTime();
					System.out.printf("Removed: %b. Eplased time: %.2f ms\n", removed, (endTime-startTime)/1000000);
				}
				if(aux==3) {
					float startTime = System.nanoTime();
					boolean removed = MovieTreeList.delete(idRemove); // remove for Tree
					float endTime = System.nanoTime();
					System.out.printf("Removed: %b. Eplased time: %.2f ms\n", removed, (endTime-startTime)/1000000);
				}
				break;
			case 6: // Exit
				exit = true; // exit while
				System.out.print("Program terminated.");
				break;
			default:
				System.out.printf("Invalid input (%d) \n", menu); //invalid input
		}
	    
	    

} input.close(); //close input
	}} //end main