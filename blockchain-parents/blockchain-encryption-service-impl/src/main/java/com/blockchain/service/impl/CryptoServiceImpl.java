package com.blockchain.service.impl;

import com.blockchain.api.service.CryptoService;

import java.nio.charset.StandardCharsets;
import java.security.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

import com.blockchain.api.service.entity.DecryptEntity;
import com.blockchain.api.service.entity.EncryptEntity;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.util.Base64;

@RestController
public class CryptoServiceImpl implements CryptoService {

    //特征向量
    private byte[] iv = {0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF,
            0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF};
    private static byte[] key;


    static {
        try {
            key = AESUtil.initKey();
        } catch (Exception e) {
            System.out.println("aes init exception:" + e);
        }
    }

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/encrypt")
    public String Encrypt(@RequestBody EncryptEntity encryptEntity) {
        // encryptEntity.setData("hello world");
        String EncryptAESKey = null;
        String EncryptData = null;

        try {
            //AES加密
            // byte[] key = AESUtil.initKey();

            EncryptData = AESUtil.encodeToBase64String(encryptEntity.getData(), key, iv);
            System.out.println("AES EncryptData:" + EncryptData);

            //ECC加密
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECIES", "BC");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // EncodedKeySpec publicKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(encryptEntity.getPublicKey()));
            PublicKey publicKey = keyPair.getPublic();
            Cipher encrypter = Cipher.getInstance("ECIES", "BC");
            encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
            EncryptAESKey = Base64.getEncoder().encodeToString(encrypter.doFinal(encryptEntity.getData().getBytes(StandardCharsets.UTF_8)));
            System.out.println("encrypt aes key:" + EncryptAESKey);


            // String plain = AESUtil.decodeFromBase64String(cipher, key, iv);
            // System.out.println(plain);
        } catch (Exception e) {
            System.out.println("exception" + e);
        }
        return EncryptData;
    }

    @PostMapping("/decrypt")
    public String Decrypt(@RequestBody DecryptEntity d) {
        String result = "";
        try {
            DecryptEntity u = new DecryptEntity();
            // byte[] publicKeyBytes = Base64.getDecoder().decode(u.getPublicKey());
            byte[] encryptData = Base64.getDecoder().decode(u.getEncryptData());
            // EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            // KeyFactory keyFactory = KeyFactory.getInstance("EC");
            // ECC解密
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECIES", "BC");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            // ECPublicKey publicKey = (ECPublicKey) keyFactory.generatePublic(publicKeySpec);
            // ECPublicKey ecpublicKey = (ECPublicKey) publicKey;
            // Cipher decrypter = Cipher.getInstance("ECIES", "BC");
            Cipher decrypter = Cipher.getInstance("ECIES", "BC");
            decrypter.init(Cipher.DECRYPT_MODE, privateKey);
            // DecryptAESKey = decrypter.doFinal(encryptData);
            result = AESUtil.decodeFromBase64String(d.getEncryptData(), key, iv);
        } catch (Exception e) {
            System.out.println("exception:" + e);
        }
        return result;
    }

    //从私钥生成公钥。备用。
    public String getPublicKeyFromPrivateKey(ECPrivateKey privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");
            ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256k1");

            ECPoint Q = ecSpec.getG().multiply(privateKey.getD());

            ECPublicKeySpec pubSpec = new ECPublicKeySpec(Q, ecSpec);
            PublicKey publicKeyGenerated = keyFactory.generatePublic(pubSpec);

        } catch (Exception e) {
        }
        return "";
    }
}