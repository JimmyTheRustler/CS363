import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class generator {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("possibilities1.txt", "UTF-8");
		for (int i = 0; i <= 13_000; i++) {
			writer.println(i+"");
		}

	}

}
