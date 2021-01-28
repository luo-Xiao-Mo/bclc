package com.blockchain.service.impl;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class AESUtil {
    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";

            public static byte[] initKey() throws Exception {
                KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
                kg.init(128);
                SecretKey secretKey = kg.generateKey();
                return secretKey.getEncoded();
            }

            public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
                Key k = new SecretKeySpec(key, KEY_ALGORITHM);
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
                cipher.init(Cipher.ENCRYPT_MODE, k, paramSpec);
                return cipher.doFinal(data);
            }

            public static byte[] decrypt(byte[] bytes, byte[] key, byte[] iv) throws Exception {
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
                Key k = new SecretKeySpec(key, KEY_ALGORITHM);
                AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
                cipher.init(Cipher.DECRYPT_MODE, k, paramSpec);
                return cipher.doFinal(bytes);
            }

            public static String encodeToBase64String(String data, byte[] key, byte[] iv) throws Exception {
                return Base64.getEncoder().encodeToString(encrypt(data.getBytes(), key, iv));
            }

            public static String decodeFromBase64String(String data, byte[] key, byte[] iv) throws Exception {
                byte[] bytes = Base64.getDecoder().decode(data);
                return new String(decrypt(bytes, key, iv));
            }
}
