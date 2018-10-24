import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class DHAES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    public static void main(String[] args) throws IOException{
    	BigInteger bigA = new BigInteger("455999968826556232865376360741");
    	BigInteger smallB = new BigInteger("1337");
    	BigInteger bigB = new BigInteger("0");
    	BigInteger K = genK(bigA, smallB);
    	bigB = smallbToBigB(bigA, smallB);
    	String kString = K.toString();

    	//System.out.println(bigB);
    	byte[] data = null;
    	FileInputStream fis = null;
    	File filezz = new File("data.des");
    	try{
    		fis = new FileInputStream(filezz);
    		data = new byte[(int)filezz.length()];
    		fis.read(data);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	byte[] decryptedData = decrypt(data, kString);
    	
    	FileOutputStream fos = new FileOutputStream("dataDecryptedDES.txt");
        fos.write(decryptedData);
        fos.close();
    	
    }
    
    public static BigInteger genK(BigInteger bigA, BigInteger smallB) {
    	BigInteger p = new BigInteger("521419622856657689423872613771");
    	BigInteger K = bigA.modPow(smallB, p);
    	return K;
    }
    
    public static BigInteger smallbToBigB( BigInteger bigA, BigInteger smallB ){
    	BigInteger ans = new BigInteger("0");
    	int b = smallB.intValue();
    	BigInteger q = new BigInteger("153312796669816512924567214991");
    	BigInteger p = new BigInteger("521419622856657689423872613771");
    	BigInteger qb = q.pow(b);
    	ans = qb.mod(p);
    	return ans;
    }
    
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 8);
            secretKey = new SecretKeySpec(key, "DES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(byte[] strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(strToEncrypt);
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting bytes: " + e.toString());
        }
        return null;
    }

 
    public static byte[] decrypt(byte[] strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(strToDecrypt);
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting bytes: " + e.toString());
        }
        return null;
    }
 
}