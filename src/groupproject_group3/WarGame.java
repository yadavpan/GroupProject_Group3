

package groupproject_group3;

/**
 * This class +++ Insert class description here +++
 *
 * @author yadavpan
 */
import java.util.*;

/**
 * The WarGame class simulates the card game "War" between two players.
 */
public class WarGame {
    private final Player participant1;  // First player
    private final Player participant2;  // Second player
    private final Scanner inputScanner; // Scanner to read user input

    /**
     * Constructor initializes the game, distributes cards to players.
     */
    public WarGame(String name1, String name2) {
        this.participant1 = new Player(name1);
        this.participant2 = new Player(name2);
        this.inputScanner = new Scanner(System.in);
        
        Deck cardDeck = new Deck();  // Create a new deck of cards
        cardDeck.shuffle();          // Shuffle the deck
        
        // Distribute cards to players alternately
        while (cardDeck.hasMoreCards()) {
            participant1.addCard(cardDeck.drawCard());
            participant2.addCard(cardDeck.drawCard());
        }
    }

    /**
     * Simulates the game play for the card game "War".
     */
    public void startGame() {
        System.out.println("Welcome to the War card game!");
        System.out.println(participant1.getName() + " vs. " + participant2.getName());
        System.out.println("Let the battle begin!\n");

        int roundCounter = 0;  // Counter to track number of rounds
        final int ROUNDS_LIMIT = 26;  // Maximum number of rounds

        // Continue the game while both players have cards and we haven't reached the max rounds
        while (participant1.hasCards() && participant2.hasCards() && roundCounter < ROUNDS_LIMIT) {
            roundCounter++;
            System.out.println("\nRound " + roundCounter);
            System.out.println("Type 'draw' for " + participant1.getName() + " to draw a card.");
            
            // Wait for user to type 'draw' to continue
            while (!"draw".equalsIgnoreCase(inputScanner.nextLine())) {
                System.out.println("Please type 'draw' to proceed.");
            }

            // Players draw cards
            Card card1 = participant1.drawCard();
            Card card2 = participant2.drawCard();

            System.out.println(participant1.getName() + " drew: " + card1);
            System.out.println(participant2.getName() + " drew: " + card2);

            // Determine the winner of the round
            if (card1.getValue() > card2.getValue()) {
                participant1.addCards(card1, card2);
                System.out.println(participant1.getName() + " takes this round!");
            } else if (card1.getValue() < card2.getValue()) {
                participant2.addCards(card1, card2);
                System.out.println(participant2.getName() + " takes this round!");
            } else {
                // In case of a tie, a war is initiated
                System.out.println("War begins!");
                List<Card> warCards = new ArrayList<>();
                warCards.add(card1);
                warCards.add(card2);

                boolean warEnded = false;
                // Continue the war until a winner is determined or players run out of cards
                while (!warEnded && participant1.hasCards() && participant2.hasCards()) {
                    System.out.println("Drawing three cards for the war...");
                    for (int i = 0; i < 3 && participant1.hasCards() && participant2.hasCards(); i++) {
                        Card warDraw1 = participant1.drawCard();
                        Card warDraw2 = participant2.drawCard();
                        System.out.println(participant1.getName() + " drew: " + warDraw1);
                        System.out.println(participant2.getName() + " drew: " + warDraw2);
                        warCards.add(warDraw1);
                        warCards.add(warDraw2);
                    }

                    System.out.println("Press Enter for the decisive war card draw.");
                    inputScanner.nextLine();

                    Card warCard1 = participant1.drawCard();
                    Card warCard2 = participant2.drawCard();

                    System.out.println(participant1.getName() + " drew for war: " + warCard1);
                    System.out.println(participant2.getName() + " drew for war: " + warCard2);

                    warCards.add(warCard1);
                    warCards.add(warCard2);

                    // Determine the winner of the war
                    if (warCard1.getValue() > warCard2.getValue()) {
                        participant1.addCards(warCards.toArray(new Card[0]));
                        System.out.println(participant1.getName() + " wins the war!");
                        warEnded = true;
                    } else if (warCard1.getValue() < warCard2.getValue()) {
                        participant2.addCards(warCards.toArray(new Card[0]));
                        System.out.println(participant2.getName() + " wins the war!");
                        warEnded = true;
                    } else {
                        System.out.println("War continues!");
                    }
                }
            }
        }

        // Determine and display the overall winner
        int cards1 = participant1.remainingCards();
        int cards2 = participant2.remainingCards();

        if (cards1 > cards2) {
            System.out.println("\n" + participant1.getName() + " is the winner with " + cards1 + " cards!");
            System.out.println(participant2.getName() + " has " + cards2 + " cards left.");
        } else if (cards1 < cards2) {
            System.out.println("\n" + participant2.getName() + " is the winner with " + cards2 + " cards!");
            System.out.println(participant1.getName() + " has " + cards1 + " cards left.");
        } else {
            System.out.println("\nIt's a draw! Both have " + cards1 + " cards.");
        }
    }

    /**
     * Main method to start the game.
     */
    public static void main(String[] args) {
        WarGame gameInstance = new WarGame("First Player", "Second Player");
        gameInstance.startGame();
    }
}

