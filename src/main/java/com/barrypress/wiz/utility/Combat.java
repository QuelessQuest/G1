package com.barrypress.wiz.utility;

import com.barrypress.wiz.character.PC;
import com.barrypress.wiz.monster.Monster;
import com.barrypress.wiz.object.Buff;

public class Combat {

    public static boolean attack(PC pc, Monster target, Integer toHit) {

        Integer totalToHit = toHit + pc.getBuffs(Buff.BuffType.ATTACK) + Dice.d20();
        if (totalToHit.compareTo(target.getAc()) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void dealDamage(PC pc, Monster target, Integer amount) {

        Integer totalDamage = amount;
        if (pc != null) {
            totalDamage += pc.getBuffs(Buff.BuffType.DAMAGE);
        }
        target.setHp(target.getHp() - totalDamage);
        if (target.getHp().compareTo(0) <= 0) {
            // TODO kill monster
        }
    }
}
