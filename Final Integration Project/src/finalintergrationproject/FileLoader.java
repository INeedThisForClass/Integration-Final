package finalintergrationproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileLoader {

	private File file;
	private Scanner scanner;
	private FileWriter writer;

	/*
	 *  FileLoader Class
	 *  allows the user to load a file - load(path);
	 *  allows the user to read a file - read();
	 *  allows the user to write to the file - write(message);
	 *  closes the scanner to stop reading the file
	 */
	public FileLoader(String path) {
		load(path);
	}

	public void load(String path) {
		try {
			scanner = new Scanner(file = new File(path));
			System.out.println("Text file found.");
		} catch (FileNotFoundException e) {
			System.out.println("Text file not found." + e.getMessage());
		}
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read() {
		System.out.println("Text file contains:");
		String text = "";
		while (scanner.hasNext()) {
			text = scanner.next();
		}
		return text;
	}

	public void write(String message) {
		try {
			System.out.println("Text file now contains:");
			writer.write(message);
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeScanner() {
		scanner.close();
	}
}
