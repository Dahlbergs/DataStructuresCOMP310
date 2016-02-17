/**
   A class representing a player, with a name, and hand of cards and mechanisms for calculating 
   the value of his/her hand
   @author Robert Blood, Samuel Dahlberg, Yves Sabato
   
 */


package lab.four;

public class Player {

    private String name;
    private Pile<Card> hand;
    private int playerNumber;
    
    private int handValue;

    private boolean isChecked;
    
    public Player(String name, int playerNumber) {
	this.name = name;
	this.playerNumber = playerNumber;
	hand = new Pile<Card>();
	handValue = 0;
    }

    public String getName() {
	return name;
    }

    public int getPlayerNumber() {
	return playerNumber;
    }

    public boolean getIsChecked() {
	return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
	this.isChecked = isChecked;
    }

    public void clearHand() {
	handValue = 0;
	hand.clear();
    }   

    public void displayHand() {
	System.out.println("=== " + name + "'s Hand ===");
	hand.printContents();
	System.out.println(name + "'s hand value is: " + handValue);
    }

    public void addCard(Card card) {
	hand.add(card);
	handValue += card.getCardValue();
    }

    public int getHandValue() {
	return handValue;
    }
}
