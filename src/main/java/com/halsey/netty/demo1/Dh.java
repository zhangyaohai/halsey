package com.halsey.netty.demo1;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by zhangyaohai on 2017/7/25.
 */
public class Dh {

    public static void main(String[] args) throws Exception{
        String key = "YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4";
        String d = "sfslj";
        byte[] b = en(new BASE64Decoder().decodeBuffer(key), d.getBytes("UTF-8"));
        System.out.println(new BASE64Encoder().encode(b));
    }

    public static byte[] en(byte[] key, byte[] data) throws Exception{
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(key);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("desede");
        Key deskey = secretKeyFactory.generateSecret(deSedeKeySpec);
        Cipher desCipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, deskey);
        return  desCipher.doFinal(data);
    }

    public static byte[] de(byte[] key, byte[] data){
        Key deskey = null;
        return null;
    }
}
