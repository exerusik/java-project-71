package hexlet.code;

public final class Node {
    private final Status description;
    private final String key;
    private final Object value;
    private final Object otherValue;

    public Node(Status status, String keyOfMap, Object valueOfMap) {
        this.description = status;
        this.key = keyOfMap;
        this.value = valueOfMap;
        this.otherValue = null;
    }

    public Node(Status status, String keyOfMap, Object valueOfMap, Object otherValueOfMap) {
        this.description = status;
        this.key = keyOfMap;
        this.value = valueOfMap;
        this.otherValue = otherValueOfMap;
    }

    public Status getDescription() {
        return this.description;
    }
    public String getKey() {
        return this.key;
    }
    public Object getValue() {
        return this.value;
    }
    public Object getOtherValue() {
        return this.otherValue;
    }

}
