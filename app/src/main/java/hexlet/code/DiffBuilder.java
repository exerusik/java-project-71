package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<Node> getDifference(Map<String, Object> map, Map<String, Object> map1) {

        List<Node> difference = new ArrayList<>();

        Set<String> allKey = new TreeSet<>(map.keySet());
        allKey.addAll(map1.keySet());
        for (String key : allKey) {
            if (!map.containsKey(key)) {
                difference.add(new Node(Status.ADDED, key, map1.get(key)));
            } else if (!map1.containsKey(key)) {
                difference.add(new Node(Status.DELETED, key, map.get(key)));
            } else if (Objects.equals(map.get((key)), map1.get(key))) {
                difference.add(new Node(Status.UNCHANGED, key, map.get(key), map1.get(key)));
            } else {
                difference.add(new Node(Status.CHANGED, key, map.get(key), map1.get(key)));
            }
        }

        return difference;
    }
}
