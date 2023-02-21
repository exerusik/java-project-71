package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content1, String format) throws Exception {
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
        ObjectMapper mapper = new ObjectMapper();
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
