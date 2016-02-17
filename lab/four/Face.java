/**
   Encapsulates the values of cards as an enumerated type
   @author Robert Blood, Samuel Dahlberg, Yves Sabato
*/

package lab.four;

/** Represents a card value */
public enum Face {
    ACE("Ace", 1), 
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10);

    private String face;
    private int value;

    Face(String face, int value) {
	this.face = face;
	this.value = value;
    }

    public int getFaceValue() {
	return this.value;
    }

    public String toString() {
	return this.face;
    }
}
