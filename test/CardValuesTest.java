import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValuesTest {

    @Test
    void testToString() {
        assertSame("Dame",CardValues.Dame.toString());
    }

    @Test
    void AllCardValuesAreAvailable() {
        assertSame("Valet",CardValues.Valet.toString());
        assertSame("Dame",CardValues.Dame.toString());
        assertSame("Roi",CardValues.Roi.toString());
        assertSame("As",CardValues.As.toString());
        assertTrue("2".equalsIgnoreCase(CardValues.two.toString()));
        assertTrue("3".equalsIgnoreCase(CardValues.three.toString()));
        assertTrue("4".equalsIgnoreCase(CardValues.four.toString()));
        assertTrue("5".equalsIgnoreCase(CardValues.five.toString()));
        assertTrue("6".equalsIgnoreCase(CardValues.six.toString()));
        assertTrue("7".equalsIgnoreCase(CardValues.seven.toString()));
        assertTrue("8".equalsIgnoreCase(CardValues.height.toString()));
        assertTrue("9".equalsIgnoreCase(CardValues.nine.toString()));
        assertTrue("10".equalsIgnoreCase(CardValues.ten.toString()));
    }
    @Test
    void AllCardValuesTypeCanBeAbreviated() {
        assertSame("V",CardValues.Valet.getAbbreviated());
        assertSame("D",CardValues.Dame.getAbbreviated());
        assertSame("R",CardValues.Roi.getAbbreviated());
        assertSame("A",CardValues.As.getAbbreviated());
        assertTrue("2".equalsIgnoreCase(CardValues.two.getAbbreviated()));
        assertTrue("3".equalsIgnoreCase(CardValues.three.getAbbreviated()));
        assertTrue("4".equalsIgnoreCase(CardValues.four.getAbbreviated()));
        assertTrue("5".equalsIgnoreCase(CardValues.five.getAbbreviated()));
        assertTrue("6".equalsIgnoreCase(CardValues.six.getAbbreviated()));
        assertTrue("7".equalsIgnoreCase(CardValues.seven.getAbbreviated()));
        assertTrue("8".equalsIgnoreCase(CardValues.height.getAbbreviated()));
        assertTrue("9".equalsIgnoreCase(CardValues.nine.getAbbreviated()));
        assertTrue("10".equalsIgnoreCase(CardValues.ten.getAbbreviated()));
    }

    @Test
    void CanTestCardValue() {
        assertTrue(CardValues.isACardValue("Dame"));
        assertFalse(CardValues.isACardValue("Abracadabra"));
    }

    @Test
    void CanGetACardByValue() {
        assertSame(CardValues.two,CardValues.getCardValuesWithValue(2));
    }

    @Test
    void CanGetACardValuesValue() {
        assertSame(2,CardValues.two.getValue());
    }
}