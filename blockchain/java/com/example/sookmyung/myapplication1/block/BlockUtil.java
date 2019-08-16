package com.example.sookmyung.myapplication1.block;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import com.example.sookmyung.myapplication1.encript.SHA256;
import com.example.sookmyung.myapplication1.miner.RSA;
import com.example.sookmyung.myapplication1.Pair;
import java.util.Vector;


public class BlockUtil {

    public static Block generateGenesisBlock() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        int index = 0;
        String battery="0";
        String tire="0";
        String plug="0";
        String breaks="0";
        String motor="0";
        int oil_quantity=0;
        String add="0";
        String previous_hash = "0";
        String hash = "0";
        Pair pair = new Pair(0,0,0,0);
        Vector<Pair> scretch_fronts = new Vector<>();
        Vector<Pair> scretch_backs = new Vector<>();
        Vector<Pair> scretch_rights = new Vector<>();
        Vector<Pair> scretch_lefts = new Vector<>();
        scretch_fronts.add(pair);
        scretch_backs.add(pair);
        scretch_rights.add(pair);
        scretch_lefts.add(pair);

        String name ="ayoung";
        BlockData transaction = new BlockData(name,scretch_fronts,scretch_backs,scretch_rights,scretch_lefts,battery,tire,plug,breaks,motor,oil_quantity,add);
        KeyPair keypair= RSA.Keygenerator();
        byte[] signature = RSA.Signature(keypair,hash);

        return new Block(hash, transaction, previous_hash,index,signature,keypair,name,scretch_fronts,scretch_backs,scretch_rights,scretch_lefts,battery,tire,plug,breaks,motor,oil_quantity,add);
    }

    public static String wrapBlockContent(BlockData transaction, String previous_hash)
            throws NoSuchAlgorithmException {

        String content = transaction.toString() + previous_hash;
        return SHA256.toSha256(content);
    }
}