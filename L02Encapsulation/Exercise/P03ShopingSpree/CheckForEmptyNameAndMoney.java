package L02Encapsulation.Exercise.P03ShopingSpree;

public class CheckForEmptyNameAndMoney {

    public static void checkName (String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public static void checkMoney (double money){
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }
}
