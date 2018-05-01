package finalintegration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileLoader {

	private File file;

	public FileLoader(String path) {
		loadFile(path);
	}

	/*
	 * The file is loaded using this method
	 */
	private void loadFile(String path) {
		file = new File(path); //loads file
	}

	/*
	 * After being loaded, the file can now be read 
	 */
	public String read(File file, boolean checkFileExists) {
		String message = " ";
		try {
			Scanner reader = new Scanner(file); //used to read files
			if (checkFileExists)
			System.out.println("Correct path, file found."); // notifies the user
			while (reader.hasNext()) { // loops until the end of line
				message = reader.nextLine(); //stores text from file
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect path, file not found. "); //notifies the user
			System.out.println(e.getMessage());
			System.exit(0); //if file is not found then the program exits
		}
		return message;
	}
	
	/*
	 * After being loaded the file can now be written to 
	 */
	public void write(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file); //used to write to files
			System.out.println("Writing to file...");
			writer.write(text); //writes to the file
			writer.close(); // processor stops using file
			System.out.println("New Message: " + read(file, false));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public File getFile() {
		return file;
	}

}
