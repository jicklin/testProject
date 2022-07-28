package test.RSA;

import cn.hutool.crypto.asymmetric.Sign;
import com.google.common.primitives.Bytes;
import org.apache.commons.net.util.Base64;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author mal
 * @date 2021-11-15 15:52
 */
public class RSAUtil {

    public static String[] generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        return new String[]{publicKeyStr, privateKeyStr};

    }



    @Test
    public void testEncryptAndDecrypy() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String[] pair = generateRSAKeyPair();
        String publicKeyStr = pair[0];
        String privateKeyStr = pair[1];
        byte[] publicBytes = Base64.decodeBase64(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        byte[] privateBytes = Base64.decodeBase64(privateKeyStr);
        PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(privateBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(priSpec);

        String originStr = "马桂桂";
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(originStr.getBytes());
        System.out.println("加密后的字符串为：" + Base64.encodeBase64String(bytes));
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] afterBytes = cipher.doFinal(bytes);
        System.out.println("解密后的字符为：" + new String(afterBytes));

    }


    @Test
    public void testSign() throws Exception {
        String[] pair = generateRSAKeyPair();
        String publicKeyStr = pair[0];
        String privateKeyStr = pair[1];
        byte[] publicBytes = Base64.decodeBase64(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        byte[] privateBytes = Base64.decodeBase64(privateKeyStr);
        PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(privateBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(priSpec);

        String originStr = "马桂桂";
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey);
        signature.update(originStr.getBytes());
        byte[] bytes = signature.sign();
        System.out.println("签名后的字符串为：" + Base64.encodeBase64(bytes));
        signature.initVerify(publicKey);
        signature.update(originStr.getBytes());
        boolean verify = signature.verify(bytes);
        System.out.println("验证结果为：" + verify);
    }

    @Test
    public void testCsv() throws Exception {
        byte[] publicBytes = Files.readAllBytes(Paths.get("C:\\Users\\jia\\Desktop\\工商对接\\API秘钥\\qingdaoguoxinwenti.pub"));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initVerify(publicKey);
        signature.update(Files.readAllBytes(Paths.get("C:\\Users\\jia\\Desktop\\工商对接\\20211114_中国工商银行特约商户统一对账单明细清单_380352010017_一体化_程序.csv")));
        boolean verify = signature.verify(Files.readAllBytes(Paths.get("C:\\Users\\jia\\Desktop\\工商对接\\20211114_中国工商银行特约商户统一对账单明细清单_380352010017_一体化_程序.sign")));
        System.out.println(verify);




    }
}
