package hexlet.code.formatter;

import hexlet.code.Node;
import java.util.List;

public class Plain {
    public static String getPlain(List<Node> mergeDataFromTwoFiles) throws Exception {
        StringBuilder buildString = new StringBuilder();
        for (Node element : mergeDataFromTwoFiles) {
            String description = element.getDescription();
            Object oldValue = convertValue(element.getValue());
            Object newValue = convertValue(element.getOtherValue());
            switch (description) {
                case "ADDED" :
                    buildString.append("Property \'" + element.getKey()
                                        + "\' was added with value: " + oldValue + "\n");
                    break;
                case "DELETE" :
                    buildString.append("Property \'" + element.getKey() + "\' was removed\n");
                    break;
                case "CHANGED" :
                    buildString.append("Property \'" + element.getKey()
                                       + "\' was updated. From " + oldValue + " to " + newValue + "\n");
                default:
                    break;
            }
        }
        return buildString.toString();
    }

    private static Object convertValue(Object o) {
        if (o == null) {
            return null;
        } else if (o instanceof String || o instanceof Character) {
            return  "\'" + o + "\'";
        } else if (!(o instanceof Boolean) && !(o instanceof Integer)) {
            return "[complex value]";
        } else {
            return o;
        }

    }
}
