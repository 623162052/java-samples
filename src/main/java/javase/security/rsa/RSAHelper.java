package javase.security.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSAHelper {

	/**
	 * 得到公钥
	 *
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * 得到私钥
	 *
	 * @param key
	 *            密钥字符串（经过base64编码）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = (new BASE64Decoder()).decodeBuffer(key);

		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * 得到密钥字符串（经过base64编码）
	 *
	 * @return
	 */
	public static String getKeyString(Key key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		String s = (new BASE64Encoder()).encode(keyBytes);
		return s;
	}


	/**
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void generateKeys() throws Exception {
		long startTime = System.currentTimeMillis();

		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		// 密钥位数
		keyPairGen.initialize(1024);
		// 密钥对
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// 私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		System.out.println(publicKey.getModulus().toString());
		System.out.println(publicKey.getPublicExponent().toString());
		System.out.println(privateKey.getModulus().toString());
		System.out.println(privateKey.getPrivateExponent().toString());

		long endTime = System.currentTimeMillis();
		System.out.println("time: " + (endTime - startTime));
	}

	public static void main(String[] args) throws Exception {
		RSAHelper.generateKeys();



//		// 加解密类
//		Cipher cipher = Cipher.getInstance("RSA");// Cipher.getInstance("RSA/ECB/PKCS1Padding");
//
//		// 明文
//		byte[] plainText = "我们都很好！邮件：@sina.com".getBytes();
//
//		// 加密
//		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//		byte[] enBytes = cipher.doFinal(plainText);
//		System.out.println("enBytes" + enBytes.toString());
//
//		// 解密
//		cipher.init(Cipher.DECRYPT_MODE, privateKey);
//		byte[] deBytes = cipher.doFinal(enBytes);
//		System.out.println(new String(deBytes));

	}

}
