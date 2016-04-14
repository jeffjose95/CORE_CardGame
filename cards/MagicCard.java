package cards;

import board.Player;

public class MagicCard extends Card {
    public final boolean isEquip;

    public MagicCard(String name, String description, int manaCost, boolean isEquip) {
        this(name, description, manaCost, null, isEquip);
    }
    public MagicCard(String name, String description, Element element, int manaCost, boolean isEquip) {
        this(name, description, element, manaCost, null, isEquip);
    }
    public MagicCard(String name, String description, int manaCost, Ability[] abilities, boolean isEquip) {
        this(name, description, null, manaCost, abilities, isEquip);
    }
	public MagicCard(String name, String description, Element element, int manaCost, Ability[] abilities,
	                 boolean isEquip) {
        super(name, description, element, manaCost, abilities);
        this.isEquip = isEquip;
    }
}