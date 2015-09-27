package com.barrypress.wiz.character;

import com.barrypress.wiz.character.power.DragonsBreath;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.object.Buff;

public class Arjhan extends PC {

    public Arjhan() {
        super();
        setAc(17);
        setHp(10);
        setMaxHp(10);
        setSpeed(5);
        setSurge(5);
        setName("Arjhan");
        setRace("Dragonborn");
        setRole("Fighter");
        getKnownPowers().add(new DragonsBreath());
        addStartingPower(Power.PowerType.UTILITY);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.DAILY);
    }

    public void startExplorationPhase() {}

    public Buff tileBuff() {
        return new Buff(Buff.BuffType.AC, 1, 1);
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