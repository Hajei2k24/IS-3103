import java.util.*;

public class GroceryColleimport java.util.*;

public class GroceryCollections {
    public static void main(String[] args) {
        Map<String, Integer> groceryMap = new LinkedHashMap<>();
        groceryMap.put("Apples", 4);
        groceryMap.put("Bananas", 6);
        groceryMap.put("Milk", 2);
        groceryMap.put("Bread", 1);
        groceryMap.put("Eggs", 12);

        List<String> groceryList = new ArrayList<>();
        groceryList.add("Apples");
        groceryList.add("Oranges");
        groceryList.add("Milk");
        groceryList.add("Cereal");
        groceryList.add("Eggs");

        Set<String> grocerySet = new HashSet<>(groceryList);
        grocerySet.addAll(groceryMap.keySet());

        System.out.println("Map (item -> quantity): " + groceryMap);
        System.out.println("List (shopping order / duplicates allowed): " + groceryList);
        System.out.println("Set (unique items): " + grocerySet);
    }
}ctions {
    public static void main(String[] args) {
        Map<String, Integer> groceryMap = new LinkedHashMap<>();
        groceryMap.put("Apples", 4);
        groceryMap.put("Bananas", 6);
        groceryMap.put("Milk", 2);
        groceryMap.put("Bread", 1);
        groceryMap.put("Eggs", 12);

        List<String> groceryList = new ArrayList<>();
        groceryList.add("Apples");
        groceryList.add("Oranges");
        groceryList.add("Milk");
        groceryList.add("Cereal");
        groceryList.add("Eggs");

        Set<String> grocerySet = new HashSet<>(groceryList);
        grocerySet.addAll(groceryMap.keySet());

        System.out.println("Map (item -> quantity): " + groceryMap);
        System.out.println("List (shopping order / duplicates allowed): " + groceryList);
        System.out.println("Set (unique items): " + grocerySet);
    }
}
