package com.barrypress.wiz.character;

import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.character.power.SneakAttack;
import com.barrypress.wiz.object.Buff;

public class Kat extends PC {

    public Kat() {
        super();
        setAc(14);
        setHp(8);
        setMaxHp(8);
        setSpeed(6);
        setSurge(4);
        setName("Kat");
        setRace("Human");
        setRole("Rogue");
        getKnownPowers().add(new SneakAttack());
        addStartingPower(Power.PowerType.UTILITY);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.DAILY);
        getBuffs().add(new Buff(Buff.BuffType.DISABLE, 5, 99999));
    }

    public void startExplorationPhase() {}

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