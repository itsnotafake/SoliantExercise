package soliantE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] Args){
		String line = null;
		try{
			File file = new File(Args[0]);
			FileReader file_Reader = new FileReader(file);
			BufferedReader buffered_Reader = new BufferedReader(file_Reader);
			try{
				//assuming that the first line always contains "first_name,last_name,email,phone"
				//this try-catch reads that line in as "contact format"
				ContactSearch.setContactFormat(line = buffered_Reader.readLine());
				System.out.println(line);
			}catch(NullPointerException npe){
				System.out.println("NullPointerException: Cannot determine Contact Format");
			}
			//initializes the 2 HashMaps that will be used for storing information
			ContactSearch.createMaps();
			
			//calls a function that reads the line into both HashMaps
			while((line = buffered_Reader.readLine()) != null){
				System.out.println(line);
				ContactSearch.addToMaps(line);
			}
			buffered_Reader.close();
			
			//The two different methods for lookup
			//ContactSearch.retrieveContactsByLastName("s"); //(Currently does not take lower case letters)
			//ContactSearch.retrieveContactByEmail("LisaESauceda@armyspy.com");
		}catch(FileNotFoundException fnfe){
			System.out.println("FileNotFoundException: File could not be found");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
