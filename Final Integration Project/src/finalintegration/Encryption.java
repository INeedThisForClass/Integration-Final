package finalintegration;

import java.util.Random;

public abstract class Encryption {
	/*
	 * Superclass to all Encryption
	 * defines a key variable for all encryptions and decryptions
	 * defines two methods for encrypting and decrypting
	 */
	protected static Random random = new Random();
	protected static int key = random.nextInt(5);
	
	public abstract String encryptedMessage(String message);
	public abstract String decryptedMessage(String message);
}
