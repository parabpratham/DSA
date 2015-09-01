package CardGame;

public class PlayBlackJack {
	
	public static void main(String[] args)
	{	Deck dk;
		Hand playerHand,house;
		
		dk = new Deck();
		playerHand = new Hand();
		house = new Hand();
		byte outcome = 3;
		final byte DRAW=1;
		final byte LOST =2;
		final byte WON =3;
		
		
		dk.shuffle();
		Card temp;
		//Draw 2 players card
		temp=dk.deal();
		playerHand.add(temp);
		temp=dk.deal();
		playerHand.add(temp);
		
		//Draw house card
		temp=dk.deal();
		house.add(temp);

		System.out.println("Dealer card : ");
		System.out.println(house);
		System.out.println("Player cards : ");
		System.out.print(playerHand + " ");
		System.out.println(playerHand.getTotal());
		
		boolean isAceUsed = false;
		while(playerHand.getTotal()<21 )
		{
			int input=javax.swing.JOptionPane.showConfirmDialog(null,"Do you want to Hit?");
//			System.out.println(input);
			//String inp= javax.swing.JOptionPane.showInputDialog("Hit h or Stay s");
			if(input == 2)
			{
				System.exit(0);
				
			}
			if(input == 0)
			//if(inp.equalsIgnoreCase("h"))
			{ 
				
				playerHand.add(dk.deal());
				
				System.out.print(playerHand.lastCardToString());
				System.out.println(" Sum: "+playerHand.getTotal());
				if(!isAceUsed && playerHand.getTotal() > 21 && playerHand.conainsAce())
				{
					isAceUsed = true;
					playerHand.changAceVal();
					System.out.println(" Sum changed becoz ACE: "+playerHand.getTotal());
				}
				
			}else
				break;
			
		}
		if(playerHand.getTotal()>21)
		{
			outcome = LOST;
			
		}
		if(playerHand.getTotal() == 21)
		{
			System.out.println("BLACKJACK");
			outcome = WON;
		}
		
		if(outcome != LOST || outcome != WON)
		{
//			System.out.println("House Cards :");
//			System.out.print(house);
//			System.out.println(" Sum: " + house.getTotal());
			
			isAceUsed = false;
			while(house.getTotal()<21 && house.getTotal()<playerHand.getTotal() )
			{
					
					Card tempCard = dk.deal();
					house.add(tempCard);
//					System.out.print(" "+house.lastCardToString());
//					System.out.println(" Sum: " + house.getTotal());
				
					if(!isAceUsed && house.getTotal() >21 && house.conainsAce()) 
					{
						isAceUsed = true;
						house.changAceVal();
						System.out.println(" Sum changed becoz ACE: "+playerHand.getTotal());
					}
			}
			System.out.println("House: " + house);
			System.out.println("Sum: " + house.getTotal());
			if(house.getTotal() < 21)
			{
				if(house.getTotal() == playerHand.getTotal())
				{
					outcome = DRAW;
				}else
				outcome = LOST;
				//System.out.println(" Sum : "+house.getTotal());
			}
			
			
		}
			switch(outcome)
			{
			case LOST : System.out.println("Player Lost");
						break;
			case DRAW : System.out.println("DRAW");
						break;
			default : System.out.println("Player won");
			}
							
		}
	
	
	}
	


