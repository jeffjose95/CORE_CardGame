package cards;

import board.Player;

public class ModifierCard extends Card {
    public ModifierCard(String name, String description, int manaCost) {
        this(name, description, manaCost, null);
    }
    public ModifierCard(String name, String description, Element element, int manaCost) {
        this(name, description, element, manaCost, null);
    }
    public ModifierCard(String name, String description, int manaCost, Ability[] abilities) {
        this(name, description, null, manaCost, abilities);
    }
    public ModifierCard(String name, String description, Element element, int manaCost, Ability[] abilities) {
        super(name, description, element, manaCost, abilities);
    }
}