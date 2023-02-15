package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getMap(String filepath1, String format) throws Exception {
        Path path1 = Paths.get(filepath1);

        String content1 = new String(Files.readAllBytes(path1));
        switch (format) {
            case  "yml" :
                return parseYML(content1);
            case  "json" :
                return parseJson(content1);
            default:
                throw new Exception("Unknown format: '" + format + "'");
        }
    }

    public static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> file = mapper.readValue(content, new TypeReference<>() {
        });
        return file;
    }

    public static Map<String, Object> parseYML(String content) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> file = mapper.readValue(content, new TypeReference<>() {
        });
        return file;
    }
}
