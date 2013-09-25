//Anthony Mace  CSC205AB
//This program is designed to set up two different classes
//a DeckHand class, and a Card class. These two classes are then
//used and tested in the program4 class

import java.util.*; //For Random and Scanner

public class program4 {

    public static void main(String[] args) {
        Card card1 = new Card(1, 2);
        Card card2 = new Card(12, 3);
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card1.getFaceValue());
        System.out.println(card2.getSuitValue());
    }
}

class Card {

    private int _faceValue;
    private int _suitValue;

    //Named constants
    //Face values
    private static final String ACE_VALUE = "Ace";
    private static final String TWO_VALUE = "Two";
    private static final String THREE_VALUE = "Three";
    private static final String FOUR_VALUE = "Four";
    private static final String FIVE_VALUE = "Five";
    private static final String SIX_VALUE = "Six";
    private static final String SEVEN_VALUE = "Seven";
    private static final String EIGHT_VALUE = "Eight";
    private static final String NINE_VALUE = "Nine";
    private static final String TEN_VALUE = "Ten";
    private static final String JACK_VALUE = "Jack";
    private static final String QUEEN_VALUE = "Queen";
    private static final String KING_VALUE = "King";

    //Suit values
    private static final String HEARTS_VALUE = " of Hearts";
    private static final String DIAMONDS_VALUE = " of Diamonds";
    private static final String CLUBS_VALUE = " of Clubs";
    private static final String SPADES_VALUE = " of Spades";

    //Constructs a card with values passed
    public Card(int faceValue, int suitValue) {
        if ((faceValue < 1 || faceValue > 13) ||
            (suitValue < 1 || suitValue > 4)) {
            System.out.println("Invalid suit or face value");
        } else {
            _faceValue = faceValue;
            _suitValue = suitValue;
        }
    }

    //Returns faceValue int
    public int getFaceValue() {
        return _faceValue;
    }

    //Returns suitValue int
    public int getSuitValue() {
        return _suitValue;
    }

    public String toString() {
        String face = "";
        String suit = "";

        //Face values
        if (_faceValue == 1) {
            face = ACE_VALUE;
        } else if (_faceValue == 2) {
            face = TWO_VALUE;
        } else if (_faceValue == 3) {
            face = THREE_VALUE;
        } else if (_faceValue == 4) {
            face = FOUR_VALUE;
        } else if (_faceValue == 5) {
            face = FIVE_VALUE;
        } else if (_faceValue == 6) {
            face = SIX_VALUE;
        } else if (_faceValue == 7) {
            face = SEVEN_VALUE;
        } else if (_faceValue == 8) {
            face = EIGHT_VALUE;
        } else if (_faceValue == 9) {
            face = NINE_VALUE;
        } else if (_faceValue == 10) {
            face = TEN_VALUE;
        } else if (_faceValue == 11) {
            face = JACK_VALUE;
        } else if (_faceValue == 12) {
            face = QUEEN_VALUE;
        } else if (_faceValue == 13) {
            face = KING_VALUE;
        }

        //Suit values
        if (_suitValue == 1) {
            suit = HEARTS_VALUE;
        } else if (_suitValue == 2) {
            suit = DIAMONDS_VALUE;
        } else if (_suitValue == 3) {
            suit = CLUBS_VALUE;
        } else if (_suitValue == 4) {
            suit = SPADES_VALUE;
        }

        return face + suit;
    }

}
