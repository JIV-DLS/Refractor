import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardColorsTest {

    @Test
    void testToString() {
        assertSame("Trèfle",CardColors.Trèfle.toString());
    }

    @Test
    void AllCardColorTypeAreAvailable() {
        assertSame("Trèfle",CardColors.Trèfle.toString());
        assertSame("Pique",CardColors.Pique.toString());
        assertSame("Coeur",CardColors.Coeur.toString());
        assertSame("Carreau",CardColors.Carreau.toString());
    }
    @Test
    void AllCardColorCanBeAbreviated() {
        assertTrue("Tr".equalsIgnoreCase(CardColors.Trèfle.getAbbreviated()));
        assertTrue("Pi".equalsIgnoreCase(CardColors.Pique.getAbbreviated()));
        assertTrue("Co".equalsIgnoreCase(CardColors.Coeur.getAbbreviated()));
        assertTrue("Ca".equalsIgnoreCase(CardColors.Carreau.getAbbreviated()));
    }
    @Test
    void CanTestCardColor() {
        assertTrue(CardColors.isACardColor("Trèfle"));
        assertFalse(CardColors.isACardColor("Abracadabra"));
    }
    @Test
    void CanGetACardColorByColorName() {
        assertSame(CardColors.Trèfle,CardColors.getCardColorsWithColorName("Trèfle"));
    }
    @Test
    void CanGetACardColorByColorNameAbbreviated() {
        assertSame(CardColors.Trèfle,CardColors.getCardColorsWithColorNameAbbreviated("Tr"));
    }

}