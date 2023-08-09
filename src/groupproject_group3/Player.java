

package groupproject_group3;

/**
 * This class +++ Insert class description here +++
 *
 * @author yadavpan
 */
import java.util.*;

public class Player {
    private String name;
    private LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();  // Initialize the cards list
    }

    /**
     * Draws the top card from the player's deck.
     */
    public Card drawCard() {
        return cards.poll();
    }

   

    /**
     * Checks if the player has any cards left.
     */
    public boolean hasCards() {
        return !cards.isEmpty();
    }

    /**
     * Returns the number of cards remaining with the player.
     */
    public int remainingCards() {
        return cards.size();
    }

    public String getName() {
        return name;
    }
    public void addCard(Card... newCards) {
        for (Card card : newCards) {
            cards.add(card);
        }
    }
    public void addCards(Card... cardsToAdd) {
        for (Card card : cardsToAdd) {
            this.cards.add(card);
        }
    }
    
}

