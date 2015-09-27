package com.barrypress.wiz.utility;

import java.util.Random;

public class Dice {

    public static int dX(int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - 1) + 1) + 1;
        return randomNum;
    }

    public static int d6() {
        return dX(6);
    }

    public static int d4() {
        return dX(4);
    }

    public static int d12() {
        return dX(12);
    }

    public static int d20() {
        return dX(20);
    }

    public static Integer d100() {
        return dX(100);
    }
}
