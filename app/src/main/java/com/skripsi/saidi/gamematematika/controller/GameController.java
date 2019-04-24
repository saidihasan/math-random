package com.skripsi.saidi.gamematematika.controller;

import com.skripsi.saidi.gamematematika.NameListener;

public class GameController {
    public static int soal = 1, score;
    public int[] soalArray = new int[20];
    NameListener listener;
//
//    public GameController(int soal, int score){
//        this.soal = soal;
//        this.score = score;
//    }

//    public GameController(NameListener nl, int score){
//        this.listener = nl;
//        this.soal = 1;
//        this.score = score;
//    }

    public int getSoal() {
        return soal;
    }

    public void setSoal(int soal) {
        this.soal = soal;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
