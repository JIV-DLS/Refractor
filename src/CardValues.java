import java.util.HashMap;
import java.util.Map;

enum CardValues {
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    height(8),
    nine(9),
    ten(10),
    Valet("Valet","V",11),
    Dame("Dame","D",12),
    Roi("Roi","R",13),
    As("As","A",14);

    private String name="CardName";

    public String getAbbreviated() {
        return abbrevation;
    }

    private String abbrevation ="CardAbreviation";
    private int value;
    private static Map map = new HashMap<>();

    static {
        for (CardValues pageType : CardValues.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static CardValues valueOf(int cardValue) {
        return (CardValues) map.get(cardValue);
    }

    public static CardValues getCardValuesWithValue(int cardValue){
        return valueOf(cardValue);
    }

    public int getValue() {
        return value;
    }
    CardValues(String name,String abbrevation,Integer value) {
        this.name=name;
        this.abbrevation =abbrevation;
        this.value=value;
    }
    CardValues(Integer value) {
        name=""+value;
        this.abbrevation =""+value;
        this.value=value;
    }
    public String toString(){
        return name;
    }
    static boolean isACardValue(String Type)
    {
        for (CardValues c : CardValues.values())
            if (c.toString().equals(Type))
                return true;
        return false;
    }
}