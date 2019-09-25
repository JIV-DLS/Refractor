import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTypesTest {

    @Test
    void testToString() {
        assertSame("Suite",HandTypes.Suite.toString());
    }

    @Test
    void AllHandTypeAreAvailable() {
        assertTrue("Plus haute carte".equalsIgnoreCase(HandTypes.PlusHauteCarte.toString()));
        assertTrue("Paire".equalsIgnoreCase(HandTypes.Paire.toString()));
        assertTrue("Double Paire".equalsIgnoreCase(HandTypes.DPaire.toString()));
        assertTrue("Brelan".equalsIgnoreCase(HandTypes.Brelan.toString()));
        assertTrue("Suite".equalsIgnoreCase(HandTypes.Suite.toString()));
        assertTrue("Couleur".equalsIgnoreCase(HandTypes.Couleur.toString()));
        assertTrue("Full".equalsIgnoreCase(HandTypes.Full.toString()));
        assertTrue("Carre".equalsIgnoreCase(HandTypes.Carre.toString()));
        assertTrue("Quinte Flush".equalsIgnoreCase(HandTypes.QuinteFlush.toString()));
    }
    @Test
    void CanTestHandType() {
        assertTrue(HandTypes.isAHandType("Suite"));
        assertFalse(HandTypes.isAHandType("Abracadabra"));
    }

    @Test
    void CanGetAHandTypeByPrioryty() {
        assertSame(HandTypes.Suite,HandTypes.Priority(4));
    }

    @Test
    void CanGetAHandTypePrioryty() {
        assertSame(4,HandTypes.Suite.getPriority());
    }
}