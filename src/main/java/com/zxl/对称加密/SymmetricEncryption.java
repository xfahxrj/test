/**
 * 
 */
package com.zxl.对称加密;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

/**
 * @author 胥方雁
 * @data 2018年5月9日 上午10:01:01
 * 对称加密解密
 */
public class SymmetricEncryption {
	public static String ALGORITHM_DES = "DES";
    public static String ALGORITHM_3DES = "DESede"; // 3DES
    public static String ALGORITHM_BLOWFISH = "Blowfish";
    public static String ALGORITHM_AES = "AES";
    private static Key key;
    private static byte[] ivarr = { 0x30, 0x31, 0x30, 0x32, 0x30, 0x33, 0x30, 0x34, 0x30, 0x35, 0x30, 0x36, 0x30, 0x37, 0x30, 0x38 };//偏移量
    public static Key keyGenerator(String algorithm, int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }
    // 加密方法
    public static byte[] encrypt(Key key, String text, String algorithm) throws Exception {
        // ECB是分组模式，PKCS5Padding 是补全策略
        Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");///CBC/PKCS5Padding该模式需要偏移量,而ECB不需要
       // IvParameterSpec iv = new IvParameterSpec(ivarr);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text.getBytes());
    }
    // 解密方法
    public static byte[] decrypt(Key key, byte[] data, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
        //IvParameterSpec iv = new IvParameterSpec(ivarr);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }
    public static void main(String[] args) {
    	String passwordText = "这是我的信用卡账号 5555 5555 5555 55555";
    	String encoderString =  encoder(passwordText.getBytes());
    	System.out.println(encoderString);
    	//6L+Z5piv5oiR55qE5L+h55So5Y2h6LSm5Y+3IDU1NTUgNTU1NSA1NTU1IDU1NTU1
    	try {
			key = keyGenerator(ALGORITHM_AES,256);
			byte[] encryptext = encrypt(key, encoderString, ALGORITHM_AES);
			encryptext = decrypt(key, encryptext, ALGORITHM_AES);
			System.out.println(encoder(encryptext));
			System.out.println(dncoder(encryptext));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static String encoder(byte[] data){
    	return new String(Base64.getEncoder().encode(data));
    }
    public static String dncoder(byte[] data){
    	return new String(Base64.getDecoder().decode(data));
    }
}
