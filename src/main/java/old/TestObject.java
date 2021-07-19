package old;

public class TestObject {

    int a = 0;

    static int b = 6;

    char l = 'd';
    String h = "\n\t\"Тест с двойными строками\"";
    long g = 124861128461284L;
    boolean t = 10>12;




    protected int returnA(){
        int c = 9;
        int d = c+12;
        int u = d+22;
        System.out.println(a + c);

        if(u>9){
            System.out.println("Больше");
        } else {
            System.out.println("Меньше");
        }
        return a;
    }

    void print(){
        System.out.println(h);
    }

    private TestObject(){}


    static TestObject testObject(){
        return new TestObject();
    }

    void printSome(String some){
        System.out.println(some);
    }

}
