package CardGame;

public class Card {

	private int val;
	CardType type;

	Card()
	{
		val = 0;
		
	}
	Card(int val,CardType type)
	{	
		
			this.val = val;
			this.type = type;
			
	}
	
	 int getVal()
	{
		 if(val==1)
				return 11;
		if(val<11)
				return val;
		
				return 10;
	}
	public boolean equalsOf(Card card)
	{
		return this.val == card.val;
	}
	CardType getType()
	{
		return type;
	}
	
	public String toString()
	{
		String facevalue;
		
		switch(val)
		{
			case 1 : facevalue = "A";
			break;
			case 11 : facevalue = "J";
			break;
			case 12 : facevalue = "Q";
			break;
			case 13 : facevalue = "K";
			break;
			default : facevalue = String.valueOf(val);
		}

			return (facevalue + " " + type + ", ");
		
	}
	
}
