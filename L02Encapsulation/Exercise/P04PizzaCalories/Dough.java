package L02Encapsulation.Exercise.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String backingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        setFlourType(flourType);
        setBackingTechnique(backingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight){
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (isDataValid(flourType)){
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBackingTechnique(String backingTechnique) {
        if (isDataValid(backingTechnique)){
            this.backingTechnique = backingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private boolean isDataValid (String data){
        switch (data){
            case "White":
            case "Wholegrain":
            case "Crispy":
            case "Chewy":
            case "Homemade":
                return true;
        }
        return false;
    }

    public double calculateCalories (){

        double doughModifier;
        if ("White".equals(flourType)){
            doughModifier = 1.5;
        } else {
            doughModifier = 1.0;
        }

        double backingModifier;
        switch (backingTechnique) {
            case "Crispy":
                backingModifier = 0.9;
                break;
            case "Chewy":
                backingModifier = 1.1;
                break;
            case "Homemade":
                backingModifier = 1.0;
                break;
            default:
                backingModifier = 0;
        }

        return (2 * weight) * doughModifier * backingModifier;
    }
}
