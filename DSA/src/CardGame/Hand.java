package CardGame;

import java.util.LinkedList;



public class Hand {
	
	LinkedList<Card> cards;
	int total;
	
	Hand()
	{
		cards = new LinkedList<Card>();
	}
	
	public String toString()
	{
		
		String handCards="";
		for(Card card:cards)
		{
			handCards += card.toString() + " ";
		}
		return handCards;
	}
	public String lastCardToString()
	{
		return ""+ cards.getLast().toString();
	}
	
	
	public int getTotal()
	{
		
		return total;
	}
	boolean conainsAce()
	{
		boolean isAce=false;
		for(Card card:cards)
		{
			if(card.getVal()==11)
			{
				isAce = true;
			}
		}
		
		return isAce;
	}
	private boolean isSplit()
	{
		Card temp = cards.get(0);
		return temp.equalsOf(cards.get(1));
	}
	
	void changAceVal()
	{
		total = total -10;
	}
	public void add(Card card)
	{
		cards.add(card);
		total += card.getVal();
	}
	void aceCod()
	{
		total = total-10;
	}
}
