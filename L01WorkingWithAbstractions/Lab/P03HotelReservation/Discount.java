package L01WorkingWithAbstractions.Lab.P03HotelReservation;

public enum Discount {

    VIP(20),
    SecondVisit(10),
    None(0);

    private int discount;

    Discount(int discount){
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
