/*
 * Card: 
 *	
 */
public class Card {
	private int rank;
	private int suit;
	
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	
	public Card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	// methods 
	// Card
	// Card int int
	// rankIsLessThan
	// rankIsGreaterThan
	// rankIsEqualTo
	// toString done
	// getRank done 
	// getSuit done 

	public String toString() {
		String cardSuit = "";
		String cardRank = "";
		String cardString;
		// get suit and rank for the card
		int cs = getSuit();
		int cr = getRank();
		
		// convert to a string. First suit
		switch (cs) {
		case 0: cardSuit="hearts";
				break;
		case 1: cardSuit="diamonds";
				break;
		case 2: cardSuit="clubs";
				break;
		case 3: cardSuit="spades";
				break;
		default: cardSuit="n/a";
		
		}// switch
		
		switch (cr) {
		case 1: cardRank="ace";
				break;
		case 2: cardRank="2";
				break;
		case 3: cardRank="3";
				break;
		case 4: cardRank="4";
				break;
		case 5: cardRank="5";
				break;
		case 6: cardRank="6";
				break;
		case 7: cardRank="7";
				break;
		case 8: cardRank="8";
				break;
		case 9: cardRank="9";
				break;
		case 10:cardRank="10";
				break;
		case 11:cardRank="jack";
				break;
		case 12:cardRank="queen";
				break;
		case 13:cardRank="king";
				break;
		default:cardRank="n/a";	
		
		} // switch rank
		
		cardString = "./cards/" + cardRank + "_of_" + cardSuit + ".png";
		return cardString;
		
	}
	
	public boolean rankIsLessThan (Card second){
		if (this.rank < second.getRank()){
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean rankIsGreaterThan (Card second){
		if (this.rank > second.getRank()){
			return true;
		} else {
			return false;
		}
		
	}
	
	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getSuit() {
		return suit;
	}


	public void setSuit(int suit) {
		this.suit = suit;
	}

}
