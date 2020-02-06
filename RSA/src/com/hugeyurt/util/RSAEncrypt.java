package com.hugeyurt.util;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {

    public static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //鐢ㄤ簬灏佽闅忔満浜х敓鐨勫叕閽ヤ笌绉侀挜
  
    static{
    	try{
    	 genKeyPair();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) throws Exception {
       
        //生成秘钥对
       
        String message = "123456";
        System.out.println("公钥:" + keyMap.get(0));
        System.out.println("私钥:" + keyMap.get(1));
        String messageEn = encrypt(message,keyMap.get(0));
        System.out.println("密文:" + messageEn);
        String messageDe = decrypt(messageEn,keyMap.get(1));
        System.out.println("解密之后:" + messageDe);
    }

    /**
     * 生成秘钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
       
        keyPairGen.initialize(1024,new SecureRandom());
      
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
    
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
      
        keyMap.put(0,publicKeyString);  
        keyMap.put(1,privateKeyString);  
    }
    /**

     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        
        byte[] decoded = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA鍔犲瘑
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String result=Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return result;
    }
  
 
     
    public static String decrypt(String str, String privateKey){
    	 String outStr="";
    	try{
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64缂栫爜鐨勭閽�
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
    
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
       // outStr = new String(cipher.);
         outStr = new String(cipher.doFinal(inputByte));
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        return outStr;
    }

}


