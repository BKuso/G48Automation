package models;

public enum Type {

    NORMAL(""),
    MINIMUM(""),
    MAXIMUM("");

    Type(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
