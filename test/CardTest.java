import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.*;

class CardTest {


    private Card carte;
    private Card carteSup;
    private Card carteInf;

    @BeforeEach
    void Carte(){
        carte = new Card(CardColors.Trèfle,CardValues.ten);
        carteSup = new Card(CardColors.Carreau,CardValues.Dame);
        carteInf = new Card(CardColors.Pique,CardValues.nine);
    }

    @Test
    void CanGetCardValue()
    {
        assertSame(CardValues.ten,carte.getValue());
    }
    @Test
    void CanGetCardValour()
    {
        assertSame(10,carte.getValour());
    }

    @Test
    void CanGetCardColor()
    {
        assertSame(CardColors.Trèfle,carte.getColour());
    }

    @Test
    void CanDisplayCard()
    {
        assertTrue("Tentative d'affichage d'une carte","10Tr".equalsIgnoreCase(carte.toString()));
    }

    @Test
    void CanCompareCardSuperior()
    {
        assertTrue("Etat de la méthode de supériorité!",carte.superiorTo(carteInf));
    }

    @Test
    void CanCompareCardInferior()
    {
        assertTrue("Etat de la méthode d'infériorité'!",carte.inferiorTo(carteSup));
    }
    @Test
    void CanEqualCard()
    {
        assertTrue("Etat de la méthode d'égalité'!",carte.equalsTo(carte));
    }
}