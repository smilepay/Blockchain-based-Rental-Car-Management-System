package com.example.sookmyung.myapplication1.miner;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Vector;


import com.example.sookmyung.myapplication1.Pair;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.block.*;

public class Miner {

    public static Block generateNewBlock(BlockData data, String name, Vector<Pair> scretch_front, Vector<Pair> scretch_back, Vector<Pair> scretch_right, Vector<Pair> scretch_left,String battery,String tire, String plug, String breaks, String motor, int oil_quantity, String add) throws NoSuchAlgorithmException, DigestException, InvalidKeyException, UnsupportedEncodingException, SignatureException {

        Block previous_block = Blockchain.getLatestBlock();
        int index = previous_block.getIndex() + 1;
        String previous_hash = previous_block.getHash();
        BlockData transaction = data;
        String hash = BlockUtil.wrapBlockContent(transaction,previous_hash);
        KeyPair keypair= RSA.Keygenerator();
        byte[] signature = RSA.Signature(keypair,hash);

        return new Block(hash, transaction,previous_hash,index,signature,keypair,name,scretch_front,scretch_back,scretch_right,scretch_left,battery,tire,plug,breaks,motor,oil_quantity,add);
    }

    public static boolean isNewBlockValid(Block new_block) throws NoSuchAlgorithmException, DigestException, InvalidKeyException, UnsupportedEncodingException, SignatureException {

        boolean is_valid = true;
        Block previous_block = Blockchain.getLatestBlock();
        KeyPair keyPair = null ;

        if (!previous_block.getHash().equals(new_block.getPrevious_hash()))
            is_valid = false;

        else {
            keyPair = previous_block.getKeypair();
            PublicKey publickey = RSA.getpublickey(keyPair);
            byte[] signatureBytes = previous_block.getSignature();
            String previous_hash = previous_block.getHash();
            is_valid = RSA.Verify(publickey, signatureBytes, previous_hash);
        }
        return is_valid;
    }
}