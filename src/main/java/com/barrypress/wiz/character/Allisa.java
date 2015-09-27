package com.barrypress.wiz.character;

import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.object.Buff;

public class Allisa extends PC {

    public Allisa() {
        super();
        setAc(16);
        setHp(10);
        setMaxHp(10);
        setSpeed(6);
        setSurge(5);
        setName("Allisa");
        setRace("Human");
        setRole("Ranger");
        addStartingPower(Power.PowerType.UTILITY);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.DAILY);
    }

    public void startExplorationPhase() {
        // TODO Explore tile
    }

    public Buff tileBuff() {
        // None
        return null;
    }

    public void levelUp() {
        setMaxHp(getMaxHp() + 2);
        setAc(getAc() + 1);
        setSurge(getSurge() + 1);
        setLevel(getLevel() + 1);

        // TODO choose Daily Power
    }

    public void endHeroPhaseSpecial() {
        return;
    }
}