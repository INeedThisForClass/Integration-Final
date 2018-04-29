package finalintergrationproject.encryption;

import java.util.Random;

public abstract class Encryption {
	
	/*
	 *  Encryption
	 *  Superclass to all Encryptions
	 *  provides a random instance to generate a random key
	 *  key is used to encrypt the currently loaded file
	 *  used to encrypt the message from the currently loaded file - encryptedMessage(message);
	 *  used to decrypt the message from the currently loaded file - decryptedMessage(message);
	 */
	protected static Random random = new Random();
	protected static int key = random.nextInt(5);
	
	public abstract String encryptedMessage(String message);
	public abstract String decryptedMessage(String message);

}
