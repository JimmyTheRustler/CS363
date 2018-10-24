import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class vigenereUnknown {

	public static void main(String[] args) throws IOException {
		
		int[] IOC = new int[26];
		int[] alphaFreq = new int[26];
		char[] letterFreq = {'E','A','R','I','O','T','N','S','L','C','U','D','P','M','H',
								'G','B','F','Y','W','K','V','X','Z','J','Q'};
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String usrFile = userInput.nextLine();
		
		try {
			byte[] buffer = new byte[1000];
			FileInputStream file = new FileInputStream(usrFile);
			int numRead = 0;
			
			for(int i = 0; i < buffer.length; i++){
				if(buffer[i] == 'A'){
					IOC[0]++;
				}
				else if(buffer[i] == 'B'){
					IOC[1]++;
				}
				else if(buffer[i] == 'C'){
					IOC[2]++;
				}
				else if(buffer[i] == 'D'){
					IOC[3]++;
				}
				else if(buffer[i] == 'E'){
					IOC[4]++;
				}
				else if(buffer[i] == 'F'){
					IOC[5]++;
				}
				else if(buffer[i] == 'G'){
					IOC[6]++;
				}
				else if(buffer[i] == 'H'){
					IOC[7]++;
				}
				else if(buffer[i] == 'I'){
					IOC[8]++;
				}
				else if(buffer[i] == 'J'){
					IOC[9]++;
				}
				else if(buffer[i] == 'K'){
					IOC[10]++;
				}
				else if(buffer[i] == 'L'){
					IOC[11]++;
				}
				else if(buffer[i] == 'M'){
					IOC[12]++;
				}
				else if(buffer[i] == 'N'){
					IOC[13]++;
				}
				else if(buffer[i] == 'O'){
					IOC[14]++;
				}
				else if(buffer[i] == 'P'){
					IOC[15]++;
				}
				else if(buffer[i] == 'Q'){
					IOC[16]++;
				}
				else if(buffer[i] == 'R'){
					IOC[17]++;
				}
				else if(buffer[i] == 'S'){
					IOC[18]++;
				}
				else if(buffer[i] == 'T'){
					IOC[19]++;
				}
				else if(buffer[i] == 'U'){
					IOC[20]++;
				}
				else if(buffer[i] == 'P'){
					IOC[21]++;
				}
				else if(buffer[i] == 'W'){
					IOC[22]++;
				}
				else if(buffer[i] == 'X'){
					IOC[23]++;
				}
				else if(buffer[i] == 'Y'){
					IOC[24]++;
				}
				else{
					IOC[25]++;
				}
				
			}
			int temp = 0;;
			int max = alphaFreq[0];
			for(int i = 0; i < IOC.length; i++){
				for(int j = 0; j < IOC.length; i++){
					if(IOC[i] > max)
						max = IOC[i];
				}
				
			}
			
			for(int i = 0; i < buffer.length; i++){
				
			}
			
			file.close();
		}catch(FileNotFoundException ex){
			System.out.println("File not found!");
		}

	}

}
