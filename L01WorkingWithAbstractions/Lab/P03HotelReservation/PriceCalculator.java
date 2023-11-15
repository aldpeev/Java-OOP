package L01WorkingWithAbstractions.Lab.P03HotelReservation;

public class PriceCalculator {

    public static double calculate (double pricePerDay, int days, String season, String discount){

        double priceWithoutDiscount = pricePerDay * (days * Season.valueOf(season).getMultiply());

        return priceWithoutDiscount - priceWithoutDiscount * Discount.valueOf(discount).getDiscount() / 100 ;
    }
}
