package hexlet.code.formatter;

import hexlet.code.Node;
import hexlet.code.Status;

import java.util.List;

public class Stylish {
    private static final String SPACE = " ";
    public static String allDifference(List<Node> mergeDataFromTwoFiles) {
        StringBuilder buildString = new StringBuilder("{\n");

        for (Node element : mergeDataFromTwoFiles) {
            Status description = element.getDescription();

            switch (description) {
                case ADDED :
                    buildString.append(SPACE.repeat(2) + "+ " + element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case DELETED :
                    buildString.append(SPACE.repeat(2) + "- " + element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case UNCHANGED :
                    buildString.append(SPACE.repeat(2) + SPACE.repeat(2))
                               .append(element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case CHANGED :
                    buildString.append(SPACE.repeat(2) + "- " + element.getKey() + ": " + element.getValue() + "\n")
                               .append(SPACE.repeat(2)
                                       + "+ "  + element.getKey() + ": " + element.getOtherValue() + "\n");
                default:
                    break;
            }
        }
        buildString.append("}");

        return buildString.toString();
    }


}
