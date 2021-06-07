package CetaudMichel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Test {

	public static void main(String[] args)  {
	
		
	}
	
	public void Read() throws FileNotFoundException {
		File file = new File("/Users/Cetaud/Desktop/test.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
	
	public void Write() throws IOException{
		
		String[] filecontent = {"test","de","fou"};
		
		FileWriter writer = new FileWriter("/Users/Cetaud/Desktop/yo.txt");
		writer.write(filecontent);
		writer.close();
	}
	

}
