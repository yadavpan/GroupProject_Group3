

package groupproject_group3;

/**
 * This class +++ Insert class description here +++
 *
 * @author yadavpan
 */
//This is our deck class
import java.util.*;

public class Deck {
    
    //This is our list of the cards.
    private LinkedList<Card> listofcards;

    //This constructor gives cards to the list
    //we have also used shuffle to randomize the cards
    public Deck() {
        listofcards = new LinkedList<>();
        
        for (CardSuit suitofcard1 : CardSuit.values()) {
            for (CardRank rankofcard1 : CardRank.values()) {
                listofcards.add(new Card(rankofcard1, suitofcard1));
            }
        }
        
        // card shuffling is done here 
        Collections.shuffle(listofcards);
    }

    // this method tells us about how many cards remain in the deck
    public boolean hasCards() {
        return !listofcards.isEmpty();
    }

    /**
     * Method for drawing card
     */
    public Card drawCard() {
        return listofcards.poll();
    }

    /**
     * method to add cards in the deck
     */
    public void collectCard(Card collectionofcardsindeck) {
        listofcards.add(collectionofcardsindeck);
    }

    /**
     * Method for shuffling
     */
    public void shuffle() {
        Collections.shuffle(listofcards);
    }

    /**
     * method about how many cards are left.
     */
    public int remainingCards() {
        return listofcards.size();
    }

    /**
     * Another way to check if we've got any cards left.
     */
    public boolean hasMoreCards() {
        return !listofcards.isEmpty();
    }
    
}

