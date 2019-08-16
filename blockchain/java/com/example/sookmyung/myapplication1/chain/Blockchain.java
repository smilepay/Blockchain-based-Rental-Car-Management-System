package com.example.sookmyung.myapplication1.chain;


import java.util.Vector;

import com.example.sookmyung.myapplication1.block.Block;




public class Blockchain {


    public static Vector<Block> blockchain;


    public static Block getLatestBlock() {
        return blockchain.lastElement();
    }
    public static Block getIndexBlock(int index){return blockchain.elementAt(index);}


    public static void pushNewBlock(Block new_block) {
        blockchain.addElement(new_block);
    }

}