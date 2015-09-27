package com.barrypress.wiz.character;

import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.object.Buff;

import java.util.ArrayList;
import java.util.List;

public abstract class PC {

    private Integer ac;
    private Integer hp;
    private Integer maxHp;
    private Integer speed;
    private Integer surge;
    private Integer level;
    private String name;
    private String race;
    private String role;
    private Integer tile;
    private Integer square;

    private boolean slowed;
    private boolean immobilized;
    private boolean attacked;

    private List<Power> utilityPowers;
    private List<Power> dailyPowers;
    private List<Power> atWillPowers;
    private List<Power> knownPowers;
    private List<Buff> buffs;
    private List<Power.PowerType> startingPowerTypes;

    public void PC() {
        utilityPowers = new ArrayList<>();
        dailyPowers = new ArrayList<>();
        atWillPowers = new ArrayList<>();
        knownPowers = new ArrayList<>();
        buffs = new ArrayList<>();
        startingPowerTypes = new ArrayList<>();
        slowed = false;
        immobilized = false;
        attacked = false;
        level = 1;
    }

    public abstract void endHeroPhaseSpecial();
    public abstract void levelUp();
    public abstract Buff tileBuff();
    public abstract void startExplorationPhase();

    public void endHeroPhase() {
        slowed = false;
        immobilized = false;

        List<Buff> removals = new ArrayList<>();
        for (Buff buff : buffs) {
            Integer duration = buff.getDuration();
            duration -= 1;
            if (duration.compareTo(0) <= 0) {
                removals.add(buff);
            } else {
                buff.setDuration(duration);
            }
        }
        for (Buff buff : removals) {
            buffs.remove(buff);
        }
    }

    public void clearConditions() {
        slowed = false;
        immobilized = false;
    }


    public void addBuff(Buff.BuffType type, Integer amount, Integer duration) {
        buffs.add(new Buff(type, amount, duration));
    }

    public void startHeroPhase() {

    }

    public void usePower(Power power) {
        power.activate(this);
    }

    public Integer takeDamage(Integer damage) {
        hp -= damage;
        return getHp();
    }

    public boolean isDead() {
        return getHp().compareTo(0) <= 0;
    }

    public boolean isHit(Integer roll) {
        return roll.compareTo(getAc()) >= 0;
    }

    public Integer getBuffs(Buff.BuffType type) {

        Integer bonus = 0;

        for (Buff buff : buffs) {
            if (buff.getType().equals(type)) {
                bonus += buff.getAmount();
            }
        }

        return bonus;
    }

    public void heal(Integer amount) {
        hp += amount;
        if (hp.compareTo(maxHp) > 0) hp = maxHp;
    }

    public Integer getAc() {
        Integer tmpAc = ac;
        if (!buffs.isEmpty()) {
            for (Buff buff : buffs) {
                if (buff.getType() == Buff.BuffType.AC) {
                    tmpAc += buff.getAmount();
                }
            }
        }
        return tmpAc;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getHp() {
        Integer tmpHp = hp;
        if (!buffs.isEmpty()) {
            for (Buff buff : buffs) {
                if (buff.getType() == Buff.BuffType.HP) {
                    tmpHp += buff.getAmount();
                }
            }
        }
        return tmpHp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
        if (this.hp.compareTo(maxHp) > 0) {
            this.hp = maxHp;
        }
    }

    public Integer getSpeed() {
        Integer tmpSpeed = speed;
        if (slowed) tmpSpeed -= 2;
        if (immobilized) tmpSpeed = 0;
        if (!buffs.isEmpty()) {
            for (Buff buff : buffs) {
                if (buff.getType() == Buff.BuffType.SPEED) {
                    tmpSpeed += buff.getAmount();
                }
            }
        }
        return tmpSpeed;
    }

    public void addStartingPower(Power.PowerType powerType) {
        startingPowerTypes.add(powerType);
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getSurge() {
        return surge;
    }

    public void setSurge(Integer surge) {
        this.surge = surge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Power> getUtilityPowers() {
        return utilityPowers;
    }

    public void setUtilityPowers(List<Power> utilityPowers) {
        this.utilityPowers = utilityPowers;
    }

    public List<Power> getDailyPowers() {
        return dailyPowers;
    }

    public void setDailyPowers(List<Power> dailyPowers) {
        this.dailyPowers = dailyPowers;
    }

    public List<Power> getAtWillPowers() {
        return atWillPowers;
    }

    public void setAtWillPowers(List<Power> atWillPowers) {
        this.atWillPowers = atWillPowers;
    }

    public List<Power> getKnownPowers() {
        return knownPowers;
    }

    public void setKnownPowers(List<Power> knownPowers) {
        this.knownPowers = knownPowers;
    }

    public boolean isSlowed() {
        return slowed;
    }

    public void setSlowed(boolean slowed) {
        this.slowed = slowed;
    }

    public boolean isImmobilized() {
        return immobilized;
    }

    public void setImmobilized(boolean immobilized) {
        this.immobilized = immobilized;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public void setBuffs(List<Buff> buffs) {
        this.buffs = buffs;
    }

    public boolean hasAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
