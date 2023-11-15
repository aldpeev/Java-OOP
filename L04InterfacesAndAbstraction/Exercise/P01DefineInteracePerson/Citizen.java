package L04InterfacesAndAbstraction.Exercise.P01DefineInteracePerson;

public class Citizen implements Person, Birthable, Identifiable {

    private String name;
    private int age;
    private String Id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.Id = id;
        this.birthDate = birthday;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
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

}
