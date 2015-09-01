package CardGame;

import java.util.*;

public class Deck {

	LinkedList<Card> cards;
	
	Deck()
	{
		cards = new LinkedList<Card>();	
			for(int valCount =1;valCount<=13;valCount++)
				cards.add(new Card(valCount,CardType.CLUB));
			
			for(int valCount =1;valCount<=13;valCount++)
				cards.add(new Card(valCount,CardType.SPADE));
			
			for(int valCount =1;valCount<=13;valCount++)
				cards.add(new Card(valCount,CardType.HEARTS));
			
			for(int valCount =1;valCount<=13;valCount++)
				cards.add(new Card(valCount,CardType.SPADE));

	}

	
	private void swap(int number)
	{
		Card tempCard; 
		tempCard = (Card)cards.get(number);
		cards.remove(number);
		cards.add(tempCard);
		
	}
	void shuffle()
	{
			for(int scnt=0;scnt<500;scnt++)
		{
			int number = (int)(Math.random() * cards.size());
			swap(number);
			
		}
	}

	Card deal()
	{
		if(cards.size() != 0)
		return (Card)cards.remove(0);;
		
		System.out.println("Empty");
			return null;
	}
	
	
//	void show()
//	{
//		for(int i=0;i<5;i++)
//			System.out.println(deal());
//		
//		int ctr=0;
//		System.out.println("");
//		
//		while(ctr++<cards.size())
//		{
//			System.out.println((deal()));
//		}
//		
//	}
	
}

