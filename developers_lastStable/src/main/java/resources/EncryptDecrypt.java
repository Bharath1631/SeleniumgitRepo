package resources;


import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

//@Component
public class EncryptDecrypt extends Base {

	private static Cipher cipher; 
	private static  SecretKey secretKey = null;
	//@Value("${cipher.secretkey}")
	private String cipherSecretKey;
	
//	@PostConstruct
	public void initSecretKey() throws IOException {

		/*
        Cipher Info
        Algorithm : for the encryption of electronic data
        mode of operation : to avoid repeated blocks encrypt to the same values.
        padding: ensuring messages are the proper length necessary for certain ciphers 
        mode/padding are not used with stream cyphers.  
		 */
		cipherSecretKey = readProperties("cipher.secretkey");
		try {
			
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128); // block size is 128bits
			secretKey = new SecretKeySpec(cipherSecretKey.getBytes(), "AES");

			//with this secret key encrypted text never changes.
			//with randomly generated secret key, encrypted text change.So cannot decrypt using random key.
			cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  


		} catch (NoSuchAlgorithmException e) {
			
		}catch (Exception e) {
			
		}

	}

//	public static String encrypt(String plainText)
//			throws Exception {
//		try {
//
//			byte[] plainTextByte = plainText.getBytes();
//			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//			byte[] encryptedByte = cipher.doFinal(plainTextByte);
//			String encryptedText =  Base64.getUrlEncoder().encodeToString(encryptedByte);
//			return encryptedText;
//		} catch (InvalidKeyException e) {
//			throw e;
//		} catch (IllegalBlockSizeException e) {
//			throw e;
//		} catch (BadPaddingException e) {
//			throw e;
//		}
//
//	}

//	public static String decrypt(String encryptedText)
//			throws Exception {
//		try {
//
//			Base64.Decoder decoder = Base64.getDecoder();
//			byte[] encryptedTextByte = decoder.decode(encryptedText);
//			cipher.init(Cipher.DECRYPT_MODE, secretKey);
//			byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
//			String decryptedText = new String(decryptedByte);
//			return decryptedText;
//		} catch (InvalidKeyException e) {
//			throw e;
//		} catch (IllegalBlockSizeException e) {
//			throw e;
//		} catch (BadPaddingException e) {
//			throw e;
//		}
//	}


	public static String encryptInt(Integer plainText)  throws Exception  {
		try {
			
			byte[] plainTextByte = BigInteger.valueOf(plainText).toByteArray();
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedByte = cipher.doFinal(plainTextByte);
			String encryptedText =  Base64.getUrlEncoder().encodeToString(encryptedByte);
			

			return encryptedText;
		} catch (InvalidKeyException e) {
			throw e;
		} catch (IllegalBlockSizeException e) {
			throw e;
		} catch (BadPaddingException e) {
			throw e;
		}
	}

	public static Integer decryptInt(String encryptedText) throws Exception {
		try {
			
			byte[] encryptedTextByte = Base64.getUrlDecoder().decode(encryptedText);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
			Integer value = new BigInteger(decryptedByte).intValue();
			

			return value;
		} catch (InvalidKeyException e) {
			throw e;
		} catch (IllegalBlockSizeException e) {
			throw e;
		} catch (BadPaddingException e) {
			throw e;
		}

	}

public static String encryptString(String plainString) throws Exception {
    	
    	try {
    		
            byte[] plainStringByte = plainString.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedByte = cipher.doFinal(plainStringByte);
            String encryptedString =  Base64.getUrlEncoder().encodeToString(encryptedByte);
           

            return encryptedString;
    	} catch(InvalidKeyException e) {
    		throw e;
    	} catch (IllegalBlockSizeException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        }
    }

    public static String decryptString(String encryptedText) throws Exception {
        try {
           
            byte[] encryptedTextByte = Base64.getUrlDecoder().decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            String value = new String(decryptedByte);
           
            return value;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        }

    }

}

