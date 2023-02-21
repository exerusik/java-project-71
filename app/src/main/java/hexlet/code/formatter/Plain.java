package hexlet.code.formatter;

import hexlet.code.Node;
import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Plain {
    private static String added = "Property '%s' was added with value: %s\n";
    private static String deleted = "Property '%s' was removed\n";
    private static String updated = "Property '%s' was updated. From %s to %s\n";
    public static String getPlain(List<Node> mergeDataFromTwoFiles) {
        StringBuilder buildString = new StringBuilder();
        for (Node element : mergeDataFromTwoFiles) {
            Status description = element.getDescription();
            String key = element.getKey();
            Object oldValue = convertValue(element.getValue());
            Object newValue = convertValue(element.getOtherValue());
            switch (description) {
                case ADDED :
                    buildString.append(String.format(added, key, oldValue));
                    break;
                case DELETED :
                    buildString.append(String.format(deleted, key));
                    break;
                case CHANGED :
                    buildString.append(String.format(updated, key, oldValue, newValue));
                default:
                    break;
            }
        }
        buildString.deleteCharAt(buildString.length() - 1);
        return buildString.toString();
    }

    private static Object convertValue(Object o) {
        if (o instanceof String) {
            return "\'" + o + "\'";
        } else if ((o instanceof List<?>) || (o instanceof Map<?, ?>)) {
            return "[complex value]";
        } else {
            return String.valueOf(o);
        }

    }
}
