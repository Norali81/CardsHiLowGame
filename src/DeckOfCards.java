import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * The DeckOfCards class constructs a shuffled deck of cards
 * With 52 cards from Ace to Queen of all 4 suits
 * 
 * 
 */
public class DeckOfCards {
	private int currentCard;
	private int nextCard;
	private int[] suits;
	private int[] ranks;
	private Card[] deck;
	private Card firstCard;
	private Card secondCard;

	public DeckOfCards() {
		super();

		// create arrays to hold suits and ranks
		this.suits = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		this.ranks = new int[] { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0,
				1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3 };
		// create array to hold all dealt cards and all 52 cards
		this.deck = new Card[52];

		// looping over arrays of suits and ranks and creating a new card from
		// each
		for (int i = 0; i < this.deck.length; i++) {
			this.deck[i] = new Card(suits[i], ranks[i]);
		}

		// setting current card and next card to 0
		this.currentCard = 0;
		this.nextCard = 1;
	}

	/*
	 * Method to shuffle the deck
	 */
	public void shuffle() {
		Card tempStore;
		// iterating over deck and swapping each card with
		// another card at a random location
		for (int i = 0; i < this.deck.length; i++) {
			int random = (int) ((Math.random() * 52));
			tempStore = deck[i];
			deck[i] = deck[random];
			deck[random] = tempStore;
		} // for
	} // shuffle

	// method to check if the all cards have been dealt
	public boolean isEmpty() {
		if (this.nextCard > 50) {
			return true;
		} else {
			return false;
		}
	} // isEmpty

	// method to deal next card
	public Card dealTopCard() {
		// when the top card needs to be dealt
		// increment next card, return current card
		// which is next card -1
		this.nextCard++;
		this.currentCard = nextCard - 1;
		return deck[currentCard];
	} // dealTopCard

	/*
	 * Getters and setters
	 */
	public int getCurrentCard() {
		return currentCard;
	}

	public void setCurrentCard(int currentCard) {
		this.currentCard = currentCard;
	}

	public int getNextCard() {
		return nextCard;
	}

	public void setNextCard(int nextCard) {
		this.nextCard = nextCard;
	}

	public Card getFirstCard() {
		return firstCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public Card getSecondCard() {
		return secondCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}
}// class
