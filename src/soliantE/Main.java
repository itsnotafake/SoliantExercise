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
				//ContactSearch.contactFormat(line = buffered_Reader.readLine());
				System.out.println(line = buffered_Reader.readLine());
			}catch(NullPointerException npe){
				System.out.println("NullPointerException: Cannot determine Contact Format");
			}
			while((line = buffered_Reader.readLine()) != null){
				System.out.println(line);
				//ContactSearch.addToMaps(line);
			}
			buffered_Reader.close();
		}catch(FileNotFoundException fnfe){
			System.out.println("FileNotFoundException: File could not be found");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

}
