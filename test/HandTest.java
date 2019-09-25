
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private Hand hand;
    private ArrayList<Hand> handsTypeSuite,handsNotTypeSuite;
    private ArrayList<Hand> handsTypeCouleur,handsNotTypeCouleur;
    private ArrayList<Hand> handsTypeQuinteFlush,handsNotTypeQuinteFlush;
    private ArrayList<Hand> handsTypePair,handsNotTypePair;
    private ArrayList<Hand> handsTypeBrelan,handsNotTypeBrelan;
    private ArrayList<Hand> handsTypeDeuxPaires,handsNotTypeDeuxPaires;
    private ArrayList<Hand> handsTypeCarre,handsNotTypeCarre;
    private Card carda,cardb,cardc,cardd,carde;
    @BeforeEach
    void initiate(){
        carda=new Card("Trèfle",2);
        cardb=new Card(4,"Tr");
        cardc=new Card(6,"Tr");
        cardd=new Card(8,"Tr");
        carde=new Card(11,"Tr");
        hand=new Hand(carda,cardb,cardc,cardd,carde);
    }
    @Test
    void getHand() {
        ArrayList<Card> recup=new ArrayList<>();
        recup.add(carda);
        recup.add(cardb);
        recup.add(cardc);
        recup.add(cardd);
        recup.add(carde);

        assertEquals(recup, hand.getHand());
    }

    @Test
    void canGetType() {
        hand.setType(HandTypes.Paire);
        assertEquals("Paire",hand.getType());
    }

    @Test
    void canSetType() {
        hand.setType(HandTypes.Paire);
        assertSame("Paire",hand.getType());
    }

    @Test
    void canVerifyAnHandType() {
        assertTrue(HandTypes.isAHandType("Paire"));
    }

    @Test
    void VerifyWeHave9HandType(){
        assertTrue(9==HandTypes.values().length);
    }

    @Test
    void VerifyItIsAHandTypeSuite(){
        handsTypeSuite =new ArrayList<Hand>();

        handsTypeSuite.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Tr"),
                new Card(4,"Tr"),
                new Card(5,"Tr"),
                new Card(6,"Tr"),
                "Suite de même couleur de valeurs croissantes"
        ));
        handsTypeSuite.add(new Hand(
                new Card(6,"Tr"),
                new Card(5,"Tr"),
                new Card(4,"Tr"),
                new Card(3,"Tr"),
                new Card(2,"Tr"),
                "Suite de même couleur de valeurs décroissantes"
        ));
        handsTypeSuite.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Ca"),
                new Card(4,"Co"),
                new Card(5,"Ca"),
                new Card(6,"Pi"),
                "Suite de différentes couleurs de valeurs croissantes"
        ));
        handsNotTypeSuite=new ArrayList<Hand>();

        handsNotTypeSuite.add (new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr"),
                "Pas de type Suite (toutes valeurs différentes)"
        ));
        handsNotTypeSuite.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Ca"),
                new Card(4,"Co"),
                new Card(5,"Ca"),
                new Card(5,"Pi"),
                "Pas de type Suite (Valeurs consécutives sauf les deux dernieres qui sont égales)"
        ));
        handsNotTypeSuite.add(new Hand(
                new Card(2,"Tr"),
                new Card(2,"Ca"),
                new Card(4,"Co"),
                new Card(5,"Ca"),
                new Card(6,"Pi"),
                "Pas de type Suite (2 premières valeurs égaux puis le reste consécutif)"
        ));
        handsNotTypeSuite.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Ca"),
                new Card(4,"Co"),
                new Card(5,"Ca"),
                new Card(4,"Pi"),
                "Premières valeurs Consécutives jusqu'à dernière qui est inférieure"
        ));

        System.out.println("\n\n***Total ("+(handsTypeSuite.size()+handsNotTypeSuite.size())+") Tests***\n\nTests Positifs : "+handsTypeSuite.size()+" | Tests Négatifs: "+handsNotTypeSuite.size());

        System.out.println("***Tests Positifs Effectués***");
        for (Hand h:handsTypeSuite){ h.printTestLabel(); assertTrue(h.isASuite());}
        System.out.println("***Tests Négatifs Effectué***");
        for (Hand h:handsNotTypeSuite){ h.printTestLabel();assertFalse(h.isASuite());}
    }
    @Test
    void VerifyItIsAHandTypeCouleur(){
        handsTypeCouleur =new ArrayList<Hand>();

        handsTypeCouleur.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Tr"),
                new Card(4,"Tr"),
                new Card(5,"Tr"),
                new Card(6,"Tr"),
                "Toutes les cartes de même couleurs et de valeurs consécutives croissantes"
        ));

        handsTypeCouleur.add(new Hand(
                new Card(6,"Tr"),
                new Card(5,"Tr"),
                new Card(4,"Tr"),
                new Card(3,"Tr"),
                new Card(2,"Tr"),
                "Toutes les cartes de même couleurs et de valeurs consécutives décroissantes"
        ));

        handsTypeCouleur.add(new Hand(
                new Card(6,"Ca"),
                new Card(5,"Ca"),
                new Card(4,"Ca"),
                new Card(3,"Ca"),
                new Card(2,"Ca"),
                "test avec une autre type de couleur"
        ));

        handsNotTypeCouleur=new ArrayList<Hand>();

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont aucune ne se suivent)"
        ));

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Tr"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont deux premières se suivent)"
        ));

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Tr"),
                new Card(2,"Tr"),
                new Card(11,"Ca"),
                new Card(10,"Tr"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont trois premières se suivent)"
        ));

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Tr"),
                new Card(2,"Tr"),
                new Card(11,"Tr"),
                new Card(10,"Ca"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont quatre premières se suivent)"
        ));

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Ca"),
                new Card(8,"Tr"),
                new Card(2,"Tr"),
                new Card(11,"Tr"),
                new Card(10,"Tr"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont quatre dernières se suivent)"
        ));

        handsNotTypeCouleur.add(new Hand(
                new Card(6,"Ca"),
                new Card(8,"Tr"),
                new Card(2,"Ca"),
                new Card(11,"Tr"),
                new Card(10,"Tr"),
                "Pas de type Couleurs( Toutes couleurs mélangés dont deux dernière se suivent)"
        ));
        System.out.println("\n\n***Total ("+(handsTypeCouleur.size()+handsNotTypeCouleur.size())+") Tests***\n\nTests Positifs : "+handsTypeCouleur.size()+" | Tests Négatifs: "+handsNotTypeCouleur.size());
        System.out.println("***Tests Positifs***");
        for (Hand h:handsTypeCouleur){ h.printTestLabel();assertTrue(h.isACouleur());}
        System.out.println("***Tests Négatifs***");
        for (Hand h:handsNotTypeCouleur){ h.printTestLabel();assertFalse(h.isACouleur());}
    }

    @Test
    void VerifyIfHandCategorieIsDeuxPaires(){
        handsTypeDeuxPaires =new ArrayList<Hand>();
        System.out.println("***Tests Positifs***");
        System.out.println("Est deux paires(11,6) (deux premieres et deux dernieres cartes de meme valeur) doit renvoyer true");
        //Est une paire(11) (deux premieres cartes de meme valeur) doit renvoyer true
        handsTypeDeuxPaires.add(new Hand(
                new Card(11,"Tr"),
                new Card(11,"Ca"),
                new Card(4,"Tr"),
                new Card(6,"Tr"),
                new Card(6,"Tr")
        ));
        System.out.println("Est deux paires(8,6) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypeDeuxPaires.add(new Hand(
                new Card(11,"Pi"),
                new Card(6,"Tr"),
                new Card(8,"Co"),
                new Card(6,"Ca"),
                new Card(8,"Tr")
        ));

        System.out.println("Est deux paires(8,6) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypeDeuxPaires.add(new Hand(
                new Card(8,"Pi"),
                new Card(6,"Tr"),
                new Card(8,"Co"),
                new Card(6,"Ca"),
                new Card(8,"Tr")
        ));

        handsNotTypeDeuxPaires=new ArrayList<Hand>();
        System.out.println("***Tests Négatifs***");
        System.out.println("***Est une paire doit renvoyer false***");
        //Est une deux paire doit renvoyer false
        handsNotTypeDeuxPaires.add(new Hand(
                new Card(2,"Tr"),
                new Card(9,"Pi"),
                new Card(11,"Co"),
                new Card(9,"Ca"),
                new Card(6,"Pi")
        ));
        System.out.println("***Est une main quelconque doit renvoyer false***");
        //Est une main quelconque doit renvoyer false
        handsNotTypeDeuxPaires.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr")
        ));
        System.out.println("\n\n***Total***\n\nTests Positifs : "+handsTypeDeuxPaires.size()+" | Tests Négatifs: "+handsNotTypeDeuxPaires.size());

        for (Hand h:handsTypeDeuxPaires) assertTrue(h.isDeuxPaires());
        for (Hand h:handsNotTypeDeuxPaires) assertFalse(h.isDeuxPaires());
    }

    @Test
    void VerifyIfHandCategorieIsPair(){
        handsTypePair =new ArrayList<Hand>();
        System.out.println("***Tests Positifs***");
        System.out.println("Est une paire(11) (deux premieres cartes de meme valeur) doit renvoyer true");
        //Est une paire(11) (deux premieres cartes de meme valeur) doit renvoyer true
        handsTypePair.add(new Hand(
                new Card(11,"Tr"),
                new Card(11,"Ca"),
                new Card(4,"Tr"),
                new Card(5,"Tr"),
                new Card(6,"Tr")
        ));
        System.out.println("Est une paire(8) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypePair.add(new Hand(
                new Card(6,"Pi"),
                new Card(11,"Tr"),
                new Card(8,"Co"),
                new Card(3,"Ca"),
                new Card(8,"Tr")
        ));


        handsNotTypePair=new ArrayList<Hand>();
        System.out.println("***Tests Négatifs***");
        System.out.println("***Est une deux paire doit renvoyer false***");
        //Est une deux paire doit renvoyer false
        handsNotTypePair.add(new Hand(
                new Card(2,"Tr"),
                new Card(9,"Pi"),
                new Card(6,"Co"),
                new Card(9,"Ca"),
                new Card(6,"Pi")
        ));

       System.out.println("***Est un brelan (9 qui se suivent) doit renvoyer false***");
        //Est une deux paire doit renvoyer false
        handsNotTypePair.add(new Hand(
                new Card(2,"Tr"),
                new Card(9,"Pi"),
                new Card(9,"Co"),
                new Card(9,"Ca"),
                new Card(6,"Pi")
        ));
        System.out.println("***Est un brelan (9 qui ne se suivent pas) doit renvoyer false***");
        //Est une deux paire doit renvoyer false
        handsNotTypePair.add(new Hand(
                new Card(2,"Tr"),
                new Card(9,"Pi"),
                new Card(4,"Co"),
                new Card(9,"Ca"),
                new Card(9,"Pi")
        ));

        System.out.println("***Est une main quelconque doit renvoyer false***");
        //Est une main quelconque doit renvoyer false
        handsNotTypePair.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr")
        ));
        System.out.println("\n\n***Total***\nTests Positifs : "+handsTypePair.size()+" | Tests Négatifs: "+handsNotTypePair.size());

        for (Hand h:handsTypePair) assertTrue(h.isAPair());
        for (Hand h:handsNotTypePair) assertFalse(h.isAPair());
    }


    @Test
    void VerifyIfHandCategorieIsBrelan(){
        handsTypeBrelan =new ArrayList<Hand>();
        System.out.println("***Tests Positifs***");
        System.out.println("Est une brelan(11) (trois premieres cartes de meme valeur) doit renvoyer true");
        //Est une paire(11) (deux premieres cartes de meme valeur) doit renvoyer true
        handsTypeBrelan.add(new Hand(
                new Card(11,"Tr"),
                new Card(11,"Ca"),
                new Card(11,"Co"),
                new Card(5,"Tr"),
                new Card(6,"Tr")
        ));

        System.out.println("Est une brelan(8) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypeBrelan.add(new Hand(
                new Card(8,"Pi"),
                new Card(11,"Tr"),
                new Card(8,"Co"),
                new Card(3,"Ca"),
                new Card(8,"Tr")
        ));

        System.out.println("Est une brelan(6) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypeBrelan.add(new Hand(
                new Card(2,"Pi"),
                new Card(11,"Tr"),
                new Card(6,"Co"),
                new Card(6,"Ca"),
                new Card(6,"Tr")
        ));


       handsNotTypeBrelan=new ArrayList<Hand>();
        System.out.println("***Tests Négatifs***");
        System.out.println("***Est un carré doit renvoyer false***");
        handsNotTypeBrelan.add(new Hand(
                new Card(6,"Tr"),
                new Card(6,"Ca"),
                new Card(6,"Co"),
                new Card(11,"Ca"),
                new Card(6,"Ca")
        ));
        System.out.println("***Est une main quelconque doit renvoyer false***");
        handsNotTypeBrelan.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr")
        ));
        System.out.println("\n\n***Total***\n\nTests Positifs : "+handsTypeBrelan.size()+" | Tests Négatifs: "+handsNotTypeBrelan.size());
        for (Hand h:handsTypeBrelan) assertTrue(h.isBrelan());
        for (Hand h:handsNotTypeBrelan) assertFalse(h.isBrelan());
    }
    @Test
    void VerifyIfHandCategorieIsCarre(){
        handsTypeCarre =new ArrayList<Hand>();
        System.out.println("***Tests Positifs***");
        System.out.println("Est un carre(11) (quatre premieres cartes de meme valeur) doit renvoyer true");
        //Est une paire(11) (deux premieres cartes de meme valeur) doit renvoyer true
        handsTypeCarre.add(new Hand(
                new Card(11,"Tr"),
                new Card(11,"Ca"),
                new Card(11,"Co"),
                new Card(11,"Tr"),
                new Card(6,"Tr")
        ));
        System.out.println("Est un carre(8) aussi (avec des positions differentes) doit renvoyer true");
        //Est une paire(8) aussi (avec des positions differentes) doit renvoyer true
        handsTypeCarre.add(new Hand(
                new Card(11,"Pi"),
                new Card(8,"Tr"),
                new Card(8,"Co"),
                new Card(8,"Ca"),
                new Card(8,"Tr")
        ));

        handsNotTypeCarre=new ArrayList<Hand>();
        System.out.println("***Tests Négatifs***");
        System.out.println("***Est un brelan doit renvoyer false***");
        handsNotTypeCarre.add(new Hand(
                new Card(6,"Tr"),
                new Card(6,"Ca"),
                new Card(8,"Co"),
                new Card(11,"Ca"),
                new Card(6,"Ca")
        ));
        System.out.println("***Est un quinteflush doit renvoyer false***");
        handsNotTypeCarre.add(new Hand(
                new Card(6,"Tr"),
                new Card(6,"Ca"),
                new Card(6,"Co"),
                new Card(6,"Ca"),
                new Card(6,"Ca")
        ));

        System.out.println("***Est une main quelconque doit renvoyer false***");
        handsNotTypeCarre.add(new Hand(
                new Card(6,"Tr"),
                new Card(8,"Ca"),
                new Card(2,"Co"),
                new Card(11,"Ca"),
                new Card(10,"Tr")
        ));
        System.out.println("\n\n***Total***\n\nTests Positifs : "+handsTypeCarre.size()+" | Tests Négatifs: "+handsNotTypeCarre.size());
        for (Hand h:handsTypeCarre) assertTrue(h.isCarre());
        for (Hand h:handsNotTypeCarre) assertFalse(h.isCarre());
    }

    @Test
    void VerifyItIsAHandTypeQuintFlush(){
        handsTypeQuinteFlush=new ArrayList<Hand>();
        handsTypeQuinteFlush.add(new Hand(
                new Card(2,"Tr"),
                new Card(3,"Tr"),
                new Card(4,"Tr"),
                new Card(5,"Tr"),
                new Card(6,"Tr"),
                "Main de type quinteFlush valeurs consécutives croissantes partant de 2 et couleur Trèfle"
        ));

        handsTypeQuinteFlush.add(new Hand(
                new Card(8,"Ca"),
                new Card(9,"Ca"),
                new Card(10,"Ca"),
                new Card(11,"Ca"),
                new Card(12,"Ca"),
                "Main de type quinteFlush valeurs consécutives croissantes partant de 8 et couleur Carreau"
        ));

        handsTypeQuinteFlush.add(new Hand(
                new Card(12,"Ca"),
                new Card(11,"Ca"),
                new Card(10,"Ca"),
                new Card(9,"Ca"),
                new Card(8,"Ca"),
                "Main de type quinteFlush valeurs consécutives décroissantes partant de 12 et couleur Carreau"
        ));

        handsNotTypeQuinteFlush=new ArrayList<Hand>();

        handsNotTypeQuinteFlush.add(new Hand(
                new Card(12,"Ca"),
                new Card(11,"Ca"),
                new Card(5,"Ca"),
                new Card(9,"Ca"),
                new Card(8,"Ca"),
                "Main de non type quinteFlush valeurs consécutives décroissantes partant de 12 (2 premières valeurs consecutives sauf troisième sortant du lot) et couleur Carreau"
        ));

        handsNotTypeQuinteFlush.add(new Hand(
                new Card(8,"Ca"),
                new Card(9,"Ca"),
                new Card(5,"Ca"),
                new Card(10,"Ca"),
                new Card(11,"Ca"),
                "Main de non type quinteFlush valeurs consécutives croissante partant de 8 (2 premières valeurs consecutives sauf troisième sortant du lot) et couleur Carreau"
        ));

        handsNotTypeQuinteFlush.add(new Hand(
                new Card(7,"Ca"),
                new Card(8,"Ca"),
                new Card(9,"Pi"),
                new Card(10,"Ca"),
                new Card(11,"Ca"),
                "Main de non type quinteFlush valeurs consécutives croissante partant de 7 et couleur Carreau sauf 3eme qui est Pique"
        ));

        handsNotTypeQuinteFlush.add(new Hand(
                new Card(7,"Ca"),
                new Card(8,"Ca"),
                new Card(9,"Pi"),
                new Card(10,"Tr"),
                new Card(11,"Ca"),
                "Main de non type quinteFlush valeurs consécutives croissante partant de 7 et couleur Carreau sauf 3eme qui est Pique et 4eme qui est Trèfle"
        ));

        handsNotTypeQuinteFlush.add(new Hand(
                new Card(7,"Co"),
                new Card(13,"Ca"),
                new Card(9,"Pi"),
                new Card(2,"Tr"),
                new Card(11,"Ca"),
                "Main de non type quinteFlush (Carte quelconque)"
        ));

        System.out.println("\n\n***Total ("+(handsTypeQuinteFlush.size()+handsNotTypeQuinteFlush.size())+") Tests***\n\nTests Positifs : "+handsTypeQuinteFlush.size()+" | Tests Négatifs: "+handsNotTypeQuinteFlush.size());
        System.out.println("***Tests Positifs***");
        for (Hand h:handsTypeQuinteFlush) { h.printTestLabel(); assertTrue(h.isAQuinteFlush());}
        System.out.println("***Tests Négatifs***");
        for (Hand h:handsNotTypeQuinteFlush) {h.printTestLabel(); assertFalse(h.isAQuinteFlush());}
    }
}