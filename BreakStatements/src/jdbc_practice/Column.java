package jdbc_practice;

public class Column {

    private String type;
    private String label;
    private String name;

    public Column(String type, String label, String name) {
        this.type = type;
        this.label = label;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }
}
