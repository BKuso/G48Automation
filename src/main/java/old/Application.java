package old;

public class Application {

    int a = 0;

    static final int CONSTANT =  7;

    //Однострочный комментарий

    /*
    Много
    строчный
    комментарий
     */

    /**
     * Комментарий разработчика
     *
     */

    public static void main(String[] args){
      //  System.out.println("Hello!!!");

 //       System.out.println(CONSTANT);

        TestObject object = TestObject.testObject();
        object.print();
        object.printSome(null);

        System.out.println(null==null);


//        int b = TestObject.b;
//
//        int a = object.returnA();
//        System.out.println(a);
    }

}