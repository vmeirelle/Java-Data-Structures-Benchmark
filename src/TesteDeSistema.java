// Welcome to TesteDeSistema (SystemTest)

// here we have some to-go functions already applied, for demonstration
public class TesteDeSistema {

	public static void main(String[] args) {
		
		//LOAD TEST
		
		MovieLinkList MovieL = new MovieLinkList(); // create link
		
		MovieArray MovieA = new MovieArray(); // create array
		

		MovieL.ReadCSV("mock_data.csv"); //load data in link
		MovieL.ReadCSV("mock_data_2.csv"); //load data in link
		
		MovieA.ReadCSV("mock_data.csv"); //load data in array
		MovieA.ReadCSV("mock_data_2.csv"); //load data in array	
		
		// GET ELEMS TEST
		
		System.out.println("\n//////////////////////     LinkList nElems test:     //////////////////////\n");
		System.out.println(MovieL.getElems()); //get number of elements
		
		System.out.println("\n//////////////////////     Array nElems test:     //////////////////////\n");
		System.out.println(MovieA.getElems()); //get number of elements
		
		// SORT TEST
		
		for(int i = 1; i<=6; i++) {
			for(int j=1; j<=2; j++) {
				System.out.println("\n//////////////////////     LinkList InsertionSort test:     //////////////////////\n");
				System.out.printf("\n SORTING ORDER: %d PROP: %d \n", j, i); //show sort prop
				MovieL.insertionSort(j, i); // sort
				System.out.println("\n5 first: "); //print first 5 for check
				MovieL.displaySlice(0,5);
				System.out.println("5 last: "); //print last 5 for check
				MovieL.displaySlice(MovieL.getElems()-5, MovieL.getElems());
			}
		}
		

		
		for(int i = 1; i<=6; i++) {
			for(int j=1; j<=2; j++) {
				System.out.println("\n//////////////////////     Array InsertionSort test:     //////////////////////\n");
				System.out.printf("\n SORTING ORDER: %d PROP: %d \n", j, i); //show sort prop
				MovieA.insertionSort(j, i); // sort
				System.out.println("\n5 first: "); //print first 5 for check
				MovieA.displaySlice(0,5);
				System.out.println("5 last: "); //print last 5 for check
				MovieA.displaySlice(MovieA.getElems()-5, MovieA.getElems());
			}
		}
		
		//FIND TEST
		// def some itens for search, all in database
		String id = "12";
		String name = "Ziegfeld Follies"; 
		String year = "1983";
		String director = "Amil Broomer";
		String rate = "4.90";
		String genre = "Romance";
		boolean print = false;
		
		System.out.println("\n//////////////////////     LinkList find test (true):     //////////////////////\n");
		System.out.println(MovieL.findKey(id, 1, print)); //search for them, 1 by 1
		System.out.println(MovieL.findKey(name, 2, print));
		System.out.println(MovieL.findKey(year, 3, print));
		System.out.println(MovieL.findKey(director, 4, print));
		System.out.println(MovieL.findKey(rate, 5, print));
		System.out.println(MovieL.findKey(genre, 6, print));
		

		System.out.println("\n//////////////////////     Array find test (true):     //////////////////////\n ");		
		System.out.println(MovieA.findKey(id, 1, print)); // search for them, 1 by 1
		System.out.println(MovieA.findKey(name, 2, print));
		System.out.println(MovieA.findKey(year, 3, print));
		System.out.println(MovieA.findKey(director, 4, print));
		System.out.println(MovieA.findKey(rate, 5, print));
		System.out.println(MovieA.findKey(genre, 6, print));
		
		// def some itens for search, not in database
		id = "12322";
		name = "Fiegfeld Zollies"; 
		year = "3891";
		director = "Bmil Aroomer";
		rate = "90.4";
		genre = "Ecnamor";
		print = false;
		
		System.out.println("\n//////////////////////     LinkList find test (false):     //////////////////////\n");
		System.out.println(MovieL.findKey(id, 1, print)); // search for them, 1 by 1
		System.out.println(MovieL.findKey(name, 2, print));
		System.out.println(MovieL.findKey(year, 3, print));
		System.out.println(MovieL.findKey(director, 4, print));
		System.out.println(MovieL.findKey(rate, 5, print));
		System.out.println(MovieL.findKey(genre, 6, print));
		

		System.out.println("\n//////////////////////     Array find test (false):     ////////////////////// \n");		
		System.out.println(MovieA.findKey(id, 1, print)); // search for them 1 by 1
		System.out.println(MovieA.findKey(name, 2, print));
		System.out.println(MovieA.findKey(year, 3, print));
		System.out.println(MovieA.findKey(director, 4, print));
		System.out.println(MovieA.findKey(rate, 5, print));
		System.out.println(MovieA.findKey(genre, 6, print));
		
		//CLEARING ORDER FOR REMOVE TEST
		MovieA.insertionSort(1, 1); // sort back to default
		MovieL.insertionSort(1, 1); // sort back to deafult
		
		// REMOVE TEST
		System.out.println("\n//////////////////////     LinkList before remove (true):     ////////////////////// \n");	
		System.out.println("\n5 first: "); //show 5 first and 5 last, before removing data
		MovieA.displaySlice(0,5);
		System.out.println("5 last: ");
		MovieL.displaySlice(MovieL.getElems()-5, MovieL.getElems());
		
		System.out.println("\n//////////////////////     Array before remove (true):     ////////////////////// \n");	
		System.out.println("\n5 first: "); //show 5 first and 5 last, before removing data
		MovieA.displaySlice(0,5);
		System.out.println("5 last: ");
		MovieL.displaySlice(MovieL.getElems()-5, MovieL.getElems());
	
		
		int removeId[] = {2,3,1998,1999}; // def some itens Id for removing

		System.out.println("\n//////////////////////     LinkList remove test (true):     ////////////////////// \n");	
		for (int i = 0; i<removeId.length; i++) {
			System.out.println(MovieL.removeById(removeId[i], true)); // remove for the first time 
		}
		
		System.out.println("\n//////////////////////     Array remove test (true):     //////////////////////\n");	
		for (int i = 0; i<removeId.length; i++) {
			System.out.println(MovieA.removeById(removeId[i], true)); // remove for the first time
		}
		
		System.out.println("\n//////////////////////     LinkList remove test (false):     //////////////////////\n ");	
		for (int i = 0; i<removeId.length; i++) {
			System.out.println(MovieL.removeById(removeId[i], true)); // try to remove again but they already have been removed
		}
		
		System.out.println("\n//////////////////////     Array remove test (false):     ////////////////////// \n");	
		for (int i = 0; i<removeId.length; i++) {
			System.out.println(MovieA.removeById(removeId[i], true)); // try to remove again but they already have been removed
		}
		
		System.out.println("\n//////////////////////     LinkList after remove (true):     ////////////////////// \n");	
		System.out.println("\n5 first: "); //show 5 first and 5 last, after removing data
		MovieA.displaySlice(0,5);
		System.out.println("5 last: ");
		MovieL.displaySlice(MovieL.getElems()-5, MovieL.getElems());
		
		System.out.println("\n//////////////////////     Array after remove (true):     ////////////////////// \n");	
		System.out.println("\n5 first: "); //show 5 first and 5 last, after removing data
		MovieA.displaySlice(0,5);
		System.out.println("5 last: ");
		MovieL.displaySlice(MovieL.getElems()-5, MovieL.getElems());
		
	}}
		//end of TesteDeSistema


