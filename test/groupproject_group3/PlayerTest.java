/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package groupproject_group3;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pankaj
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    // Good Test
    @Test
    public void ascertainPlayerInitialization() {
        Player testPlayer = new Player("Alice");
        assertEquals("Alice", testPlayer.getName());
        assertFalse(testPlayer.hasCards());
    }

    // Boundary Test
    @Test
    public void confirmSingleCardAdditionToPlayer() {
        Player testPlayer = new Player("Alice");
        Card testCard = new Card(CardRank.SEVEN, CardSuit.CLUBS);
        testPlayer.addCard(testCard);
        assertTrue(testPlayer.hasCards());
        assertEquals(1, testPlayer.remainingCards());
    }

    // Bad Test
    @Test
    public void attemptDrawingWithoutCards() {
        Player testPlayer = new Player("Alice");
        assertNull(testPlayer.drawCard());
    }
    @Test
    public void testAddCardsMultiple() {
        Player player = new Player("Bob");
        Card card1 = new Card(CardRank.TEN, CardSuit.HEARTS);
        Card card2 = new Card(CardRank.JACK, CardSuit.SPADES);
        player.addCards(card1, card2);
        assertEquals(2, player.remainingCards());
    }

    @Test
    public void testDrawCardOrder() {
        Player player = new Player("Charlie");
        Card card1 = new Card(CardRank.QUEEN, CardSuit.DIAMONDS);
        Card card2 = new Card(CardRank.KING, CardSuit.CLUBS);
        player.addCards(card1, card2);
        assertEquals(card1, player.drawCard());
        assertEquals(card2, player.drawCard());
    }
    
}
