package models;

public class Car extends Item implements SomeInterface{

    public static int count = 0;
    private String carName;
    private String color;
    private int size;
    private String model;

    private Type type;

    public Car(String name, String color){
        super(name);
        this.color = color;
        this.carName = name;
        count++;
        log.info("Current car: " + this.carName);
    }

    public Car(Type type){
        this.type = type;
        switch (type){
            case NORMAL:
                System.out.println("Normal");
                break;
            case MINIMUM:
                System.out.println("Minimum");
                break;
        }
    }

    public Car(){
        log.info("New empty instance");
    }

    public Car(String color, boolean generateByColor){
        super(color);
        if(generateByColor){

            this.color = color;
        }
    }

    public Car(String carName,
               String color,
               int size,
               String model) {
        this.carName = carName;
        this.color = color;
        this.size = size;
        this.model = model;
    }

    public String getCarName() {
        return carName;
    }

    public Car setCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Car setSize(int size) {
        this.size = size;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public String toString(){
        return String.format("Назваание: %s; Цвет: %s", this.carName, this.color);
    }

    @Override
    public void method() {

    }
}
