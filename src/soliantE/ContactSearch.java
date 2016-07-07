package soliantE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class ContactSearch {
	
	public static LinkedList<String> contactLL;
	public static HashMap<String,String> contactHM;
	
	//contactFormatDetails
	public static String first_Detail;
	public static String second_Detail;
	public static String third_Detail;
	public static String fourth_Detail;
	
	/*public static void contactFormat(String line){
		String[] line_array = line.split(",");
		first_Detail = line_array[0];
		second_Detail = line_array[1];
		third_Detail = line_array[2];
		fourth_Detail = line_array[3];
	}*/
	
	public static void addToMaps(String line){
		String[] line_array = line.split(",");
		//String first_name = line_array[0];
		//String last_name = line_array[1];
		//String email = line_array[2];
		//String phone = line_array[3];
		contactHM.put(line_array[2], line);
		ListIterator<String> li = contactLL.listIterator(0);
		whil
	}

}
