/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package groupproject_group3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author panka
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    // Good Test
    @Test
    public void ensureDeckIntegrityAtStart() {
        Deck freshDeck = new Deck();
        assertTrue(freshDeck.hasCards());
        assertEquals(52, freshDeck.remainingCards());
    }

    // Boundary Tests
    @Test
    public void validateFirstCardDraw() {
        Deck freshDeck = new Deck();
        assertNotNull(freshDeck.drawCard());
        assertEquals(51, freshDeck.remainingCards());
    }

    // Bad Test
    @Test
    public void attemptDrawingFromEmptyDeck() {
        Deck freshDeck = new Deck();
        for (int count = 0; count < 52; count++) {
            freshDeck.drawCard();
        }
        assertNull(freshDeck.drawCard());
    }
    @Test
    public void testShuffle() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffle();
        assertNotEquals(deck1.drawCard(), deck2.drawCard());
    }

    @Test
    public void testCollectCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        deck.collectCard(card);
        assertEquals(52, deck.remainingCards());
    }
    
}
