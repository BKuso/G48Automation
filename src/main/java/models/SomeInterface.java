package models;

public interface SomeInterface {

    int some = 0;

    void method();

    default void method2(){
        System.out.println("Method2" + some);
    }

}
