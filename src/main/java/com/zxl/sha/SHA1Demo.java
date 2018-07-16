/**
 * 
 */
package com.zxl.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

/**
 * @author 胥方雁
 * @data 2018年5月8日 下午5:27:55
 */
public class SHA1Demo {
	public static void main(String[] args) {
		String msg = "hello java";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(msg.getBytes());
			String encoded = Base64.getEncoder().encodeToString(md.digest());
			System.out.println(encoded);
			
			System.out.println(bytesToHexFun3(md.digest()));
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }
}
