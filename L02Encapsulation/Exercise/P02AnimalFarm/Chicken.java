package L02Encapsulation.Exercise.P02AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name == null || name.equals(" ") || name.equals("")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    public double productPerDay (){
        if (age < 6){
            return 2.0;
        } else if (age < 12){
            return 1.0;
        } else {
            return 0.75;
        }
    }

    private double calculateProductPerDay (){
        return 0.0;
    }

    public String toString(){
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }
}
