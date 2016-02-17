/**
   Represents a card with a suit, color and face value.  
   @author Robert Blood, Samuel Dahlberg, Yves Sabato
 */
package lab.four;

public class Card {
    private Suit suit;
    private Color color;
    private Face face;

    /** Default Constructor */
    public Card() {
	suit = Suit.SPADES;
	face = Face.ACE;
	color = Color.BLACK;
    }

    public Card(Suit x, Face z){
	suit = x;
	face = z;
	
	switch(suit) {
	case DIAMONDS:
	case HEARTS:
	    color = Color.RED;
	    break;
	case CLUBS:
	case SPADES:
	    color = Color.BLACK;
	    break;
	default:
	    break;
	}	
    }

    public String toString() {
	String temp = color.toString() + " " + face.toString() + " of " + suit.toString();
	return temp;
    }

    public int getCardValue() {
	return face.getFaceValue();
    }

    public static void main(String[] args) {	
	Card card = new Card(Suit.SPADES, Face.ACE);
	System.out.println(card.toString());

    }
}
