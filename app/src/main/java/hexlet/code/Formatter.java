package hexlet.code;


import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;
import java.util.List;


public class Formatter {

    public static String format(List<Node> tree, String formatFile) throws Exception {

        switch (formatFile) {
            case "stylish" :
                return Stylish.allDifference(tree);
            case "plain" :
                return Plain.getPlain(tree);
            case "json" :
                return Json.writeJson(tree);
            default:
                String message = String.format("Unknown format file. Should be \"stylish\" , \" plain\" or \" json\"");
                throw new Exception(message);

        }
    }
}
