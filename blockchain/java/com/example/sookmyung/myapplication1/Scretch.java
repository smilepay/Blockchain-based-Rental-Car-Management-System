package com.example.sookmyung.myapplication1;

import java.util.Vector;


public class Scretch {

    private Vector<Pair> scretch_frontsc = new Vector<>();
    private Vector<Pair> scretch_backsc = new Vector<>();
    private Vector<Pair> scretch_rightsc = new Vector<>();
    private Vector<Pair> scretch_leftsc = new Vector<>();

    public Vector<Pair> getScretch_frontsc() {
        return scretch_frontsc;
    }

    public void setScretch_frontsc(Vector<Pair> scretch_front) {
        this.scretch_frontsc = scretch_front;
    }

    public Vector<Pair> getScretch_backsc() {
        return scretch_backsc;
    }

    public void setScretch_backsc(Vector<Pair> scretch_backsc) {
        this.scretch_backsc = scretch_backsc;
    }

    public Vector<Pair> getScretch_rightsc() {
        return scretch_rightsc;
    }

    public void setScretch_rightsc(Vector<Pair> scretch_rightsc) {
        this.scretch_rightsc = scretch_rightsc;
    }

    public Vector<Pair> getScretch_leftsc() {
        return scretch_leftsc;
    }

    public void setScretch_leftsc(Vector<Pair> scretch_leftsc) {
        this.scretch_leftsc = scretch_leftsc;
    }
}