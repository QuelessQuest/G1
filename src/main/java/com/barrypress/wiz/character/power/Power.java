package com.barrypress.wiz.character.power;

public abstract class Power {

    public enum PowerType {UTILITY, AT_WILL, DAILY};

    private PowerType powerType;
    private boolean used;
    private String name;
    private String description;

    public Power() {
        used = false;
    }

    public abstract void activate();

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
