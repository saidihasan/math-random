package com.skripsi.saidi.gamematematika;

import com.skripsi.saidi.gamematematika.controller.GameController;

public class Common extends GameController {



    // TODO Make variable usable till 20, and sending data to firebase
    private int s, score;
    private String namaPlayer,UID;

    public Common(String namaPlayer, String UID){
        this.namaPlayer = namaPlayer;
        this.UID = UID;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNamaPlayer() {
        return namaPlayer;
    }

    public void setNamaPlayer(String namaPlayer) {
        this.namaPlayer = namaPlayer;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
