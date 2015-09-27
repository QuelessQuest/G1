package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

public class Unstoppable extends Power {

    public Unstoppable() {
        super();
        setPowerType(PowerType.UTILITY);
        setName("Unstoppable");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {
        pc.setHp(pc.getHp() + 2);
        setUsed(true);
    }
}
