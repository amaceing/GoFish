//Anthony Mace  CSC205AB
//This program is designed to set up two different classes
//a DeckHand class, and a Card class. These two classes are then
//used and tested in the program4 class

import java.util.*; //For Random and Scanner

public class program4 {

    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        int b = 0;
        int deckChoice = 0;
        printIntro();
        System.out.println();
        DeckHand deck1 = new DeckHand();
        fillDeck(deck1);
        DeckHand deck2 = new DeckHand();
        do {
            System.out.println();
            b = menu();
            System.out.println();
            if (b != 7) {
                System.out.print("Would you like to use the full or empty deck? \n" +
                              "Enter 1 for the full deck and 2 for the empty deck: ");
                deckChoice = console.nextInt();
                System.out.println();
            }
            if (b == 1) {
                if (deckChoice == 1) {
                    if (deckFull(deck1)) {
                        System.out.println("This deck is full, you cannot insert another card");
                    } else {
                        insertCard(deck1);
                    }
                } else if (deckChoice == 2) {
                    if (deckFull(deck2)) {
                        System.out.println("This deck is full, you cannot insert another card");
                    } else {
                        insertCard(deck2);
                    }
                }
            } else if (b == 2) {
                if (deckChoice == 1) {
                    if (!deckFull(deck1)) {
                        System.out.println("This deck is empty, you cannot delete a card");
                    } else {
                        deleteCard(deck1);
                    }
                } else if (deckChoice == 2) {
                    if (!deckFull(deck2)) {
                        System.out.println("This deck is empty, you cannot delete a card");
                    } else {
                        deleteCard(deck2);
                    }
                }
            } else if (b == 3) {
                if (deckChoice == 1) {
                    count(deck1);
                } else if (deckChoice == 2) {
                    count(deck2);
                }
            } else if (b == 4) {
                if (deckChoice == 1) {
                    size(deck1);
                } else if (deckChoice == 2) {
                    size(deck2);
                }
            } else if (b == 5) {
                if (deckChoice == 1) {
                    printDeck(deck1);
                } else if (deckChoice == 2) {
                    printDeck(deck2);
                }
            }
        } while (b != 7);
        quitProg();
    }

    public static void printIntro() {
        System.out.println("This program is designed to use and manipulate \n" +
                            "decks of cards. You will be able to perform various \n" +
                            "actions with the decks of cards. These actions will be" +
                            "described in the menu");
    }

    public static int menu() {
        int choice = 0;
        System.out.println("Choose a task number from the following:");
        System.out.println("       1 - Insert a card in the Deck");
        System.out.println("       2 - Delete one instance of a Card in the Deck");
        System.out.println("       3 - Print the number of times a value occurs in Deck");
        System.out.println("       4 - Print the size of the Deck");
        System.out.println("       5 - Print the entire Deck");
        System.out.print("Insert menu option: ");
        choice = console.nextInt();
        while (choice < 1 || choice > 7) {
            System.out.print("Enter a number between 1 and 7: ");
            choice = console.nextInt();
            System.out.println();
        }
        return choice;
    }

    public static void fillDeck(DeckHand fullDeck) {
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                fullDeck.pushCard(new Card(i, j));
            }
        }
    }

    public static void insertCard(DeckHand deck) {
        int face = 0;
        int suit = 0;
        System.out.print("Card's face value (1 - 13): ");
        face = console.nextInt();
        System.out.print("Card's suit value (1 - 4): ");
        suit = console.nextInt();
        deck.pushCard(new Card(face, suit));
        System.out.println();
        System.out.println("The card with face value " + face + " and suit value " + suit + "\n" +
                "was inserted.");
    }

    public static void deleteCard(DeckHand deck) {
        int face = 0;
        System.out.print("Card's face value: ");
        face = console.nextInt();
        deck.popCard(face);
        System.out.print("A card with face value " + face + "was deleted");
    }

    public static void count(DeckHand deck) {
        int count = 0;
        int value = 0;
        System.out.print("Enter value to count: ");
        value = console.nextInt();
        count = deck.count(value);
        System.out.println(count);
    }

    public static void size(DeckHand deck) {
        System.out.println("The size of the deck is: " + deck.getSize());
    }

    public static void printDeck(DeckHand deck) {
        System.out.println(deck);
    }

    public static boolean deckFull(DeckHand deck) {
        return (deck.getSize() == 52);
    }

    public static void quitProg() {
        System.out.println("You have quit the program");
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
    //from DeckHand and replaces instance with Card at
    //the end of the deck
    public Card popCard(int faceValue) {
        Card found = null;
        for (int i = 0; i < cardCount; i++) {
            if (faceValue == deck[i].getFaceValue()) {
                found = deck[i];
                deck[i] = deck[cardCount - 1];
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
}
