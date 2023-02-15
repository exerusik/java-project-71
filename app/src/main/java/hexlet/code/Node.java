package hexlet.code;

public class Node {
    private String description;
    private String key;
    private Object value;
    private Object otherValue;

    public Node(String description, String key, Object value, Object otherValue) {
        this.description = description;
        this.key = key;
        this.value = value;
        this.otherValue = otherValue;
    }

    public Node(String key, Object value) {
        this.key = key;
        this.value=value;
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

    public void setValue(Object value) {
        this.value = value;
    }

    public void setOtherValue(Object otherValue) {
        this.otherValue = otherValue;
    }
}