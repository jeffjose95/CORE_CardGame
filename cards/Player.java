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
    private LinkedList<Card> playedThisTurn;

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
        playedThisTurn = new LinkedList<Card>();
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
            c = (l0Monster ? deck.drawL0Monster() : deck.draw());
            hand[i] = c;
        }
        return c;
    }
    @Override
    public Card play(int placeInHand, int placeToPlay, Player playTo) {
        Card toPlay = hand[placeInHand];
        // TODO implement play
        playedThisTurn.add(toPlay);
        return toPlay;
    }
    @Override
    public Card discardFromHand(int index) {
        Card toDiscard = hand[index];
        if (toDiscard != null) {
            hand[index] = null;
            graveyard.add(toDiscard);
        }
        return toDiscard;
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
    public int attack(Card attacker, Attackable... targets) { return attack(attacker, false, targets); }
    @Override
    public int attack(Card attacker, boolean useSpecialIfPossible, Attackable... targets) {
        int dmg = 0;
        if (attacker instanceof MonsterCard && !useSpecialIfPossible) {
            dmg = ((MonsterCard) attacker).getAtk();
        } else {
            // TODO implement attack
        }
        int i = 0;
        for (Attackable defender : targets)
            i += defender.defend(attacker, dmg, true);
        return i;
    }

    @Override
    public int defend(Card attacker, int damage, boolean allowCounter) {
        int hold = Math.min(damage, health);
        health -= damage;
        if (isDead())
            death(null);
        return hold;
    }

    @Override public boolean isDead() { return health <= 0; }
    @Override
    public void death(Card attacker) {
        // TODO implement death
    }

    public void battlePhase(Card... useSpecial) {
        while (!playedThisTurn.isEmpty()) {
            Card card = playedThisTurn.removeFirst();
            for (Ability ability : card.getAbilities()) {
                switch(ability.activateType) {
                    case "onPlay":
                        if (ability.targetSpec.contains("player")) { // abilities with effects on players
                            boolean both = ability.target.contains("both");
                            Player[] target = new Player[both ? 1 : 2];
                            if (both || ability.target.contains("ally"))
                                target[0] = this;
                            if (ability.target.contains("opponent"))
                                target[target.length - 1] = opponent;
                            for (Player p : target)
                                applyTo(ability, card, p);
                        } else {

                        }
                        break;
                    case "passive":
                        // TODO implement passive
                        break;
                    default: // do active abilities later in phase
                }
            }
        }
        // TODO implement normal attack / use special if possible
    }
    private static boolean applyTo(Ability a, Card source, Object target) {
        if (! (target instanceof Attackable || target instanceof Card))
            return false;
        switch(ability.abilityType) { // could have used reflection, but this seems more stable
            case "damage":
                if (target instanceof Attackable) {
                    ((Attackable) target).defend(card, ability.magnitude, true);
                    return true;
                }
                break;
            case "changeAtk":
                if (target instanceof MonsterCard) {
                    ((MonsterCard) target).changeAtk(ability.magnitude);
                    return true;
                }
                break;
            case "changeDef":
                if (target instanceof MonsterCard) {
                    ((MonsterCard) target).changeDef(ability.magnitude);
                    return true;
                }
                break;
            case "changeHealth":
                if (target instanceof Attackable) {
                    ((Attackable) target).changeHealth(ability.magnitude);
                    return true;
                }
                break;
            case "changeMaxHealth":
                if (target instanceof Attackable) {
                    ((Attackable) target).changeMaxHealth(ability.magnitude);
                    return true;
                }
                break;
            case "changeMana":
                if (target instanceof Player) {
                    ((Player) target).changeMana(ability.magnitude);
                    return true;
                }
                break;
            case "changeMaxMana":
                if (target instanceof Player) {
                    ((Player) target).changeMaxMana(ability.magnitude);
                    return true;
                }
                break;
            case "changeManaRegen":
                if (target instanceof Player) {
                    ((Player) target).changeManaRegen(ability.magnitude);
                    return true;
                }
                break;
            case "negateEffect":
                // TODO implement negate effect
                break;
        }
        return false;
    }
}
