package test;

import cn.hutool.core.util.ArrayUtil;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class AESUtil {
    /**
     * 偏移量，CBC模式需要
     * 与其他语言平台使用的需一致才能通用加解密
     */
    private static final String IV = "0000000000000000";

    public static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws Exception {


        //language=JSON
        //String json = "[{\"userCrowdId\":442369,\"crowdId\":108129,\"crowdName\":\"测试121\",\"userId\":429037816,\"tagList\":[{\"tagId\":100074,\"tagName\":\"女\",\"firstClassName\":3},{\"tagId\":100077,\"tagName\":\"25-36岁\",\"firstClassName\":3},{\"tagId\":103940,\"tagName\":\"安卓\",\"firstClassName\":3}],\"peopleNum\":174,\"optType\":\"1\",\"companyCode\":\"56920153\"}]\n";
        //System.out.println(com.suning.aps.toolscommon.util.AESUtil.encrypt(json, "SDSPAESSNAP36102"));
        String key = "UBmCt8sJzEXBJKpt0F5C0POrMMrbaCQx";
        String input = "apckvM3mqLEeFF9qGhXHR/1MPpI8gi58aZA+KpumHPRIAYSBaSuIGM6iWCagZSoPRi39aEFUPOoEI5WdQXmPSJ2KdiO8+h47CNn3n++fQrPYephr/pucl2PARtiOcDeoqHaolgzgwMCjnPYCSIGVlfE3yrSz8CNwMv0JuO4OmTvCwROlCH2LiDn9D6R2GFEovgapyzwLqp/za4SyF84Ulun0hkN8wSAJuZnpdkGcekQ=";

        byte[] bytes = Base64.decodeBase64(input);
        Security.addProvider(new BouncyCastleProvider());

        SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        IvParameterSpec iv = new IvParameterSpec(bytes,0,16);
        cipher.init(Cipher.DECRYPT_MODE, skey, iv);

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu6gQV44C65NrdmeqJVAw" +
                "GPPd7+8JyE6brZlHsNtsbE+P9yJOaz68KbLcygmf67abtASEHWAGre1ju32t2+NY" +
                "rkaMu5DUyJ7ROJJpmUkv1D1y7GhuIfANvnTr8/a29AFwx2HZZvuoOi9mGq6iNi/H" +
                "+PoFTGbmTyatl+D10rFCCM2oHiS/8mC+2xfCGm6pmKaVocekVUOOQYHHGNO3OpeU" +
                "s+Cn0cukhuNt03iWsZ5KOx9qy7QbletNoriymi3NI9Gb/6mfx7k+d0sJMg8aLz/F" +
                "GSBOp0JSyAmjjSdO85Jhe1PCiOMwMBJgMi1711RFz09LrOZZxdEoyCVddWg/ynzP" +
                "mQIDAQAB";

        String sign = "kzh/xptOlrRlF5bkxt322JtQzeeTn3rHElyLf3IWCzUsa6m2Y7iBAGbuev+P/g6UJw7GUoZm1hiAoItRLlZMKUFB5sHIP9Th90fnX9scZMKZLjwwKNRMa3R/Q9OcuK623put30leW6KSF10m+9u00JNjpN/yKyABT6nGIQCK1qUmJHK5r4wenF3wo+ELvWsIhZytpfFs9ALt9JKFXYsrOgggN4lLt/omNB60H71OuR+6itMYqk8KTUNYrFA7dOvvhJouG6maHr9ShGZQegQN6fpQouDdz+hnD8WCqSPmS3gtrxGBfQ2+OpOvl4mwFMHmEkUVSplmPnP4lBJrcdDxXg==";


        System.out.println(RSAUtil.verify(cipher.doFinal(ArrayUtil.sub(bytes, 16, bytes.length)), Base64.decodeBase64(sign), RSAUtil.loadPublicKey(publicKey)));


    }
}
