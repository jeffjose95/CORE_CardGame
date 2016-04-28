package cards;

import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
	public ArrayList<Card> Deck; 
    
	public Deck() 
	{ 
		Deck = new ArrayList<Card>();
		 
		}
	
    public Deck(Card... cards) 
    {
    	Deck = new ArrayList<Card>();
        for (Card card : cards)
            if (card != null)
                Deck.add(card);
    }
    public ArrayList<Card> getDeck()
    {
    	return Deck;
    }

    public Card draw() {
        if (isEmpty())
            return null;
        return remove((int) (Math.random() * size()));
    }
    public Card drawL0Monster() {
        if (isEmpty())
            return null;
        ArrayList<MonsterCard> monsters = new ArrayList<MonsterCard>();
        for (Card c : this)
            if (c instanceof MonsterCard)
                monsters.add((MonsterCard) c);
        return get((int) (Math.random() * monsters.size()));
    }
}
