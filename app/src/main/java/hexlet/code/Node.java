package hexlet.code;

public final class Node {
    private final Status description;
    private final String key;
    private Object value;
    private Object otherValue;

    public Node(Status description, String key, Object value) {
        this.description = description;
        this.key = key;
        this.value = value;
    }

    public Node(Status description, String key, Object value, Object otherValue) {
        this.description = description;
        this.key = key;
        this.value = value;
        this.otherValue = otherValue;
    }

    public Status getDescription() {
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
