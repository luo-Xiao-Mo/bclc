package com.blockchain.service.impl;

import com.blockchain.api.service.CryptoService;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import com.blockchain.api.service.entity.DecryptEntity;
import com.blockchain.api.service.entity.EncryptEntity;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

@RestController
public class CryptoServiceImpl implements CryptoService {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/encrypt")
    public String Encrypt(@RequestBody EncryptEntity encryptEntity) {
        String EncryptAESKey = null;

        try {
            byte[] key = AESUtil.initKey();
            byte[] iv = {0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF,
                    0x01, 0x23, 0x45, 0x67, 0x89 - 0xFF, 0xAB - 0xFF, 0xCD - 0xFF, 0xEF - 0xFF};
            String content = encryptEntity.getEncryptData();
            String EncryptData = AESUtil.encodeToBase64String(content, key, iv);

            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            EncodedKeySpec publicKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(encryptEntity.getPublicKey()));
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            Cipher encrypter = Cipher.getInstance("ECIES", "BC");
            encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
            EncryptAESKey = Arrays.toString(encrypter.doFinal(encryptEntity.getEncryptData().getBytes(StandardCharsets.UTF_8)));


            // String plain = AESUtil.decodeFromBase64String(cipher, key, iv);
            // System.out.println(plain);
        } catch (Exception e) {

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
            // <E8><BF><99><E9><87><8C> <E7><A7><81><E9><92><A5><E8><A6><81><E8><87><AA><E5><B7><B1><E4><BF><9D><E5><AD><98><E5><A5><BD>
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
}