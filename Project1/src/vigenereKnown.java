import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class vigenereKnown {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Type d to decrypt, or e to encrypt: ");
		String usrchoice = userInput.nextLine();

		Scanner userInput1 = new Scanner(System.in);
		System.out.print("Enter the file you want to use: ");
		String usrfile = userInput1.nextLine();

		if(usrchoice.equals("d")) {
			try {
				byte[] buffer = new byte[115];
				FileInputStream file = new FileInputStream(usrfile);

				String preCipher = "";
				String keyWord = "TAGORE";
				int numRead = 0;

				while( (numRead = file.read(buffer)) != -1 ) {
					preCipher += new String(buffer);
				}
				System.out.println("Encrypted:  " + preCipher);
				decrypt(preCipher, keyWord);

				file.close();
			}catch(FileNotFoundException ex){
				System.out.println("File not found!");
			}	

		}
		else {
			try {
				byte[] buffer = new byte[21];
				FileInputStream file = new FileInputStream(usrfile);

				String preCipher = "";
				String keyWord = "LUKE";
				int numRead = 0;

				while( (numRead = file.read(buffer)) != -1 ) {
					preCipher += new String(buffer);
				}
				System.out.println("Decrypted:  " + preCipher);
				encrypt(preCipher, keyWord);

				file.close();
			}catch(FileNotFoundException ex){
				System.out.println("File not found!");
			}
			
		}
	}

	public static void decrypt(String preCipher, String keyWord) {

		int[] keyArray = new int[keyWord.length()];
		int tempASCII = 0;
		char tempLetter = ' ';
		String postCipher = " ";

		/* For-Loop converts keyword to ascii and puts each letter in a container in an array */
		for(int i = 0; i < keyWord.length(); i++)
			keyArray[i] = (int) keyWord.charAt(i);

		for(int i = 0; i < preCipher.length(); i++) {
			tempASCII = ((  (  (int) preCipher.charAt(i) - 65  ) - (  (keyArray[i % keyArray.length]) - 65  )  ) );
			tempASCII = ((tempASCII % 26) + 26) % 26;
			tempLetter = (char) (tempASCII + 65);
			postCipher += tempLetter;
			/* re-initialize variables */
			tempASCII = 0;
			tempLetter = ' ';
		}

		System.out.println("Decrypted: " + postCipher);
	}

	public static void encrypt(String preCipher, String keyWord) {

		int[] keyArray = new int[keyWord.length()];
		int tempASCII = 0;
		char tempLetter = ' ';
		String postCipher = " ";

		/* For-Loop converts keyword to ascii and puts each letter in a container in an array */
		for(int i = 0; i < keyWord.length(); i++)
			keyArray[i] = (int) keyWord.charAt(i);

		for(int i = 0; i < preCipher.length(); i++) {
			tempASCII = ((  (  (int) preCipher.charAt(i) - 65  ) + (  (keyArray[i % keyArray.length]) - 65  )  ) % 26 );
			tempLetter = (char) (tempASCII + 65);
			postCipher += tempLetter;
			/* re-initialize variables */
			tempASCII = 0;
			tempLetter = ' ';
		}

		System.out.println("Encrypted: " + postCipher);
	}

}
