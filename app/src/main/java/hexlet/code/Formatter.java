package hexlet.code;


import java.util.*;

public class Formatter {

    public static List<Node> format(Map<String, Object> map, Map<String, Object> map1) {

        List<Node> mergeDataOfTwoFiles = new ArrayList<>();

        Set<String> allKey = new TreeSet<>(map.keySet());
        allKey.addAll(map1.keySet());
        for (String key : allKey) {
            if (!map.containsKey(key)) {
                mergeDataOfTwoFiles.add(new Node("ADDED", key, map1.get(key)));
            } else if (!map1.containsKey(key)) {
                mergeDataOfTwoFiles.add(new Node("DELETE", key, map.get(key)));
            } else if (Objects.equals(map.get((key)), map1.get(key))) {
                mergeDataOfTwoFiles.add(new Node("UNCHANGED", key, map.get(key), map1.get(key)));
            } else {
                mergeDataOfTwoFiles.add(new Node("CHANGED", key, map.get(key), map1.get(key)));
            }
        }

        return mergeDataOfTwoFiles;
    }
}
