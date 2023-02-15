package hexlet.code.formatter;

import hexlet.code.Node;

import java.util.List;

public class Stylish {

    public static String allDifference(List<Node> mergeDataFromTwoFiles) {


        StringBuilder buildString = new StringBuilder("{\n");

/*- follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true*/
        for (Node element : mergeDataFromTwoFiles) {
            String description = element.getDescription();
            if(element.getOtherValue() == null) {
                element.setOtherValue("null");
            }
            if (element.getValue() == null) {
                element.setValue("null");
            }

            switch (description) {
                case "ADDED" :
                    buildString.append("+ " + element.getKey() + ":" + element.getValue() + "\n");
                    break;
                case "DELETE" :
                    buildString.append("- " + element.getKey() + ":" + element.getValue() + "\n");
                    break;
                case "UNCANGED" :
                    buildString.append("  " + element.getKey() + ":" + element.getValue() + "\n");
                    break;
                case "CHANGED" :
                        buildString.append("  " + element.getKey() + ":" + element.getValue() + "\n")
                                   .append("  " + element.getKey() + ":" + element.getOtherValue() + "\n");
            }
        }
        buildString.append("}");

        return buildString.toString();
    }

}
