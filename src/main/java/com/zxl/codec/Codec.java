/**
 * 
 */
package com.zxl.codec;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.weaver.NewConstructorTypeMunger;

/**
 * @author 胥方雁
 * @data 2018年5月9日 下午3:42:51
 */
public class Codec {
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String passwordText = "这个";
		String encoderString = Base64.encodeBase64String(passwordText.getBytes());
		System.out.println(encoderString);
		System.out.println("MD5 编码后：" + DigestUtils.md5Hex(passwordText));
		System.out.println(DigestUtils.md5Hex(passwordText));

		System.out.println(Hex.encodeHex(passwordText.getBytes()));
		// 6L+Z5piv5oiR55qE5L+h55So5Y2h6LSm5Y+3IDU1NTUgNTU1NSA1NTU1IDU1NTU1
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 计算md5函数
		md.update(passwordText.getBytes());
		byte[] bs = md.digest();
		System.out.println(bytesToHexFun3(bs));
		System.out.println(bytesToHex(bs));
		System.out.println(bytesToHexFun2(bs));
	}

	/**
	 * 方法三： byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun3(byte[] bytes) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			StringBuilder buf = new StringBuilder(bytes.length * 2);
			for (byte b : bytes) { // 使用String的format方法进行转换
				buf.append(String.format("%02x", new Integer(b & 0xff)));
			}
		}
		System.out.println("bytesToHexFun3:用时" + (System.currentTimeMillis() - time) / 100.0);
		return "";// buf.toString();
	}

	public static String bytesToHex(byte[] bytes) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String hexTab = "0123456789abcdef";
			StringBuilder buf = new StringBuilder(bytes.length * 2);
			byte x = 0;
			for (byte b : bytes) {
				buf.append(hexTab.charAt((b >>> 4) & 0xf)).append(hexTab.charAt(b & 0xf));
			}
		}
		System.out.println("bytesToHex:用时" + (System.currentTimeMillis() - time) / 100.0);
		return "";// buf.toString();

	}

	/**
	 * 方法二： byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun2(byte[] bytes) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			char[] buf = new char[bytes.length * 2];
			int index = 0;
			for (byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
				buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
				buf[index++] = HEX_CHAR[b & 0xf];
			}
		}
		System.out.println("bytesToHexFun2:用时" + (System.currentTimeMillis() - time) / 100.0);

		return "";// new String(buf);
	}
}
