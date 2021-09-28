package com.concord.nextstep.logger;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class PasswordDecrypter 
{
	public static String decryptAES(String encryptedData) 
	{
		if (encryptedData != null && !encryptedData.isEmpty()) 
		{
		   try 
		   {
			   Key key = getKey();
		       Cipher cipher = Cipher.getInstance("AES");
		       cipher.init(Cipher.DECRYPT_MODE, key);
		       Base64 base64 = new Base64();
		       byte[] decodedBytes = base64.decode(encryptedData);
		       byte[] finalDecodedData = cipher.doFinal(decodedBytes);
		       System.out.println(new String(finalDecodedData));
		       return new String(finalDecodedData);
		   } 
		   catch (NoSuchAlgorithmException e) 
		   {
		           e.printStackTrace();
		   } 
		   catch (NoSuchPaddingException e) 
		   {
		           e.printStackTrace();
		   } 
		   catch (InvalidKeyException e) 
		   {
		           e.printStackTrace();
		   } 
		   catch (BadPaddingException e) 
		   {
		           e.printStackTrace();
		   } 
		   catch (IllegalBlockSizeException e) 
		   {
		           e.printStackTrace();
		   } 
		   catch (Exception e) 
		   {
		          System.err.println(e.getMessage());
		   }
		}
		return null;
	}

	private static Key getKey() 
	{
		byte[] codecKey = new String("one_key_to_rule_them_all").getBytes();
		String codecAlgorithm = "AES";
		Key key = new SecretKeySpec(codecKey, codecAlgorithm);
		return key;
	}
}
