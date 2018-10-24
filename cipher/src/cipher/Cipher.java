package cipher;

public class Cipher {

	public static void main(String[] args) {
		int shift = 0;
		String jumble = "Dc, gdcl cl h lcrcshn ckqh gz sqwqs guz. Gdcl gcrq qhyd sqggqn cl hllcomqk h ljqycacqk nqshgczmldcj ucgd hmzgdqn sqggqn. Jhll: cdhwqancqmkl";
		jumble = jumble.toLowerCase();
		for(int i = 0; i <= 25; i++){
			System.out.println(i + ": " + shifty(jumble, shift));
			shift++;
		}
	}

	public static String shifty(String scramble, int shift){
		String decrypted = "";
		char letter;
		int ascii;
		
		
		for(int i = 0; i < scramble.length(); i++){
			if(scramble.charAt(i) == ' ' ||scramble.charAt(i) == ':' || scramble.charAt(i) == '.' || scramble.charAt(i) == '?'){//whitespace
				decrypted += scramble.charAt(i);
			}
			else{ //if letter found then shift letter by shift count
				letter = scramble.charAt(i);
				ascii = (int) letter; // ascii must be between including 97 - 122
				ascii += shift;
				if(ascii > 122)
					ascii = (ascii - 122) + 96; //96 since it should start at letter a, not b
				letter = (char) ascii;

				decrypted += letter;
			}
		}

		return decrypted;
	}

}
