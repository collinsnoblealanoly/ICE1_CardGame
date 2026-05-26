package card;

import java.util.Random;

/**
 * This class creates a magic hand of 7 random cards.
 * Then it checks if the hard-coded lucky card is in the hand.
 *
 * @author srinivsi
 * Modifier: Collins Noble
 * Student Number: 991759920
 * Date Modified: 2026-05-26
 */
public class CardTrick {

    public static void main(String[] args) {

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

        // Hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        System.out.println();
        System.out.println("Lucky Card: " + luckyCard.getSuit() + " " + luckyCard.getValue());

        boolean found = false;

        // Search for the lucky card
        for (int i = 0; i < magicHand.length; i++) {

            if (magicHand[i].getValue() == luckyCard.getValue()
                    && magicHand[i].getSuit().equals(luckyCard.getSuit())) {

                found = true;
            }
        }

        if (found) {
            System.out.println("You win! The lucky card is in the magic hand!");
        } else {
            System.out.println("You lose! The lucky card is not in the magic hand.");
        }
    }
}
