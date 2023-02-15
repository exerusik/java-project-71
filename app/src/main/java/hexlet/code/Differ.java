package hexlet.code;

import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.getMap;
import static hexlet.code.Formatter.format;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatFile) throws Exception {
        Map<String, Object> fileToJson1 = getMap(filepath1, formatFile);
        Map<String, Object> fileToJson2 = getMap(filepath2, formatFile);
        List<Node> diff = format(fileToJson1, fileToJson2);

        return Stylish.allDifference(diff);
    }

}
