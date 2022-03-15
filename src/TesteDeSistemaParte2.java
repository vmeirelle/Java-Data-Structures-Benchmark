
public class TesteDeSistemaParte2 {
	public static void main(String[] args) {
		
		//TEST MERGE SORT 
		
		//1. Array
		
		MovieArray MovieA = new MovieArray();
		MovieA.ReadCSV("mock_data.csv");
		MovieA.ReadCSV("mock_data_2.csv");
		
		System.out.println("------         ARRAY BEFOR SORT           -----------");
		MovieA.displaySlice(0, 3);
		MovieA.displaySlice(MovieA.getElems()-3, MovieA.getElems());
		
		for (int i=1; i<3;i++) {
			for (int j=1; j<7; j++) {
				MovieA.mergeSort(i, j);
				System.out.printf("\n\n------         ARRAY WITH SORT ORDER: %d PROP: %d           -----------\n\n", i, j);
				MovieA.displaySlice(0, 3); //3 first
				MovieA.displaySlice(MovieA.getElems()-3, MovieA.getElems()); //3 last
				
			}
		}
		
		//2. LINK LIST
		
		MovieLinkList MovieL = new MovieLinkList();
		MovieL.ReadCSV("mock_data.csv");
		MovieL.ReadCSV("mock_data_2.csv");
		
		System.out.println("------         LINKLIST BEFOR SORT           -----------");
		MovieL.displaySlice(0, 3);
		MovieL.displaySlice(MovieA.getElems()-3, MovieA.getElems());
		
		for (int i=1; i<3;i++) {
			for (int j=1; j<7; j++) {
				MovieL.mergeSort(i, j);
				System.out.printf("\n\n------         LINKLIST WITH SORT ORDER: %d PROP: %d           -----------\n\n", i, j);
				MovieL.displaySlice(0, 3); //3 first
				MovieL.displaySlice(MovieL.getElems()-3, MovieL.getElems()); //3 last
				
			}
		}
		
		//TEST TREE
		
		MovieTreeList MovieT = new MovieTreeList();
		MovieT.ReadCSV("mock_micro_data10.csv"); //we can only print full list so test gonna run a small data
		
		System.out.println("\n\n------         START TREE           -----------\n\n");
		
		MovieT.displayTree(); 
		
		for (int i=1; i<3;i++) {
			for (int j=1; j<7; j++) {
				MovieT.sortTree(j, i);
				System.out.printf("\n\n------         TREE SORT ORDER: %d PROP: %d           -----------\n\n", i, j);
				MovieT.displayTree(); 
				
			}
		}
		
		
		System.out.println("\n\n------         DELETING ELEMENTS           -----------\n\n");
		MovieT.delete(2);
		MovieT.delete(7);
		MovieT.displayTree(); 
		
		System.out.println("\n\n------         FINDING ELEMENTS (true)          -----------\n\n");
		
		String id = "1";
		String name = "Evergreen";
		String year = "2006";
		String director = "Rainer Weedon";
		String rate = "5.76";
		String genre = "Documentary|IMAX";
		

		System.out.println(MovieT.find(id,1,true));
		System.out.println(MovieT.find(name,2,true));
		System.out.println(MovieT.find(year,3,true));
		System.out.println(MovieT.find(director,4,true));
		System.out.println(MovieT.find(rate,5,true));
		System.out.println(MovieT.find(genre,6,true));
		
		
System.out.println("\n\n------         FINDING ELEMENTS (false)          -----------\n\n");
		
		id = "2221";
		name = "E2vergreen";
		year = "222006";
		director = "Ra22iner Weedon";
		rate = "5.7226";
		genre = "Do2222cumentary|IMAX";
		
		System.out.println(MovieT.find(id,1,true));
		System.out.println(MovieT.find(name,2,true));
		System.out.println(MovieT.find(year,3,true));
		System.out.println(MovieT.find(director,4,true));
		System.out.println(MovieT.find(rate,5,true));
		System.out.println(MovieT.find(genre,6,true));
		
System.out.println("\n\n------         TempSizeArr Size (supports the tree)         -----------\n");
	MovieT.displayTree();
	System.out.println("\n\n " + MovieT.sizeArr() + " elements in tree");
	
	
	} //end main
}//end teste de sistema 2
