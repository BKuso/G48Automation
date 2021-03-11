package models;

public class User {

    public String login = "user";
    public String password = "password";

    public long phoneNumber = 380962157825L;
    public double sizeOfLeg = 43.5;
    public int yearsOld = 23;

    public void showUserData(){
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Size of Leg: " + sizeOfLeg);
        System.out.println("Years old: " + yearsOld);
    }

    public void increaseSizeOfLeg(double value){
        sizeOfLeg += value;
    }

    public void callSomeOne(String friendNumber){
        if (yearsOld<23){
            System.out.println("I will call to my friend with number: " + friendNumber);
        } else if (yearsOld==23){
            System.out.println("I`m will call him later on number: " + friendNumber);
        } else {
            System.out.println("This is not my friend. I will not call him!");
        }
    }

}
