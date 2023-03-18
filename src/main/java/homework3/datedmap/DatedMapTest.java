package homework3.datedmap;

public class DatedMapTest {
    public static void main(String[] args) {
        DatedMap datedMap = new DatedMapImpl();
        datedMap.put("1", "a");
        datedMap.put("2", "b");
        datedMap.put("3", "c");
        datedMap.put("4", "d");
        datedMap.put("5", "e");
        System.out.println(datedMap.keySet());
        System.out.println(datedMap.containsKey("4"));
        System.out.println(datedMap.get("4"));
        System.out.println(datedMap.getKeyLastInsertionDate("4"));
        datedMap.put("4", "f");
        System.out.println(datedMap.get("4"));
        System.out.println(datedMap.getKeyLastInsertionDate("4"));
        datedMap.remove("4");
        System.out.println(datedMap.keySet());
        System.out.println(datedMap.containsKey("4"));
        System.out.println(datedMap.get("4"));
        System.out.println(datedMap.getKeyLastInsertionDate("4"));
    }
}
