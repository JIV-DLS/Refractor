import java.util.HashMap;
import java.util.Map;

enum CardColors {
    Trèfle("Trèfle","Tr"),
    Carreau("Carreau","Ca"),
    Coeur("Coeur","Co"),
    Pique("Pique","Pi");
    private String name="";
    private static Map map = new HashMap<>();

    static {
        for (CardColors cardColors : CardColors.values()) {
            map.put(cardColors.toString(), cardColors);
        }
    }

    public static CardColors getCardColorsWithColorName(String cardColor){
        return valueOf(cardColor);
    }
    public static CardColors getCardColorsWithColorNameAbbreviated(String cardColorAbbreviated){
        for (CardColors c : CardColors.values())
            if (c.getAbbreviated().equalsIgnoreCase((cardColorAbbreviated)))
                return c;
        return null;
    }
    public String getAbbreviated() {
        return abbreviation;
    }

    private String abbreviation ="";
    CardColors(String s,String abreviation) {
        name=s;
        this.abbreviation =abreviation;
    }
    public String toString(){
        return name;
    }

    static boolean isACardColor(String Type)
    {
        for (CardColors c : CardColors.values())
            if (c.toString().equals(Type))
                return true;
        return false;
    }
}