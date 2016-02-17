/** Encapsulates the suit of a card as an enumerated type
    @author Robert Blood, Samuel Dahlberg, Yves Sabato
*/

package lab.four;

/** The suit of the card */
public enum Suit {
    SPADES("Spades"),
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");
    
    private String suit;
    
    Suit(String suit) {
	this.suit = suit;
    }
    
    public String toString() {
	return this.suit;
    }
}
