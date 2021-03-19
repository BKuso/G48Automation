package models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Item {

    private String type;
    protected final Logger log;
    private String name;

    public Item(String name){
        this.log = LogManager.getLogger(name);
        this.name = name;
    }

    public Item(){
        this.log = LogManager.getLogger(this.getClass().getName());
    }

    public String getType() {
        return type;
    }

    public Item setType(String type) {
        this.type = type;
        return this;
    }
}
