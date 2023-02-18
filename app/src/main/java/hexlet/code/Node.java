package hexlet.code;

public class Node {
    private final String description;
    private final String key;
    private final Object value;
    private Object otherValue;

    public Node(String description, String key, Object value) {
        this.description = description;
        this.key = key;
        this.value = value;
    }

    public Node(String description, String key, Object value, Object otherValue) {
        this.description = description;
        this.key = key;
        this.value = value;
        this.otherValue = otherValue;
    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object getOtherValue() {
        return otherValue;
    }

}
