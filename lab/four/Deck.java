/** An abstraction of the pile into a deck, needs very little additional functionality as it was
    too difficult to properly construct a deck from within
    @author Robert Blood, Samuel Dahlberg, Yves Sabato
*/

package lab.four;

import java.util.Random;

public class Deck<T extends Card> extends Pile<T> {
    /** Takes a random card from the deck, forgoing the need for a shuffle function 
	@return The random card removed */    
    public T getRandomCard() {
	Random rand = new Random();
	int randIndex = rand.nextInt(this.getLength() - 1);
	    
	return remove(randIndex);
    }
    
    // public void shuffle() {
    // 	Random rand = new Random(getLength());
    // 	for(int i = 0; i < getLength(); i++) {
    // 	    swap(rand.nextInt(getLength()), rand.nextInt(getLength()));
    // 	}	
    // }
}
