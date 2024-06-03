package com.hrportal.config;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

@Service
public class PasswordHelper {

	// Method to generate a 256-bit AES key
	public static String generateSecretKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256); // 256-bit AES
		SecretKey secretKey = keyGen.generateKey();
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}

	// Method to generate a 128-bit IV
	public static String generateIV() {
		byte[] iv = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		return Base64.getEncoder().encodeToString(iv);
	}

	public static String encrypt(String plainText, String secretKey, String iv) throws Exception {
		byte[] decodedKey = Base64.getDecoder().decode(secretKey);
		byte[] decodedIv = Base64.getDecoder().decode(iv);

		SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIv);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public static String decrypt(String encryptedText, String secretKey, String iv) throws Exception {
		byte[] decodedKey = Base64.getDecoder().decode(secretKey);
		byte[] decodedIv = Base64.getDecoder().decode(iv);

		SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIv);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
		byte[] originalBytes = cipher.doFinal(encryptedBytes);

		return new String(originalBytes);
	}

}
