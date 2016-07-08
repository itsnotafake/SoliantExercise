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
			String fileName = "src\\soliantE\\SampleText";
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try{
				//assuming that the first line always contains "first_name,last_name,email,phone"
				//this try-catch reads that line in as "contact format"
				ContactSearch.setContactFormat(line = bufferedReader.readLine());
				System.out.println(line);
			}catch(NullPointerException npe){
				System.out.println("NullPointerException: Cannot determine Contact Format");
			}
			//initializes the 2 HashMaps that will be used for storing information
			//lastName indexing currently has O(n) time but can be optimized for O(logn)
			ContactSearch.createMaps();
			
			//calls a function that reads the line into both HashMaps
			while((line = bufferedReader.readLine()) != null){
				System.out.println(line);
				ContactSearch.addToMaps(line);
			}
			bufferedReader.close();
			
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
