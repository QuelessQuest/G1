package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

public class PreciseStrike extends Power {

    public PreciseStrike() {
        super();
        setPowerType(PowerType.DAILY);
        setName("Precise Strike");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Choose adjacent monster

        // Attack
        if (Combat.attack(pc, null, 11)) {
            setUsed(true);
            Combat.dealDamage(pc, null, 2);
        }
    }
}
