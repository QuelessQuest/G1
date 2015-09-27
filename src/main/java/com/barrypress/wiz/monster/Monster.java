package com.barrypress.wiz.monster;


public abstract class Monster {

    private Integer ac;
    private Integer hp;
    private Integer tile;
    private Integer square;

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getTile() {
        return tile;
    }

    public void setTile(Integer tile) {
        this.tile = tile;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }
}
