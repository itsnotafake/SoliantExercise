package soliantE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ContactSearch {
	
	private static HashMap<String, List<String>> contactByLastNameHM;
	private static HashMap<String,String> contactByEmailHM;
	private static String contactFormat;
	
	public static void setContactFormat(String s){
		contactFormat = s;
	}
	
	public static void createMaps(){
		HashMap<String, List<String>> firstMap = new HashMap<String, List<String>>();
		contactByLastNameHM = firstMap;
		HashMap<String, String> secondMap = new HashMap<String,String>();
		contactByEmailHM = secondMap;
	}
	
	public static void addToMaps(String line){
		String[] line_array = line.split(",");
		//String first_name = line_array[0], String last_name = line_array[1]
		//String email = line_array[2], String phone = line_array[3];
		
		//This allows for O(1) lookup time by email address
		contactByEmailHM.put(line_array[2], line);
		
		String first_character = line_array[1].substring(0,1);
		first_character = first_character.toUpperCase();//In case somebody enters the last name in lower case
		//no last names starting with this particular character have been added yet
		if(!contactByLastNameHM.containsKey(first_character)){
			List<String> lastNameList = new LinkedList<String>();
			lastNameList.add(line);
			contactByLastNameHM.put(first_character, lastNameList);
		}else{
			List<String> lastNameList = contactByLastNameHM.get(first_character);
			//delete our current entry of the LList as we are going to edit the LList then re-add it
			contactByLastNameHM.remove(first_character);
			ListIterator<String> listIterator = lastNameList.listIterator();
			boolean added = false;
			int linkedList_index = 0;
			//this is done to sort the entries by last name in the stored LList
			while(listIterator.hasNext() && added == false){
				String current = listIterator.next();
				String[] current_array = current.split(",");
				if(line_array[1].compareTo(current_array[1]) < 0){
					lastNameList.add(linkedList_index, line);
					added = true;
				}
				linkedList_index++;
			}
			if(added == false){
				lastNameList.add(line);
			}
			contactByLastNameHM.put(first_character, lastNameList);
		}
	}
	
	public static void retrieveContactByEmail(String email){
		try{
			String line =  contactByEmailHM.get(email);
			printContact(line);
		}catch(NullPointerException e){
			System.out.println("This email does not exist");
		}
	}
	
	public static void retrieveContactsByLastName(String letter){
		if(letter.length() > 1){
			letter = letter.substring(0,1);
		}
		letter = letter.toUpperCase();
		try{
			List<String> lastNameList = contactByLastNameHM.get(letter);
			ListIterator<String> listIterator = lastNameList.listIterator();
			String line = "";
			while(listIterator.hasNext()){
				line = listIterator.next();
				printContact(line);
			}
		}catch(NullPointerException e){
			System.out.println("There are no users whose last name starts with this character");
		}
	}
	
	public static void printContact(String line){
		String[] line_array = line.split(",");
		String first_name = line_array[0];
		String last_name = line_array[1];
		String email = line_array[2];
		String phone = line_array[3];
		System.out.println("Last: "+last_name+", First: "+first_name+ 
				", Phone: "+phone+", E-Mail: "+email);
	}

}
