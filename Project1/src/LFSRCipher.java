import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LFSRCipher {

	public static void main(String[] args) throws IOException {
		
		byte fill = (byte) 255;
		byte fill2 = (byte) 126;
		byte fill3 = (byte) 253;
		byte fill4 = (byte) 55;
		String usrFile = "LFSR.encrypted";

		try {
			byte[] buffer = new byte[32058];
			byte[] decrypted = new byte [32058];
			byte[]feedPoly = new byte[8];
			int count = 0;
			FileInputStream file = new FileInputStream(usrFile);
			
			//debugging while loop
            int numRead = 0;
			//converts binary to string to read
            while((numRead = file.read(buffer)) != -1) {
                System.out.println(new String(buffer));
            }
            
            for(int i = 0; i < buffer.length; i++) {
            	decrypted[i] = (byte) ((buffer[i]) ^ fill);
            	System.out.print(   (char)(( (decrypted[i] % 128) + 128 ) % 128 )  );
            	
            	
            }
            
            file.close();
		}catch(FileNotFoundException ex){
			System.out.println("File not found!");
		}

	}

}
