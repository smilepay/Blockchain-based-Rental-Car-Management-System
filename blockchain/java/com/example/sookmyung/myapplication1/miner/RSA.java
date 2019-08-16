package com.example.sookmyung.myapplication1.miner;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class RSA {
    public static KeyPair Keygenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.genKeyPair();
        return keyPair;

    }
    public static byte[] Signature(KeyPair keypair,String previous_hash) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        byte[] data = previous_hash.getBytes();

        Signature sig = Signature.getInstance("MD5WithRSA");
        sig.initSign(keypair.getPrivate());
        sig.update(data);
        byte[] signatureBytes = sig.sign();
        return signatureBytes;
        //System.out.println("Singature:" + new Base64Encoder().encode(signatureBytes));

    }
    public static PublicKey getpublickey(KeyPair keypair) {
        PublicKey publickey = keypair.getPublic();
        return publickey;
    }
    public static Boolean Verify(PublicKey publickey,byte[] signatureBytes,String previous_hash) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance("MD5WithRSA");
        byte[] data = previous_hash.getBytes();
        sig.initVerify(publickey);
        sig.update(data);

        return sig.verify(signatureBytes);
    }
}