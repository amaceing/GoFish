//Anthony Mace  CSC205AB
//This program is designed to set up two different classes
//a DeckHand class, and a Card class. These two classes are then
//used and tested in the program4 class

import java.util.*; //For Random and Scanner

public class program4 {

    public static void main(String[] args) {
        Card card1 = new Card(1, 2);
        Card card2 = new Card(12, 3);
        Card card3 = new Card(6, 4);
        Card card4 = new Card(8, 1);
        DeckHand deck1 = new DeckHand();
        deck1.pushCard(card1);
        deck1.pushCard(card2);
        System.out.println(deck1);
        DeckHand deck2 = new DeckHand();
        deck2.pushCard(card3);
        deck2.pushCard(card4);
        System.out.println(deck2);
        System.out.println(deck1.getSize());
        System.out.println(deck2.getSize());
    }
}

class Card {

    private int _faceValue;
    private int _suitValue;

    //Named constants
    //Face values
    private static final String[] FACE_VALUES = {"Ace", "Two", "Three", "Four",
                                         "Five", "Six", "Seven", "Eight", "Nine",
                                         "Ten", "Jack", "Queen", "King"};

    //Suit values
    private static final String[] SUIT_VALUES = {" of Hearts", " of Diamonds",
                                                 " of Clubs", " of Spades"};

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
            face = FACE_VALUES[0];
        } else if (_faceValue == 2) {
            face = FACE_VALUES[1];
        } else if (_faceValue == 3) {
            face = FACE_VALUES[2];
        } else if (_faceValue == 4) {
            face = FACE_VALUES[3];
        } else if (_faceValue == 5) {
            face = FACE_VALUES[4];
        } else if (_faceValue == 6) {
            face = FACE_VALUES[5];
        } else if (_faceValue == 7) {
            face = FACE_VALUES[6];
        } else if (_faceValue == 8) {
            face = FACE_VALUES[7];
        } else if (_faceValue == 9) {
            face = FACE_VALUES[8];
        } else if (_faceValue == 10) {
            face = FACE_VALUES[9];
        } else if (_faceValue == 11) {
            face = FACE_VALUES[10];
        } else if (_faceValue == 12) {
            face = FACE_VALUES[11];
        } else if (_faceValue == 13) {
            face = FACE_VALUES[12];
        }

        //Suit values
        if (_suitValue == 1) {
            suit = SUIT_VALUES[0];
        } else if (_suitValue == 2) {
            suit = SUIT_VALUES[1];
        } else if (_suitValue == 3) {
            suit = SUIT_VALUES[2];
        } else if (_suitValue == 4) {
            suit = SUIT_VALUES[3];
        }

        return face + suit;
    }
}

class DeckHand {

    private static final int SUIT_COUNT = 4;
    private static final int FACE_COUNT = 13;
    private static final int CARDS = 52;
    private int cardCount;
    private Card[] deck;

    public DeckHand() {
        cardCount = 0;
        deck = new Card[CARDS];
    }

    public int getSize() {
        return cardCount;
    }

    public void pushCard(Card card) {
        if (cardCount == deck.length) {
            Card[] temp = new Card[deck.length * 2];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = deck[i];
            }
            deck = temp;
        }
        deck[cardCount] = card;
        cardCount++;
    }

    public Card popCard(int faceValue) {
        Card found = new Card(1, 1);
        for (int i = 0; i < deck.length; i++) {
            if (faceValue == deck[i].getFaceValue()) {
                System.out.println(deck[i]);
                found = deck[i];
            }
        }
        return found;
    }

    public String toString() {
        String currentDeck = "";
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                currentDeck += deck[i] + "\n";
            }
        }
        return currentDeck;
    }

}
