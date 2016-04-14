package cards;

import board.Player; // My implementation uses a Player class in another package.  It implements the Attackable
                     // interface, which is in this package.  That was poorly thought out.

/**
 * This interface specifies all of the methods absolutely necessary for an object of class Card.
 * @author Gregory Gan
 */
public interface CardInterface {
    public int getManaCost();
    public boolean isFaceUp();
    public boolean flip();
    public Element getElement();
    public Ability[] getAbilities();
    public String getType();
    public String getName();
    public String getDescription();
}