package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

public class Cleave extends Power {

    public Cleave() {
        super();
        setPowerType(PowerType.AT_WILL);
        setName("Cleave");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Choose adjacent monster

        // Attack
        if (Combat.attack(pc, null, 6)) {
            Combat.dealDamage(pc, null, 1);

            // Choose another monster on tile

            // Move adjacent to it
            Combat.dealDamage(null, null, 1);
        }
    }
}
