package L01WorkingWithAbstractions.Exercise.P01CardSuit;

public enum CardSuits {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    CardSuits (int value){
        this.suitPower = value;
    }

    public int getSuitPower(){
        return suitPower;
    }

}
