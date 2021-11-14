package es.georgehyn.PebbleGame;

import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    List<Pebble> hand;
    Random random = new Random();
    BagPairCollection bpc;

    private int score() {
        int score = 0;
        for (Pebble p: hand) {
            score += p.getWeight();
        }
        return score;
    }

    @Override
    public void run() {
        Origin start = Origin.getRandomOrigin();
        for (int i = 0; i < 10; ++i) {
            hand.add(bpc.pebblePlease(start));
        }
        while (score() != 100) { // player has not yet won
            bpc.discard(hand.remove(random.nextInt(hand.size())));
            hand.add(bpc.pebblePlease(Origin.getRandomOrigin()));
        }
        // player has won
    }

    public Player(BagPairCollection parentBpc) {
        bpc = parentBpc;
    }
}
