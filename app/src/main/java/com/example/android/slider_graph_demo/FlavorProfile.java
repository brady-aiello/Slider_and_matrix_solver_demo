package com.example.android.slider_graph_demo;

/**
 * Created by Brady on 11/3/2016.
 */

public class FlavorProfile {
    private int earthy, aciditic, fruity, nutty, oxidized;

    public FlavorProfile(int aciditic, int earthy, int fruity, int nutty, int oxidized) {
        this.aciditic = aciditic;
        this.earthy = earthy;
        this.fruity = fruity;
        this.nutty = nutty;
        this.oxidized = oxidized;
    }

    public void setAciditic(int aciditic) {
        this.aciditic = aciditic;
    }

    public void setEarthy(int earthy) {
        this.earthy = earthy;
    }

    public void setFruity(int fruity) {
        this.fruity = fruity;
    }

    public void setNutty(int nutty) {
        this.nutty = nutty;
    }

    public void setOxidized(int oxidized) {
        this.oxidized = oxidized;
    }

    public int getAciditic() {
        return aciditic;
    }

    public int getEarthy() {
        return earthy;
    }

    public int getFruity() {
        return fruity;
    }

    public int getNutty() {
        return nutty;
    }

    public int getOxidized() {
        return oxidized;
    }
}
