package test;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mal
 * @date 2021-09-23 17:12
 */
public class RSAUtil {

    private static final int DEFAULT_RSA_KEY_SIZE = 1024;

    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 生成RSA 公私钥,可选长度为1025,2048位.
     */
    public static Map<String,String> generateRsaKey(int keySize) {
        Map<String,String> result = new HashMap<>(2);
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            // 初始化密钥对生成器，密钥大小为1024 2048位
            keyPairGen.initialize(keySize, new SecureRandom());
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 得到公钥字符串
            result.put("publicKey", new String(Base64.encodeBase64(keyPair.getPublic().getEncoded())));
            // 得到私钥字符串
            result.put("privateKey", new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded())));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static KeyPair generateKeyPair(int keySize) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
        keyPairGen.initialize(keySize, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        return keyPair;
    }

    public static RSAPublicKey generateRSAPublicKey(BigInteger modulus, BigInteger publicExponent) throws Exception {
        KeyFactory keyFac = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        return (RSAPublicKey)keyFac.generatePublic(pubKeySpec);
    }

    public static RSAPrivateKey generateRSAPrivateKey(BigInteger modulus, BigInteger privateExponent) throws Exception {
        KeyFactory keyFac = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);
        return (RSAPrivateKey)keyFac.generatePrivate(priKeySpec);
    }

    public static byte[] sign(byte[] bytes, PrivateKey prikey) throws Exception {
        Signature signet = Signature.getInstance("MD5withRSA", new BouncyCastleProvider());
        signet.initSign(prikey, new SecureRandom());
        signet.update(bytes);
        return signet.sign();
    }

    public static boolean verify(byte[] bytes, byte[] signbytes, PublicKey pubkey) throws Exception {
        //Signature signet = Signature.getInstance("MD5withRSA", new BouncyCastleProvider());
        Signature signet = Signature.getInstance("SHA256withRSA", new BouncyCastleProvider());
        signet.initVerify(pubkey);
        signet.update(bytes);
        return signet.verify(signbytes);
    }

    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            String hex = Integer.toHexString(b[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    /**
     * 根据公钥字符串加载公钥
     *
     * @param publicKeyStr 公钥字符串
     * @return
     * @throws Exception
     */
    public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
        byte[] decoded = Base64.decodeBase64(publicKeyStr);

        return  (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));

    }


    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> stringStringMap = generateRsaKey(DEFAULT_RSA_KEY_SIZE);
        String  str = "马琳";
        String encryptStr = encrypt(str, stringStringMap.get("publicKey"));
        System.out.println(encryptStr);
        String decryptStr = decrypt(encryptStr, stringStringMap.get("privateKey"));
        System.out.println(decryptStr);

    }


}
