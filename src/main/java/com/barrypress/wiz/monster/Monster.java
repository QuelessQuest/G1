package com.barrypress.wiz.monster;


public abstract class Monster {

    private Integer ac;
    private Integer hp;

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
}
