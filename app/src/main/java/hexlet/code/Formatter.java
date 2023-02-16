package hexlet.code;


import java.util.*;

public class Formatter {

    public static List<Node> format(Map<String, Object> map, Map<String, Object> map1) {

        List<Node> mergeDataOfTwoFiles = new ArrayList<>();

        Set<String> allKey = new TreeSet<>(map.keySet());
        allKey.addAll(map1.keySet());
        for (String key : allKey) {
            if (!map.containsKey(key)) {
                mergeDataOfTwoFiles.add(new Node("ADDED", key, map.get(key), map1.get(key)));
            } else if (!map1.containsKey(key)) {
                mergeDataOfTwoFiles.add(new Node("DELETE", key, map.get(key), map1.get(key)));
            } else if (Objects.equals(map.get((key)),map1.get(key))) {
                mergeDataOfTwoFiles.add(new Node("UNCHANGED", key, map.get(key), map1.get(key)));
            } else {
                mergeDataOfTwoFiles.add(new Node("CHANGED", key, map.get(key), map1.get(key)));
            }
        }

        return mergeDataOfTwoFiles;
    }

    private static String getValue(Object o) {
        if(o.equals(null)) {
            return "null";
        }
        return o.toString();
    }
}

/*Object valueFromMap = map.get(key);
            Object valueFromMap1 = map1.get(key);
*/
            /*if (valueFromMap == null) {
                valueFromMap = "null";
            }
            if (valueFromMap1 == null) {
                valueFromMap1 = "null";
            }*/
