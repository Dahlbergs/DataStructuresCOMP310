/**
   Handles all the game loop and fundamental mechanics for a game of BlackJack using a 
   list of cards.
   @author Robert Blood, Samuel Dahlberg, Yves Sabato
*/


package lab.four;

import java.util.Scanner;
import java.util.Random;

public class Game {
    private static final int TWENTY_ONE = 21;
    private static final int SUIT_SIZE = Suit.values().length;
    private static final int FACE_SIZE = Face.values().length;

    private String gameName; 
    private Deck<Card> gameDeck;
    private int numPlayers;

    private Player[] players;
    private Player dealer;
    private Player currentPlayer;
    private Player winningPlayer;


    // private int currentPlayerHandValue;
    // private int dealerHandValue;
    // private int currentPlayerNumber;
    // private int numPlayers;

    public Game() {	
	gameName = "BlackJack";
	gameDeck = new Deck<Card>();
	dealer = new Player("Dealer", 100);
    }

    public void init() {
	System.out.println("Welcome to Black Jack\nPlease enter the number of players");
	Scanner scanner = new Scanner(System.in);
	numPlayers = scanner.nextInt();
	scanner.nextLine();

	players = new Player[numPlayers]; 

	for(int i = 0; i < numPlayers; i++) {	    
	    int playerNum = i + 1;

	    System.out.println("Please enter the name for Player " + playerNum);
	    String playerName = scanner.nextLine();

	    players[i] = new Player(playerName, playerNum);	    
	}
	
	currentPlayer = players[0];
	populateDeck();
	run();
    }

    public void run() {
	boolean isContinuing = true;
	

	System.out.println("========================= Starting Black Jack Game =========================");

	while(isContinuing) {

	    boolean noWinner = true;

	    System.out.println("STARTING NEW GAME\n"); 
	    System.out.println("Player " + getCurrentPlayer().getPlayerNumber() + 
			       "'s turn\nDealing hand");	    
	    dealHands();

	    while(noWinner) {
		int GAME_STATE = evaluateHands();

		if(GAME_STATE == 0) {
		    System.out.println("===Dealer Wins===");	    
		    noWinner = false;
		} else if(GAME_STATE == 1) {
		    System.out.println("===" + currentPlayer.getName() + " Wins===");
		    noWinner = false;
		} else {		    
		    //System.out.println("Continuing\n");
		    if(!currentPlayer.getIsChecked()) {
			handlePlayerTurn();
		    } else if(!dealer.getIsChecked()) {
			handleDealerTurn();
		    }
		    
		}
	    }

	    System.out.println("Move to next player and continue playing?\n Enter 0 to continue, 1 to exit");
	    Scanner scanner = new Scanner(System.in);
	    int temp = scanner.nextInt();
	    if(temp == 1) {
		isContinuing = false;
		
	    } else {
		reset();
	    }
	}
    }

    public void reset() {
	makeNewDeck();
	dealer.clearHand();
	currentPlayer.clearHand();
	advanceToNextPlayer();
    }

    private void makeNewDeck() {
	gameDeck = new Deck<Card>();
	populateDeck();
    }

    public void populateDeck() {
	System.out.println("Building Deck");
	for(int i = 0; i < SUIT_SIZE; i++) {
	    for(int j = 0; j < FACE_SIZE; j++) {
		Card temp = new Card(Suit.values()[i], Face.values()[j]);
		gameDeck.add(temp);
	    }
	}
    }

    public void advanceToNextPlayer() {
	if(currentPlayer.getPlayerNumber() == numPlayers) {
	    currentPlayer = players[0];
	} else {
	    int nextPlayerNumber = currentPlayer.getPlayerNumber();
		currentPlayer = players[nextPlayerNumber];
	}
    }

    public Player getCurrentPlayer() {
	return currentPlayer;
    }

    public void dealHands() {
	currentPlayer.addCard(gameDeck.getRandomCard());
	currentPlayer.addCard(gameDeck.getRandomCard());
	currentPlayer.displayHand();
	

	dealer.addCard(gameDeck.getRandomCard());
	dealer.addCard(gameDeck.getRandomCard());	
	dealer.displayHand();
    }

    public int evaluateHands() {
	int playerValue = currentPlayer.getHandValue();
	int dealerValue = dealer.getHandValue();
	
	final int DEALER_WIN = 0;
	final int PLAYER_WIN = 1;
	final int NO_WIN = 2;

	if(playerValue > 21 && dealerValue < 21) {
	    return DEALER_WIN;
	} else if (dealerValue > 21 && playerValue < 21) {
	    return PLAYER_WIN;
	} else if (dealer.getIsChecked() && currentPlayer.getIsChecked()) {
	    if(playerValue > dealerValue) {
		return PLAYER_WIN;
	    } else if(dealerValue > playerValue) {
		return DEALER_WIN;
	    } else if(dealerValue == playerValue) {
		return DEALER_WIN;
	    }
	} 

	return NO_WIN;
    }

    public void handlePlayerTurn() {
	while(true) {
	    System.out.println("Press 0 to hit, 1 to check");
	    Scanner scanner = new Scanner(System.in);
	    int playerChoice = scanner.nextInt();

	    if(playerChoice == 0) {
		currentPlayer.addCard(gameDeck.getRandomCard());
		currentPlayer.displayHand();
		return;
	    } else if(playerChoice == 1) {
		currentPlayer.setIsChecked(true);
		return;
	    } else {
		System.out.println("Invalid Option, Try Again\n");
		continue;
	    }
	}
    }

    public void handleDealerTurn() {
	while(true){
	    if(dealer.getHandValue() == 21){
		dealer.setIsChecked(true);
		return;
	    } else if(dealer.getHandValue() < 15){
		//"I always aim for 21 but still hit on 15" -Sam Dahlberg
		dealer.addCard(gameDeck.getRandomCard());
		dealer.displayHand();
		continue;
	    } else {
		dealer.setIsChecked(true);
		return;
	    }
	}
    }

    public static void main(String[] args) {
	Game game = new Game();
	game.init();
    }
}
