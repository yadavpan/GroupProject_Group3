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
public class CardTest {
    
    public CardTest() {
    }
    
    // Good Test
    @Test
    public void validateCardRepresentation() {
        Card sampleCard = new Card(CardRank.KING, CardSuit.SPADES);
        assertEquals("KING---of---SPADES", sampleCard.toString());
    }

    // Boundary Tests
    @Test
    public void confirmCardMinimumValue() {
        Card sampleCard = new Card(CardRank.TWO, CardSuit.DIAMONDS);
        assertEquals(2, sampleCard.getValue());
    }

    @Test
    public void verifyMaximumCardValue() {
        Card sampleCard = new Card(CardRank.ACE, CardSuit.HEARTS);
        assertEquals(14, sampleCard.getValue());
    }
    
}
