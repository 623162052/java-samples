package javase.security.rsa;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;


/**
 * RSA加密
 */
public class RsaKey {


	private static final String CHARACTER_SET = "GBK";
	private static String modulus = "137560607684744418594461027970974166960283322627474165838152366604371620559937601819955399199401505698214645213368244638008132065628275945723199372874427780520492398153240368289434985244141069950938853133658392572892863799167909902821404812081234659045718569723975253313090172828171529612267985097656954235171";
	private static String publicExponent = "65537";
	private static String privateExponet = "73663572130187609603317359303009573057526942148880874164059345194018982003311261361846510137830475036679173196257969476340012433331161699729247325801120620822511754041092454784376251951537362918627549382405607102689588799180308176148241497639547670400409401385639061553804791434387479354074308229418736918193";

	/**
	 * 获取公钥
	 */
	public static PublicKey getPublicKey(String modulus, String publicExponent) throws Exception {
		BigInteger m = new BigInteger(modulus);
		BigInteger e = new BigInteger(publicExponent);
		RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * 获取私钥
	 */
	public static PrivateKey getPrivateKey(String modulus, String privateExponent) throws Exception {
		BigInteger m = new BigInteger(modulus);
		BigInteger e = new BigInteger(privateExponent);
		RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}


	/**
	 * 获得加密串
	 */
	public static byte[] getEncrtpy(String plainText) throws Exception{
		PublicKey publicKey = RsaKey.getPublicKey(modulus, publicExponent);

		// 加解密类
		Cipher cipher = Cipher.getInstance("RSA");

		// 加密
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] enBytes = cipher.doFinal(plainText.getBytes(RsaKey.CHARACTER_SET));
		return enBytes;
	}

	/**
	 * 获得解密串
	 */
	public static byte[] getDecrypt(byte[] encrtpyText) throws Exception{
		PrivateKey privateKey = RsaKey.getPrivateKey(modulus, privateExponet);

		// 加解密类
		Cipher cipher = Cipher.getInstance("RSA");

		// 解密
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] deBytes = cipher.doFinal(encrtpyText);//encrtpyText.getBytes());
		return deBytes;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) throws Exception {
		String plainText = "我们都很好！邮件：@sina.com";
		System.out.println("明文： " + plainText);

		byte[] encrtpyByte = RsaKey.getEncrtpy(plainText);
		String encrtpyText = new String(encrtpyByte);
		System.out.println("加密后： " + encrtpyText);
		System.out.println("encrtpyByte: " + encrtpyByte);
		System.out.println("encrtpyByte: " + encrtpyText.getBytes(RsaKey.CHARACTER_SET));

		byte[] decryptByte = RsaKey.getDecrypt(encrtpyByte);
		String decryptText = new String(decryptByte);
		System.out.println("解密后： " + decryptText);
	}

}
