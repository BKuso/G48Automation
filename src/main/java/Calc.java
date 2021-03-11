public class Calc {

    public int sum(String first, double second) {
        return Integer.parseInt(first) + (int) second;
    }

    public int sum(String first, String second) {
        if (first != null && second != null){
            try{
                return Integer.parseInt(first) + Integer.parseInt(second);
            } catch (NumberFormatException n){
                System.out.println(String.format("Попытка сложить целые числа провалилась: %s. Пытаемся работать с дробью",
                        n.getMessage()));
                try {
                    return (int) (Double.parseDouble(first) + Double.parseDouble(second));
                } catch (Exception e){
                    System.out.println(String.format("Вводимые параметры содержат не числовые символы: %s. " +
                            "Возвращаем значение по-умолчанию", e.getMessage()));
                    return 0;
                }
            }
        } else {
            return -2;
        }
    }

    public int sum(int first, int second){
        int one;
        int two;
        switch (first){
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                one = first + 1;
                break;
            default:
               one = first;
               break;
        }
        switch (second){
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                two = second + 1;
                break;
            default:
                two = second;
                break;
        }
        return one + two;
    }


    public double sum(double first, double second) {
        return first + second;
    }

    public void showMyNumber(int myNumber){
        switch (myNumber) {
            case 0:
                System.out.println(String.format("Цифра %s - не моя(", myNumber));
                break;
            case 2:
                System.out.println(String.format("Цифра %s - моего друга(", myNumber));
                break;
            case 5:
                System.out.println(String.format("Цифра %s - моего брата(", myNumber));
                break;
            case 7:
                System.out.println(String.format("Цифра %s - моего дяди(", myNumber));
                break;
            default:
                System.out.println("Моя цифра: " + myNumber);
                break;
        }
    }

}
