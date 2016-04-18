package cards;

import java.util.Scanner;

public class Ability {
    public final String activateType, abilityType, target;
    public final double magnitude;
    public final int manaCost; // should be 0 for automatically triggered types

    /**
     * Creates a new Ability from a String of information of the form
     * <code>activateType:abilityType,optional_specifics:target,optional_specifics:magnitude:manaCost</code>
     * @param info the information String
     */
    public Ability(String info) {
        Scanner hold = new Scanner(info);
        Scanner in = hold.useDelimiter(":");
        activateType = in.next();
        abilityType = in.next();
        target = in.next();
        magnitude = Double.parseDouble(in.next());
        manaCost = Integer.parseInt(in.next());
        hold.close();
        in.close();
    }
    public Ability(String activateType, String abilityType, String target, double magnitude,
                   int manaCost) {
        this.activateType = activateType;
        this.abilityType = abilityType;
        this.target = target;
        this.magnitude = magnitude;
        this.manaCost = manaCost;
    }
}
