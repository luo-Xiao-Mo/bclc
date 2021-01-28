package com.blockchain.service.impl;

import com.blockchain.api.service.CryptoService;

import java.nio.charset.StandardCharsets;
import java.security.*;

import org.apache.tomcat.util.buf.HexUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

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
import java.util.Arrays;
import java.util.Base64;

@RestController
public class CryptoServiceImpl implements CryptoService {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/encrypt")
    public String Encrypt(@RequestBody EncryptEntity encryptEntity) {
        encryptEntity.setData("hello world");
        String EncryptAESKey = null;

        try {
            byte[] key = AESUtil.initKey();
            byte[] iv = {0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF,
                    0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF};
            String EncryptData = AESUtil.encodeToBase64String(encryptEntity.getData(), key, iv);
            System.out.println("AES EncryptData:" + EncryptData);

            Security.addProvider(new BouncyCastleProvider());

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECIES", "BC");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // EncodedKeySpec publicKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(encryptEntity.getPublicKey()));
            PublicKey publicKey = keyPair.getPublic();
            Cipher encrypter = Cipher.getInstance("ECIES", "BC");
            encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
            EncryptAESKey = HexUtils.toHexString(encrypter.doFinal(encryptEntity.getData().getBytes(StandardCharsets.UTF_8)));
            System.out.println("encrypt aes key:" + EncryptAESKey);


            // String plain = AESUtil.decodeFromBase64String(cipher, key, iv);
            // System.out.println(plain);
        } catch (Exception e) {
            System.out.println("exceptionL" + e);
        }
        return EncryptAESKey;
    }

    @PostMapping("/decrypt")
    public String Decrypt(@RequestBody DecryptEntity user) {
        String result = null;
        try {
            DecryptEntity u = new DecryptEntity();
            // byte[] publicKeyBytes = Base64.getDecoder().decode(u.getPublicKey());
            byte[] encryptData = Base64.getDecoder().decode(u.getData());
            // EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            // KeyFactory keyFactory = KeyFactory.getInstance("EC");
            ECPrivateKey privateKey = null;

            // ECPublicKey publicKey = (ECPublicKey) keyFactory.generatePublic(publicKeySpec);
            // ECPublicKey ecpublicKey = (ECPublicKey) publicKey;
            // Cipher decrypter = Cipher.getInstance("ECIES", "BC");
            Cipher decrypter = Cipher.getInstance("ECIES", "BC");
            decrypter.init(Cipher.DECRYPT_MODE, privateKey);
            result = Arrays.toString(decrypter.doFinal(encryptData));
        } catch (Exception e) {

        }
        return result;
    }
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