package finalintegration;

public class FileEncryption extends Encryption {

	/*
	 * Subclass to Encryption 
	 * defines two methods for encrypting and decrypting
	 * the key variable from the encryption class is used to shift letters to permit encryption 
	 */
	public String encryptedMessage(String message) {
		String encrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char current = message.charAt(i);
			if (current != ' ')current += (char)key; //shifts characters
			encrypted += current;
		}
		return encrypted;
	}

	public String decryptedMessage(String message) {
		String decrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char current = message.charAt(i);
			if (current != ' ')current -= (char)key; //removes shift
			decrypted += current;
		}
		return decrypted;
	}
}
