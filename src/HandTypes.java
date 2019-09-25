import java.util.HashMap;
import java.util.Map;

enum HandTypes {
    PlusHauteCarte("Plus haute Carte",0),
    Paire("Paire",1),
    DPaire("Double Paire",2),
    Brelan("Brelan",3),
    Suite("Suite",4),
    Couleur("Couleur",5),
    Full("Full",6),
    Carre("Carre",7),
    QuinteFlush("Quinte Flush",8);
    private String name="";

    public Integer getPriority() {
        return priority;
    }

    private Integer priority=0;
    private static Map map = new HashMap<>();

    static {
        for (HandTypes handTypes : HandTypes.values()) {
            map.put(handTypes.priority, handTypes);
        }
    }

    public static HandTypes valueOf(int handType) {
        return (HandTypes) map.get(handType);
    }
    public static HandTypes Priority(int handType) {
        return valueOf(handType);
    }
    HandTypes(String name,Integer priority) {
        this.name=name;
        this.priority=priority;
    }
    public String toString(){
        return name;
    }
    static boolean isAHandType(String Type)
    {
        for (HandTypes c : HandTypes.values())
            if (c.toString().equals(Type))
                return true;
        return false;
    }
}