package L04InterfacesAndAbstraction.Exercise.P01DefineInteracePerson;

public class Robot implements Identifiable {

    private String Id;
    private String model;

    public Robot(String id, String model) {
        Id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return Id;
    }

    public String getModel() {
        return model;
    }
}
