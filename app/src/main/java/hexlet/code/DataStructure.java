package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DataStructure {
    public static List<Node> treeData(Map<String, Object> map, Map<String, Object> map1) {

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
