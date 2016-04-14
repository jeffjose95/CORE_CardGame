package cards;

import java.util.LinkedList;

public class Player implements PlayerInterface {
    private Player opponent;
    private Deck deck;
    private Card[] hand;
    private MonsterCard[] monsters;
    private ModifierCard[] modifiers;
    private int mana, maxMana, manaRegen, health, maxHealth;
    private LinkedList<Card> graveyard;

    public Player(Deck deck) {
        mana = 30;
        maxMana = 100;
        manaRegen = 10;
        health = maxHealth = 50;
        hand = new Card[5];
        monsters = new MonsterCard[5]; // 0 index is main monster
        modifiers = new ModifierCard[3];
        graveyard = new LinkedList<Card>();
        this.deck = deck;
        boolean needsL0Monster = false;
        for (int i = 1; i < hand.length; i ++) {
            hand[i] = draw();
            if (hand[i] instanceof MonsterCard && ((MonsterCard) hand[i]).sacrifices == 0)
                needsL0Monster = true;
        }
        hand[0] = draw(needsL0Monster);
    }

    @Override public MonsterCard drawL0Monster() { return (MonsterCard) draw(true); }
    @Override public Card draw()                 { return draw(false); }
    @Override
    public Card draw(boolean l0Monster) {
        int i = 0;
        Card c = null;
        for (; i < hand.length; i ++) // cannot draw if hand is full
            if (hand[i] == null)
                break;
        if (i < 5) {
            c = (l0Monster ? deck.drawL0Monster : deck.draw());
            hand[i] = c;
        }
        return c;
    }
    @Override
    public Card play(int placeInHand, int placeToPlay, Player playTo) {
        // TODO implement play
        return hand[placeInHand];
    }

    @Override public int              getHealth()    { return health;    }
    @Override public int              getMana()      { return mana;      }
    @Override public int              getMaxHealth() { return maxHealth; }
    @Override public int              getMaxMana()   { return maxMana;   }
    @Override public int              getManaRegen() { return manaRegen; }
    @Override public Player           getOpponent()  { return opponent;  }
    @Override public Deck             getDeck()      { return deck;      }
    @Override public Card[]           getHand()      { return hand;      }
    @Override public Card[]           getMonsters()  { return monsters;  }
    @Override public Card[]           getModifiers() { return modifiers; }
    @Override public LinkedList<Card> getGraveyard() { return graveyard; }

    @Override
    public int changeHealth(int change) {
        health = Math.min(health + change, maxHealth);
        return health;
    }
    @Override
    public int changeMana(int change) {
        mana = Math.min(mana + change, maxMana);
        return mana;
    }
    @Override
    public int changeMaxHealth(int change) {
        maxHealth = Math.max(1, maxHealth + change);
        if (health > maxHealth)
            health = maxHealth;
        return maxHealth;
    }
    @Override
    public int changeMaxMana(int change) {
        maxMana = Math.max(1, maxMana + change);
        if (mana > maxMana)
            mana = maxMana;
        return maxMana;
    }
    @Override
    public int changeManaRegen(int change) {
        manaRegen += change;
        return manaRegen;
    }

    @Override
    public Player setOpponent(Player opponent) {
        Player hold = this.opponent;
        this.opponent = opponent;
        return hold;
    }

    @Override
    public int attack(Card attacker, Attackable[] defender) { return attack(attacker, false, defender); }
    @Override
    public int attack(Card attacker, boolean useSpecialIfPossible, Attackable[] defender) {
        // TODO implement attack
        return defender.defend(attacker, true);
    }

    @Override
    public int defend(Card attacker, int damage, boolean allowCounter) {
        health -= damage; // no elemental adjustment
        if (isDead())
            death(null);
    }

    @Override public boolean isDead() { return health <= 0; }
    @Override
    public void death(Card attacker) {
        // TODO implement death
    }
}
