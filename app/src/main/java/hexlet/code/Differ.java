package hexlet.code;

import hexlet.code.formatter.Formatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.parse;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatFile) throws Exception {
        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);

        List<Node> buildTree = BuildDiffer.getDifference(data1, data2);

        String result = Formatter.format(buildTree, formatFile);
        return result;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        String file = Files.readString(path);

        String getFormat = filepath.substring(filepath.lastIndexOf(".") + 1);
        return parse(file, getFormat);
    }
}
