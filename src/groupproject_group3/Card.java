

package groupproject_group3;

/**
 * This class +++ Insert class description here +++
 *
 * @author yadavpan
 */
/*
 * This class is used to represent the card and the deck.
 * Group memebers Pankaj-Yadav,Jasmeet-Kaur,Haramanpreet-Kaur,Lovepreet-Kaur
 */
public class Card {
    
    private CardSuit Suitsofcard;
    //suit variable for storing the suit of card example spades,diamonds
    private CardRank Ranksofcard;
    //rank variable for storing the rank of the card
    
    //Implementation of the two parameter constructor
    //this is not the default constructor
    public Card(CardRank cardranked, CardSuit decksuit) {
        this.Ranksofcard = cardranked;
        this.Suitsofcard = decksuit;
    }
    //represents suit and rank of the card
    @Override
    public String toString() {
        return Ranksofcard + "---of---" + Suitsofcard;
    }
    //This method gets the value of the card by rank.
    public int getValue() {
        return Ranksofcard.getCardvalue();
    }

}

