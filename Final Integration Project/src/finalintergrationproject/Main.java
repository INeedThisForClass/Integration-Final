package finalintergrationproject;

import java.util.Scanner;

import finalintergrationproject.encryption.Encryption;
import finalintergrationproject.encryption.FileEncryption;

public class Main {

	/*
	 * 	Main class
	 * 	The class loads a text file from a given path
	 * 	It stores the string contained in the text file
	 * 	It allows the user to encrypt or decrypt the text
	 * 	Based on the respected choice it utilizes the FileEncryption class to do so
	 * 	It returns the desired input to the user and saves it to the file
	 * 	Lastly it closes the file so the JVM stops processing it
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	private static void projectInfo() {
		// project description
		System.out.println("Project: Final Integration");
		System.out.println("Author: Romanov Andre");
		System.out.println("Last Edit: April 27 2018");
		System.out.println();
	}

	public static void main(String[] args) {
		projectInfo();
		// loading text file
		System.out.println("Start by loading a text file.");
		System.out.print("Enter path to file here: ");
		String path = scanner.nextLine();
		System.out.println();
		FileLoader loader = new FileLoader(path);
		Encryption file = new FileEncryption();
		boolean running = true;
		while (running) {
			// utilizing message to encrypt or decrypt
			System.out.print("Type message here: ");
			String message = scanner.nextLine();
			System.out.println("Message: " + message);
			System.out.println();
			// option
			int option = -1;
			while (option < 1 || option > 3) {
				System.out.println("1. Encrypt Text File");
				System.out.println("2. Decrypt Text File");
				System.out.println("3. Exit");
				System.out.print("Select an option: ");
				option = scanner.nextInt();
				scanner.nextLine();
			}
			if (option == 1) {
				String encryptedMessage = file.encryptedMessage(message);
				loader.write(encryptedMessage);
			} else if (option == 2) {
				String decryptedMessage = file.decryptedMessage(message);
				loader.write(decryptedMessage);
			} else {
				running = false;
				loader.closeScanner();
				scanner.close();
				System.out.println("Text file successfully closed. Thank you for using this application!");
			}
		}
	}
}
