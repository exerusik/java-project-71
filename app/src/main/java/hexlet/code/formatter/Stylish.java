package hexlet.code.formatter;

import hexlet.code.Node;

import java.util.List;

public class Stylish {
    private static final String SPACE = " ";
    public static String allDifference(List<Node> mergeDataFromTwoFiles) throws IllegalAccessException {
        StringBuilder buildString = new StringBuilder("{\n");

        for (Node element : mergeDataFromTwoFiles) {
            String description = element.getDescription();

            switch (description) {
                case "ADDED" :
                    buildString.append(SPACE.repeat(2) + "+ " + element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case "DELETE" :
                    buildString.append(SPACE.repeat(2) + "- " + element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case "UNCHANGED" :
                    buildString.append(SPACE.repeat(4) + element.getKey() + ": " + element.getValue() + "\n");
                    break;
                case "CHANGED" :
                    buildString.append(SPACE.repeat(2) + "- " + element.getKey() + ": " + element.getValue() + "\n")
                            .append(SPACE.repeat(2) + "+ "  + element.getKey() + ": " + element.getOtherValue() + "\n");
                default:
                    String message = String.format("Unknown key");
            }
        }
        buildString.append("}");

        return buildString.toString();
    }


}
