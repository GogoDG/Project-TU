package swap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Swappers {
	
	public void wordSwap(List<List<String>> array, int row1, int line1, int row2, int line2)
	{
		String tempWord = array.get(row1).get(line1);
		array.get(row1).set(line1, array.get(row2).get(line2));
 	    array.get(row2).set(line2, tempWord);
	}
	
	public void lineSwap(List<List<String>> array, int a, int b)
	{
		Collections.swap(array, a, b);
	}
	
	public void printer(List<List<String>> array, String file)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<array.size(); i++)
		{
			sb.append(array.get(i)).append(System.lineSeparator());
		}
		
		String str = sb.toString();
		str = str.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\\,", "");
		System.out.println(str);
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(str.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void iteration(List<String> lines, List<List<String>> array)
	{
		lines.forEach(line -> {
	    	String[] elements = line.split("\\s+");
	        array.add(Arrays.asList(elements));
	    });
	}
}
