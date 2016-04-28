package cards;

/**
 * There are five phases, or elements: <code>FIRE</code>, <code>EARTH</code>, <code>METAL</code>,
 * <code>WATER</code>, and <code>WOOD</code>.  An element can deal 50% increased or decreased damage or healing,
 * depending on its relationship with the target element.  The relationships follow the Chinese notion of Wu Xing,
 * so the term “elements” is technically inaccurate but sufficiently clear.
 * @author Gregory Gan
 */
public enum Element {
    FIRE, EARTH, METAL, WATER, WOOD;
    
    /**
     * Adjusts damage done to another element.  If the attacking element prevails over the defending element, it
     * deals 1 + 10% more damage; if the defending element prevails, the attacker deals 1 + 10% less damage.
     * <p>Negative damage counts as healing.  Element combinations that deal more damage deal less healing, and
     * vice versa.</p>
     * @param e the defending element
     * @param dmg the raw damage (before elemental adjustment)
     * @return the adjusted damage
     */
    public int dmgOn(Element e, int dmg) {
        if (e == null)
            return dmg;
        int diff = (ordinal() - e.ordinal() + 5) % 5;
        int mod = 1 + (int) Math.abs(0.1 * dmg);
        if (diff == 1 || diff == 3)
            return dmg + mod;
        if (diff == 2 || diff == 4)
            return dmg - mod;
        return dmg;
    }
}