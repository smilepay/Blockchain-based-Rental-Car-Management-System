package com.example.sookmyung.myapplication1.extra_check;

public class Check_defect {
    public int battery=0;
    public int tire=0;
    public int plug=0;
    public int oil=0;
    public int motor=0;
    public int oil_quantity=0;
    public String add;

    public int getBattery() { return battery; }

    public void setBattery(int battery) {
        this.battery=battery;

    }

    public int getTire() { return tire; }

    public void setTire(int tire) {
        this.tire = tire;
    }

    public int getPlug() { return plug; }

    public void setPlug(int plug) {
        this.plug =plug;
    }

    public int getOil() { return oil; }

    public void setOil(int oil) {
        this.oil =oil;
    }

    public int getMotor() { return motor; }

    public void setMotor(int motor) {
        this.motor =motor;
    }

    public int getOil_quantity() { return oil_quantity; }

    public void setOil_quantity(int oil_quantity) {
        this.oil_quantity =oil_quantity;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

}

