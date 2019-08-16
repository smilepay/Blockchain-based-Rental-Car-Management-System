package com.example.sookmyung.myapplication1.block;

import com.example.sookmyung.myapplication1.Pair;
import java.security.KeyPair;
import java.util.Vector;



public class Block {
    private String hash;
    private BlockData transaction;
    private String previous_hash;
    private int index;
    byte[] signature;
    KeyPair keypair;
    private String name;
    private  Vector<Pair> scretch_frontb;
    private  Vector<Pair> scretch_backb;
    private  Vector<Pair> scretch_rightb;
    private  Vector<Pair> scretch_leftb;
    public String battery, tire, plug, breaks, motor;
    public int oil_quantity;
    public String add;


    public Block(String hash,BlockData transaction,String previous_hash,int index,byte[] signature,KeyPair keypair,String name,Vector<Pair> scretch_frontb,Vector<Pair> scretch_backb,Vector<Pair> scretch_rightb,Vector<Pair> scretch_leftb,String battery,String tire,String plug, String breaks,String motor,int oil_quantity,String add){
        this.hash=hash;
        this.transaction = transaction;
        this.previous_hash = previous_hash;
        this.index = index;
        this.signature = signature;
        this.keypair = keypair;
        this.name = name;
        this.scretch_frontb = scretch_frontb;
        this.scretch_backb= scretch_backb;
        this.scretch_rightb = scretch_rightb;
        this.scretch_leftb = scretch_leftb;
        this.battery=battery;
        this.tire=tire;
        this.plug=plug;
        this.breaks=breaks;
        this.motor=motor;
        this.oil_quantity=oil_quantity;
        this.add=add;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public BlockData getTransaction() {
        return transaction;
    }

    public void setTransaction(BlockData transaction) {
        this.transaction = transaction;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public KeyPair getKeypair() {
        return keypair;
    }

    public void setKeypair(KeyPair keypair) {
        this.keypair = keypair;
    }

    public byte[] getSignature() {
        return signature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Pair> getScretch_frontb() {
        return scretch_frontb;
    }

    public void setScretch_front(Vector<Pair> scretch_frontb) {
        BlockData.scretch_frontbd = scretch_frontb;
    }
    public void setScretch_front_defect(Vector<Pair> scretch_frontb) {
        BlockData.scretch_frontbd = scretch_frontb;
    }
    public Vector<Pair> getScretch_backb() {
        return scretch_backb;
    }

    public void setScretch_back(Vector<Pair> scretch_backb) {
        BlockData.scretch_backbd = scretch_backb;
    }
    public Vector<Pair> getScretch_rightb() {
        return scretch_rightb;
    }

    public void setScretch_right(Vector<Pair> scretch_right) {
        BlockData.scretch_rightbd = scretch_right;
    }
    public Vector<Pair> getScretch_leftb() {
        return scretch_leftb;
    }

    public void setScretch_left(Vector<Pair> scretch_leftb) {
        BlockData.scretch_leftbd = scretch_leftb;
    }
    public String getBattery() {

        return battery;
    }



    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getTire() { return tire; }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public String getPlug() { return plug; }

    public void setPlug(String plug) {
        this.plug =plug;
    }

    public String getbreaks() { return breaks; }

    public void setbreaks(String breaks) {
        this.breaks =breaks;
    }

    public String getMotor() { return motor; }

    public void setMotor(String motor) {
        this.motor =motor;
    }

    public int getOil_quantity() { return oil_quantity; }

    public void setOil_quantity(int oil_quantity) {
        this.oil_quantity =oil_quantity;
    }

    public String getadd() {
        return add;
    }

    public void setadd(String add) {
        this.add = add;
    }


}