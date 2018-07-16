/**
 * 
 */
package com.zxl.对称加密;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @author 胥方雁
 * @data 2018年5月9日 上午9:47:26
 */
public class CipherTest {
	 private static final int LOOP = 50000;

	    public static String ALGORITHM_DES = "DES";
	    public static String ALGORITHM_3DES = "DESede"; // 3DES
	    public static String ALGORITHM_BLOWFISH = "Blowfish";
	    public static String ALGORITHM_AES = "AES";

	    public static Key keyGenerator(String algorithm, int n) throws Exception {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
	        keyGenerator.init(n);
	        return keyGenerator.generateKey();
	    }

	    // 加密方法
	    public static byte[] encrypt(Key key, String text, String algorithm) throws Exception {
	        // ECB是分组模式，PKCS5Padding 是补全策略
	        Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        return cipher.doFinal(text.getBytes());
	    }

	    // 解密方法
	    public static byte[] decrypt(Key key, byte[] data, String algorithm) throws Exception {
	        Cipher cipher = Cipher.getInstance(algorithm + "/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        return cipher.doFinal(data);
	    }

	    // 测试加密速度
	    public static void testEncrypt(String text, String algorithm, int bit) throws Exception {
	        Key key = keyGenerator(algorithm, bit);
	        long startTs = System.currentTimeMillis();

	        for (int i = 0; i < LOOP; i++) {
	        	encrypt(key, text, algorithm);
	        	if(i== LOOP-1){
	        		System.out.println(new String(Base64.getEncoder().encode(encrypt(key, text, algorithm))));
	        	}
	        }
	        long endTs = System.currentTimeMillis();
	        System.out.println(algorithm + " (" + bit + "位秘钥) 加密平均耗时 " + ((endTs - startTs) / (double) LOOP) + " ms");
	    }

	    public static void testDecrypt(String text, String algorithm, int bit) throws Exception {
	        Key key = keyGenerator(algorithm, bit);
	        long startTs = System.currentTimeMillis();

	        byte[] encrypted = encrypt(key, text, algorithm);

	        for (int i = 0; i < LOOP; i++) {
	            decrypt(key, encrypted, algorithm);
	            
	        }
	        long endTs = System.currentTimeMillis();
	        System.out.println(algorithm + " (" + bit + "位秘钥) 解密平均耗时 " + ((endTs - startTs) / (double) LOOP) + " ms");
	    }
	    /**
	     * 注意: 由于美国对软件出口的限制，默认情况下，使用上诉算法的秘钥不能找过128位，如果超过，<br/>
	     * 就会抛出“Java.security.InvalidKeyException: Illegal key size or default paramet” 异常。<br/>
	     *  Oracle在其官方网站上提供了无政策限制权限文件（Unlimited Strength Jurisdiction Policy Files)，需要手动下载<br/>
	     *  ，并体替换的掉 替换 <JDK安装目录>/jre/lib/security/ 下面的local_policy.jar和US_export_policy.jar 两个文件。 <br/>
	     *  java8 对应的下载地址为：http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html。<br/>
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String[] args) throws Exception {
	        String passwordText = "这是我的信用卡账号 5555 5555 5555 5555";

	        // DES 算法仅支持56位定长秘钥
	        testEncrypt(passwordText, ALGORITHM_DES, 56);
	        testDecrypt(passwordText, ALGORITHM_DES, 56);

	        // 3DES 算法仅支持112位和168位秘钥
	        testEncrypt(passwordText, ALGORITHM_3DES, 112);
	        testDecrypt(passwordText, ALGORITHM_3DES, 112);

	        testEncrypt(passwordText, ALGORITHM_3DES, 168);
	        testDecrypt(passwordText, ALGORITHM_3DES, 168);

	        // Blowfish 算法支持32 到 448位的变长秘钥
	        testEncrypt(passwordText, ALGORITHM_BLOWFISH, 32);
	        testDecrypt(passwordText, ALGORITHM_BLOWFISH, 32);

	       /* testEncrypt(passwordText, ALGORITHM_BLOWFISH, 256);
	        testDecrypt(passwordText, ALGORITHM_BLOWFISH, 256);

	        testEncrypt(passwordText, ALGORITHM_BLOWFISH, 448);
	        testDecrypt(passwordText, ALGORITHM_BLOWFISH, 448);*/

	        // AES 算法支持 128，192，256 三种定长秘钥
	        testEncrypt(passwordText, ALGORITHM_AES, 128);
	        testDecrypt(passwordText, ALGORITHM_AES, 128);

	        testEncrypt(passwordText, ALGORITHM_AES, 192);
	        testDecrypt(passwordText, ALGORITHM_AES, 192);

	        testEncrypt(passwordText, ALGORITHM_AES, 256);
	        testDecrypt(passwordText, ALGORITHM_AES, 256);

	    }
	    
}
