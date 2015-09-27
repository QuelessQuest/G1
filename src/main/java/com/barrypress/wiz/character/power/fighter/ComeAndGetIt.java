package com.barrypress.wiz.character.power.fighter;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.character.power.Power;
import com.barrypress.wiz.monster.Monster;
import com.barrypress.wiz.utility.Combat;
import com.barrypress.wiz.utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class ComeAndGetIt extends Power {

    public ComeAndGetIt() {
        super();
        setPowerType(PowerType.DAILY);
        setName("Come And Get It");
        setPhase(Constants.Phase.HERO);
        setRole(Constants.Role.FIGHTER);
    }

    public void activate(PC pc) {

        // Choose tile within 1 tile

        // Get all monsters on tile
        List<Monster> monsters = new ArrayList<>();

        // Move them adjacent to PC

        // Attack
        for (Monster monster : monsters) {
            if (Combat.attack(pc, monster, 6)) {
                Combat.dealDamage(pc, monster, 1);
            }
        }

        setUsed(true);
    }
}
