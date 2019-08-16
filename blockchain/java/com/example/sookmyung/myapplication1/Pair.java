package com.example.sookmyung.myapplication1;

public class Pair {
    private int source_x;
    private int source_y;
    private int destination_x;
    private int destination_y;


    public Pair(int source_x, int source_y, int destination_x, int destination_y) {
        this.source_x = (int) source_x;
        this.source_y = (int) source_y;
        this.destination_x = (int) destination_x;
        this.destination_y = (int) destination_y;
    }

    public int getSource_x() {
        return source_x;
    }

    public void setSource_x(int source_x) {
        this.source_x = source_x;
    }
    public int getSource_y() {
        return source_y;
    }

    public void setSource_y(int source_y) {
        this.source_y = source_y;
    }
    public int getDestination_x() {
        return destination_x;
    }

    public void setDestination_x(int destination_x) {
        this.destination_x = destination_x;
    }
    public int getDestination_y() {
        return destination_y;
    }

    public void setDestination_y(int destination_y) {
        this.destination_y = destination_y;
    }

}