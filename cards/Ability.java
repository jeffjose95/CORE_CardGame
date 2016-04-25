package cards;

import java.util.Scanner;

public class Ability {
    public final String activateType, activateSubtype, abilityType, abilitySubtype, target, targetSpec;
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
        activateSubtype = in.next();
        abilityType = in.next();
        abilitySubtype = in.next();
        target = in.next();
        targetSpec = in.next();
        magnitude = Double.parseDouble(in.next());
        manaCost = Integer.parseInt(in.next());
        hold.close();
        in.close();
    }
    public Ability(String activateType, String activateSubtype, String abilityType, String abilitySubtype,
                   String target, String targetSpec, double magnitude, int manaCost) {
        this.activateType = activateType;
        this.activateSubtype = activateSubtype;
        this.abilityType = abilityType;
        this.abilitySubtype = abilitySubtype;
        this.target = target;
        this.targetSpec = targetSpec;
        this.magnitude = magnitude;
        this.manaCost = manaCost;
    }
}
