package resources;

//import java.util.List;
import java.util.Random;
//import java.util.UUID;

public class UniqueIdGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Generate a unique random ID
			//UUID uuid = UUID.randomUUID();
			//String randomId = uuid.toString();
			//System.out.println("Random ID: " + randomId);
		RandomStringGenerator();
	}

	public static String RandomStringGenerator() {
		int length = 8; // Specify the desired length of the random string
		// int strings = 5; // Specify the number of IDs to generate
		
		String characters = "0123456789"; //ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
		StringBuilder stringBuilder = new StringBuilder();

		Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
		 String randomString = stringBuilder.toString();
			 System.out.println("Random String: "+randomString);
        return null;
	}
}
