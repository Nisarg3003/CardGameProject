/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public final class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        this.size = givenSize;
        this.cards = new ArrayList<>();
        initializeDeck();
    }
    
    /**
     * Method to initialize the deck with a standard 52-card set.
     * This method creates cards for all suits (Hearts, Diamonds, Clubs, Spades)
     * and ranks (2-10, Jack, Queen, King, Ace), assigning proper values to each card.
     */
    public void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        // Iterate through each suit and rank to create the cards
        for (String suit : suits) {
            for (String rank : ranks) {
                int value = getCardValue(rank);
                // Add the card to the deck
                cards.add(new BlackjackCard(rank, suit, value));
            }
        }
    }
    
    private int getCardValue(String rank) {
        switch (rank) {
            case "A": return 11;
            case "K": case "Q": case "J": return 10;
            default: return Integer.parseInt(rank);
        }
    }
    
    // Draw a random card from the deck   
    public Card drawRandomCard() {
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        return cards.remove(index);
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
