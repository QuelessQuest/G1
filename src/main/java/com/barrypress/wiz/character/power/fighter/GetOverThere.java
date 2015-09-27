package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.utility.Constants;

public class GetOverThere extends Power {

    public GetOverThere() {
        super();
        setPowerType(PowerType.UTILITY);
        setName("Get Over There");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Get monsters within 2 tiles

        // Move Hero to adjacent to one monster

        setUsed(true);
    }
}
