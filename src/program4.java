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
                System.out.println("A new, empty deck will replace the current" +
                                    " deck contents.");
                if (deckChoice == 1) {
                    deck1 = new DeckHand();
                } else if (deckChoice == 2) {
                    deck2 = new DeckHand();
                }
            } else if (b == 2) {
                if (deckChoice == 1) {
                    insertCard(deck1);
                } else if (deckChoice == 2) {
                    insertCard(deck2);
                }
            } else if (b == 3) {
                if (deckChoice == 1) {
                    deleteCard(deck1);
                } else if (deckChoice == 2) {
                    deleteCard(deck2);
                }
            } else if (b == 4) {
                if (deckChoice == 1) {
                    count(deck1);
                } else if (deckChoice == 2) {
                    count(deck2);
                }
            } else if (b == 5) {
                if (deckChoice == 1) {
                    size(deck1);
                } else if (deckChoice == 2) {
                    size(deck2);
                }
            } else if (b == 6) {
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
        System.out.println("       1 - Create a new, empty deck");
        System.out.println("       2 - Insert a card in the Deck");
        System.out.println("       3 - Delete one instance of a Card in the Deck");
        System.out.println("       4 - Print the number of times a value occurs in Deck");
        System.out.println("       5 - Print the size of the Deck");
        System.out.println("       6 - Print the entire Deck");
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
        System.out.println("The card with face value " + face + " and suit value " + suit +
                            "\n" + "was inserted.");
    }

    public static void deleteCard(DeckHand deck) {
        int face = 0;
        int count = 0;
        System.out.print("Card's face value: ");
        face = console.nextInt();
        count = deck.count(face);
        if (count != 0) {
            deck.popCard(face);
            System.out.println("A card with face value " + face + " was deleted");
        } else {
            System.out.println("No card with face value " + face +
                                " was found");
        }
    }

    public static void count(DeckHand deck) {
        int count = 0;
        int value = 0;
        System.out.print("Enter value to count: ");
        value = console.nextInt();
        count = deck.count(value);
        System.out.println("The value " + value + " occurs " + count + " times.");
    }

    public static void size(DeckHand deck) {
        System.out.println("The size of the deck is: " + deck.getSize());
    }

    public static void printDeck(DeckHand deck) {
        System.out.println(deck);
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

        switch (_faceValue) {
            case 1:
                face = FACE_VALUES[0];
                break;
            case 2:
                face = FACE_VALUES[1];
                break;
            case 3:
                face = FACE_VALUES[2];
                break;
            case 4:
                face = FACE_VALUES[3];
                break;
            case 5:
                face = FACE_VALUES[4];
                break;
            case 6:
                face = FACE_VALUES[5];
                break;
            case 7:
                face = FACE_VALUES[6];
                break;
            case 8:
                face = FACE_VALUES[7];
                break;
            case 9:
                face = FACE_VALUES[8];
                break;
            case 10:
                face = FACE_VALUES[9];
                break;
            case 11:
                face = FACE_VALUES[10];
                break;
            case 12:
                face = FACE_VALUES[11];
                break;
            case 13:
                face = FACE_VALUES[12];
                break;
        }


        //Suit values
        switch (_suitValue) {
            case 1:
                suit = SUIT_VALUES[0];
                break;
            case 2:
                suit = SUIT_VALUES[1];
                break;
            case 3:
                suit = SUIT_VALUES[2];
                break;
            case 4:
                suit = SUIT_VALUES[3];
                break;
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
        if (cardCount >= deck.length) {
            Card[] temp = new Card[deck.length + 2];
            for (int i = 0; i < cardCount; i++) {
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
        boolean foundIt = false;
        Card found = null;
        for (int i = 0; i < cardCount; i++) {
            if (faceValue == deck[i].getFaceValue() && !foundIt) {
                found = deck[i];
                foundIt = true;
                if (cardCount > 1) {
                    deck[i] = deck[cardCount - 1];
                } else {
                    deck[i] = null;
                }
            }
        }
        deck[cardCount - 1] = null;
        cardCount--;
        return found;
    }

    //Prints out entire deck
    public String toString() {
        String currentDeck = "";
        for (int i = 0; i < cardCount; i++) {
            if (deck[i] != null) {
                currentDeck += deck[i] + "\n";
            }
        }
        return currentDeck;
    }
}
