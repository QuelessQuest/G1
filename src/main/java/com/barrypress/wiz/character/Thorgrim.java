package com.barrypress.wiz.character;

import com.barrypress.wiz.character.power.HealingWord;
import com.barrypress.wiz.character.power.Power;

import java.util.ArrayList;
import java.util.List;

public class Thorgrim extends PC {

    public Thorgrim() {
        super();
        setAc(16);
        setHp(8);
        setMaxHp(8);
        setSpeed(5);
        setSpeed(4);
        setName("Thorgrim");
        setRace("Dwarf");
        setRole("Cleric");
        getKnownPowers().add(new HealingWord());
        addStartingPower(Power.PowerType.UTILITY);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.AT_WILL);
        addStartingPower(Power.PowerType.DAILY);
    }

    /**
     * Thorgrims Hero Power is checked during the end phase. It cannot be
     * used willingly.
     *
     * @param allPcs all PCs
     * @param onTilePcs all PCs on players tile
     */
    public void useHeroPower(List<PC> allPcs, List<PC> onTilePcs) {
        return;
    }

    public void endHeroPhaseSpecial() {

        if (!hasAttacked()) {
            // TODO call function to get all other PCs on same tile
            String msg = "Thorgrim may now AID any other Hero on his current tile, healing them 1 Hit Point.";
            List<PC> pcs = new ArrayList<>();

            if (!pcs.isEmpty()) {
                // TODO call function to allow selection of a PC
                PC pc = pcs.get(0);
                pc.heal(1);
            }
        }
    }
}