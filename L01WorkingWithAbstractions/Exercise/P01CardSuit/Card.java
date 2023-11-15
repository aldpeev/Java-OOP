package L01WorkingWithAbstractions.Exercise.P01CardSuit;

public class Card {
    public static void printCard (String card, String suit){
        System.out.printf("Card name: %s of %s; Card power: %d%n", card, suit, Deck.valueOf(card).getRankPower() + CardSuits.valueOf(suit).getSuitPower());
    }
}
