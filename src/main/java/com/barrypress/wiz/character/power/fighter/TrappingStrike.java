package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

public class TrappingStrike extends Power {

    public TrappingStrike() {
        super();
        setPowerType(PowerType.AT_WILL);
        setName("Trapping Strike");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Choose monster within 1 tile

        // Move it adjacent

        // Attack
        if (Combat.attack(pc, null, 8)) {
            Combat.dealDamage(pc, null, 1);
        }
    }
}
