package L04InterfacesAndAbstraction.Exercise.P02FoodShortage;

public class Citizen implements Person, Identifiable, Buyer {

    private String name;
    private int age;
    private String Id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.Id = id;
        this.birthDate = birthday;
        food = 0;
    }

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        food += 10;
    }

    @Override
    public int getFood() {
        return food;
    }
}
