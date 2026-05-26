package card;

import java.util.Random;
import java.util.Scanner;

/**
 * This class creates a magic hand of 7 random cards.
 * Then it asks the user to enter a card and checks if that card is in the hand.
 *
 * @author srinivsi
 * Modifier: Collins Noble
 * Student Number: 991759920
 * Date Modified: 2026-05-26
 */
public class CardTrick {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        Card[] magicHand = new Card[7];

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // Create 7 random cards
        for (int i = 0; i < magicHand.length; i++) {

            Card card = new Card();

            int value = random.nextInt(13) + 1;
            int suitNumber = random.nextInt(4);

            card.setValue(value);
            card.setSuit(suits[suitNumber]);

            magicHand[i] = card;
        }

        // Print the magic hand
        System.out.println("Magic Hand:");
        for (int i = 0; i < magicHand.length; i++) {
            System.out.println(magicHand[i].getSuit() + " " + magicHand[i].getValue());
        }

        System.out.println();

        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();

        System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int userSuitNumber = input.nextInt();

        String userSuit = suits[userSuitNumber];

        boolean found = false;

        // Search for the user's card
        for (int i = 0; i < magicHand.length; i++) {

            if (magicHand[i].getValue() == userValue &&
                    magicHand[i].getSuit().equals(userSuit)) {

                found = true;
            }
        }

        if (found) {
            System.out.println("Congratulations, your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        input.close();
    }
}