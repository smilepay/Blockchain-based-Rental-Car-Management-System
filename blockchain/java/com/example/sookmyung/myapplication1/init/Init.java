package com.example.sookmyung.myapplication1.init;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.miner.Miner;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.block.BlockData;
import com.example.sookmyung.myapplication1.Pair;
import java.util.Vector;

public class Init {

    public static void defectstore (String name, Vector<Pair> scretch_fronts_init, Vector<Pair> scretch_backs_init, Vector<Pair> scretch_rights_init, Vector<Pair> scretch_lefts_init,String battery,String tire,String plug,String breaks,String motor,int oil_quantity,String add)throws NoSuchAlgorithmException, DigestException, InvalidKeyException, UnsupportedEncodingException, SignatureException {
        BlockData data = new BlockData(name, scretch_fronts_init,scretch_backs_init,scretch_rights_init,scretch_lefts_init,battery,tire,plug,breaks,motor,oil_quantity,add);
        Block block = Miner.generateNewBlock(data,data.getName(),scretch_fronts_init,scretch_backs_init,scretch_rights_init,scretch_lefts_init,battery,tire,plug,breaks,motor,oil_quantity,add);
        if (Miner.isNewBlockValid(block)) {
            Blockchain.pushNewBlock(block);
        }
    }
}

