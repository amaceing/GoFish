//Anthony Mace  CSC205AB
//This program is designed to set up two different classes
//a DeckHand class, and a Card class. These two classes are then
//used and tested in the program4 class

import java.util.*; //For Random and Scanner

public class program4 {

    public static void main(String[] args) {
        DeckHand fullDeck = new DeckHand();
        fillDeck(fullDeck);
        System.out.println(fullDeck);
        DeckHand emptyDeck = new DeckHand();
    }

    public static void fillDeck(DeckHand fullDeck) {
        int currentCard = 0;
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j < 5; j++) {
                fullDeck.pushCard(new Card(i, j));
            }
        }
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

    //Prints out a Card
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

    //Constructs a DeckHand
    public DeckHand() {
        cardCount = 0;
        deck = new Card[CARDS];
    }

    //Returns size of DeckHand
    public int getSize() {
        return cardCount;
    }

    //Adds card to DeckHand and creates a larger
    //array and copies contents from old array if
    //expansion is needed
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

    //Returns the number of times a given value
    //occurs in DeckHand
    public int count(int faceValue) {
        int count = 0;
        for (int i = 0; i < cardCount; i++) {
            if (faceValue == deck[i].getFaceValue()) {
                count++;
            }
        }
        return count;
    }

    //Returns one instance of a Card with given value
    //From DeckHand
    public Card popCard(int faceValue) {
        Card found = null;
        for (int i = 0; i < cardCount; i++) {
            if (faceValue == deck[i].getFaceValue()) {
                found = deck[i];
            }
        }
        cardCount--;
        return found;
    }

    //Prints out entire deck
    public String toString() {
        String currentDeck = "";
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                currentDeck += deck[i] + "\n";
            }
        }
        return currentDeck;
    }

    public int length() {
        return deck.length;
    }

}
