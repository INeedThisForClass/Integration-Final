package finalintegration;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	/*
	 * My App is called File Encrypter. It allows a user to encrypt or decrypt any text file
	 * they chose. This is accomplished with several classes and methods which are explained
	 * throughout the project.
	 */

	/*
	 * Main, FileLoader, Encryption, and FileEncryption Classes are used to create this program
	 * 1. The user is asked to direct the program to an existing file
	 * 2. If the file is found the program proceeds, if it is not the program terminates
	 * 3. Several options are given to the user (display text, write new text, encrypt, decrypt)
	 * 4. Based on the respected choice of the user the program completes the task
	 * 5. The options are incorporated in a loop which allows the user to use the program in one run
	 * 6. The user exits (based on their choice) the program successfully closes the file and thanks the user
	 */
	
	public static void main(String[] args) {
		projectInfo();
		Scanner input = new Scanner(System.in); // user input
		System.out.println("Start by loading a text file.");
		System.out.print("Enter path to file here: "); // path to file
		String path = input.nextLine(); // stores path to file
		FileLoader loader = new FileLoader(path); // loads file from path through constructor
		File currentFile = loader.getFile(); // current loaded file
		FileEncryption encrypter = new FileEncryption(); // allows to encrypt / decrypt files

		boolean running = true; //keeps programming running until exit
		while (running) {
			int option = 0; // invalid option
			while (option < 1 || option > 5) {
				showOptions(); //displays all valid options
				option = input.nextInt();
				input.nextLine(); //consumes empty character
			}
			String message = loader.read(currentFile, false);// gets the current message from the file

			if (option == 1) {
				System.out.println("Current Message: " + loader.read(currentFile, false)); // current message
			} else if (option == 2) {
				System.out.print("Type new message here: ");
				String newMessage = input.nextLine();
				loader.write(currentFile, newMessage); // new message
			} else if (option == 3) {
				String encrypted = encrypter.encryptedMessage(message); // encrypts message
				loader.write(currentFile, encrypted);
			} else if (option == 4) {
				String decrypted = encrypter.decryptedMessage(message); // decrypts message
				loader.write(currentFile, decrypted);
			} else {
				running = false; // exits
				input.close();
				System.out.println("Successfully closed. Thank You for using our application!");
			}
		}
	}

	private static void projectInfo() {
		// project description
		System.out.println("Project: Final Integration");
		System.out.println("Author: Romanov Andre");
		System.out.println("Last Edit: April 27 2018");
		System.out.println();
	}
	
	private static void showOptions() {
		// all valid options
		System.out.println("1. Display Message");
		System.out.println("2. Write New Message");
		System.out.println("3. Encrypt File");
		System.out.println("4. Decrypt File");
		System.out.println("5. Exit");
		System.out.print("Select an option: ");
	}
}
