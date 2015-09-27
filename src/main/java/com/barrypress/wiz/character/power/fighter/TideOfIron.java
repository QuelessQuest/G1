package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

public class TideOfIron extends Power {

    public TideOfIron() {
        super();
        setPowerType(PowerType.AT_WILL);
        setName("Tide Of Iron");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Choose adjacent monster

        // Attack
        if (Combat.attack(pc, null, 8)) {
            Combat.dealDamage(pc, null, 1);

            // If monster survives, move it 1 tile

            // Move to any squard on your tile
        }
    }
}
