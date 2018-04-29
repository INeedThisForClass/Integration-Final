package finalintergrationproject.encryption;

public class FileEncryption extends Encryption {

	/*
	 *  FileEncryption Class
	 *  Subclass to Encryption
	 *  encrypts message by shifting characters over - encryptedMessage(message);
	 *  decrypts message by shifting characters opposite from the encryption - decryptedMessage(message);
	 */
	public String encryptedMessage(String message) {
		String encrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char current = message.charAt(i);
			if (current != ' ')current += (char)key;
			encrypted += current;
		}
		return encrypted;
	}

	public String decryptedMessage(String message) {
		String decrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char current = message.charAt(i);
			if (current != ' ')current -= (char)key;
			decrypted += current;
		}
		return decrypted;
	}

}
