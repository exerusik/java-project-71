package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> fileToJson1 = getMap(content1);
        Map<String, Object> fileToJson2 = getMap(content2);

        StringBuilder difference = new StringBuilder("{\n");

        Set<String> allKey = new TreeSet<>(fileToJson1.keySet());
        allKey.addAll(fileToJson2.keySet());
        for (String key : allKey) {
            if (!fileToJson1.containsKey(key)) {
                difference.append("+ " + key + " : " + fileToJson2.get(key) + "\n");
            } else if (!fileToJson2.containsKey(key)) {
                difference.append("+ " + key + " : " + fileToJson1.get(key) + "\n");
            } else if (fileToJson1.get(key).equals(fileToJson2.get(key))) {
                difference.append("  " + key + " : " + fileToJson1.get(key)
                                                                            +
                                                                        "\n");
            } else {
                difference.append("- " + key + " : " +  fileToJson1.get(key)
                                                                            +
                                "\n+ " + key + " : " +  fileToJson2.get(key) + "\n");
            }
        }
        difference.append("}");

        return difference.toString();
    }
    public static Map<String, Object> getMap(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> file = mapper.readValue(content, new TypeReference<>() { });


        return file;
    }
}
