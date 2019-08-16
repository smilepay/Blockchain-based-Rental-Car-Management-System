package com.example.sookmyung.myapplication1.block;
import com.example.sookmyung.myapplication1.Pair;
import com.example.sookmyung.myapplication1.chain.Blockchain;

import java.util.Vector;


public class BlockData {

    private String name;
    public static Vector<Pair> scretch_frontbd;
    public static Vector<Pair> scretch_backbd;
    public static Vector<Pair> scretch_rightbd;
    public static Vector<Pair> scretch_leftbd;
    public String battery, tire, plug, breaks, motor;
    public int oil_quantity;
    public String add;

    public BlockData(String name, Vector<Pair> scretch_frontbd,Vector<Pair> scretch_backbd,Vector<Pair> scretch_rightbd,Vector<Pair> scretch_leftbd,String battery,String tire,String plug, String breaks,String motor,int oil_quantity,String add) {
        this.name = name;
        this.scretch_frontbd = scretch_frontbd;
        this.scretch_backbd = scretch_backbd;
        this.scretch_rightbd = scretch_rightbd;
        this.scretch_leftbd = scretch_leftbd;
        this.battery=battery;
        this.tire=tire;
        this.plug=plug;
        this.breaks=breaks;
        this.motor=motor;
        this.oil_quantity=oil_quantity;
        this.add=add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Pair> getScretch_frontbd() {
        return scretch_frontbd;
    }

    public void setScretch_frontbd(Vector<Pair> scretch_frontbd) {
        BlockData.scretch_frontbd = scretch_frontbd;
    }

    public Vector<Pair> getScretch_backbd() {
        return scretch_backbd;
    }

    public void setScretch_backbd(Vector<Pair> scretch_backbd) {
        BlockData.scretch_backbd = scretch_backbd;
    }
    public Vector<Pair> getScretch_rightbd() {
        return scretch_rightbd;
    }

    public void setScretch_rightbd(Vector<Pair> scretch_rightbd) {
        BlockData.scretch_rightbd = scretch_rightbd;
    }
    public Vector<Pair> getScretch_leftbd() {
        return scretch_leftbd;
    }

    public void setScretch_leftbd(Vector<Pair> scretch_leftbd) {
        BlockData.scretch_leftbd = scretch_leftbd;
    }

    public String  getBattery() { return battery; }

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


    @Override
    public String toString() {
        return name + "n" + scretch_frontbd + " " + scretch_backbd + " " + scretch_rightbd + " " + scretch_leftbd;
    }
}