package L01WorkingWithAbstractions.Lab.P03HotelReservation;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int multiply;

    Season (int multiply){
        this.multiply = multiply;
    }

    public int getMultiply() {
        return multiply;
    }
}
