package swap;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class swap {

	public static void main(String[] args) throws IOException {
		//location D:\\Uni\\PIK\\PIK3\\file.txt
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file location:");
		String fileName = sc.nextLine();
		
		try {
		      File file = new File(fileName);
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		        System.out.println("File already exists.\n");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace(); 
		    }
		
		Scanner input = new Scanner(new File(fileName));
		System.out.println("The contents of the file:");
		while (input.hasNextLine())
		{
		   System.out.println(input.nextLine());
		}
		
	    List<String> lines = Files.readAllLines(Paths.get(fileName));
	    List<List<String>> array = new ArrayList<>(lines.size());
	    Swappers s1 = new Swappers();
	   
	    s1.iteration(lines, array);
		
		System.out.println("\n1. Swap Words\n2. Swap Lines\n3. Exit");
		int i = sc.nextInt();
		switch(i) {
		  case 1:
			  try {
				  	System.out.println("Enter the row and line for the word to be swapped:");
			    	int row1 = sc.nextInt();
		 	    	int line1 = sc.nextInt();
		 	    	System.out.println("Enter the row and line of the word to swap with:");
		 	    	int row2 = sc.nextInt();
			    	int line2 = sc.nextInt();
				    s1.wordSwap(array, row1, line1, row2, line2);
			    } catch (IndexOutOfBoundsException e) {
					      System.out.println("Index out of bounds.");
					      e.printStackTrace(); 
			    }
			  s1.printer(array, fileName);
			  System.out.println("Program Closed.");
		    break;
		  case 2:
			  try {
				  	System.out.println("Enter line to be swapped and line to swap with:");
			    	int a = sc.nextInt();
					int b = sc.nextInt();
					s1.lineSwap(array, a, b);
			    } catch (IndexOutOfBoundsException e) {
				      System.out.println("Index out of bounds.");
				      e.printStackTrace();
			    }
			  s1.printer(array, fileName);
			  System.out.println("Program Closed.");
		    break;
		  case 3:
			  System.out.println("Program Closed.");
			return;
		  default:
			  System.out.println("Wrong input.");
		}
		
	}

}
