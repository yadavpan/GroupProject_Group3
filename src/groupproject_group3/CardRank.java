

package groupproject_group3;

/**
 * This class +++ Insert class description here +++
 *
 * @author yadavpan
 */
//This enum represents the rank of card associated with the value
public enum CardRank {
    
    //ranks of card with value
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    // The integer value associated with the rank.
    private final int cardvalue;

    //constructor for card rank enum 
    CardRank(int valueofcard1) {
        this.cardvalue = valueofcard1;
    }
    //This method return the integer value of the card
    public int getCardvalue() {
        return cardvalue;
    }
}

