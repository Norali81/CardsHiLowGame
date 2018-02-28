/* THe game class contains a deck, a counter to keep track of the number of wins
 * it can test if the player won the round as well as restart the game.  
*/
public class Game {

	// variables Deck and a counter to keep track of the consecutive wins
	private DeckOfCards deck;
	private int winCounter;

	// Constructor
	public Game() {
		super();
		this.deck = new DeckOfCards();
		deck.shuffle();
		this.winCounter = 0;
	}

	// method to evaluate if the player won the round
	// hilo is the radiobutton selected
	public boolean evaluateWin(int hiLo) {
		// if lower was selected
		if (hiLo == 0) {
			// if the second card is lower than the first card
			if (this.deck.getSecondCard().rankIsLessThan(this.getDeck().getFirstCard())) {
				this.winCounter++; // increment win counter
				return true;
			} else {
				this.winCounter = 0; // else set win counter to 0
				return false;
			}
			// if higher was selected
		} else if (hiLo == 1) {
			// test if second card is higher
			if (this.deck.getSecondCard().rankIsGreaterThan(this.deck.getFirstCard())) {
				// increment win counter
				this.winCounter++;
				return true;
			} else {
				// or reset win counter
				this.winCounter = 0;
				return false;
			}
		} else {
			this.winCounter = 0;
			return false;
		}
	}

	// when the game is restarted
	public void restart() {
		// reset all counters
		winCounter = 0;
		deck.shuffle();
		this.getDeck().setCurrentCard(0);
		this.getDeck().setNextCard(0);
		this.getDeck().setFirstCard(null);
		this.getDeck().setSecondCard(null);
	}

	public DeckOfCards getDeck() {
		return deck;
	}

	public void setDeck(DeckOfCards deck) {
		this.deck = deck;
	}

	public int getWinCounter() {
		return winCounter;
	}

	public void setWinCounter(int winCounter) {
		this.winCounter = winCounter;
	}

}
