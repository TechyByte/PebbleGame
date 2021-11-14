package es.georgehyn.PebbleGame;

import java.util.List;
import java.util.Random;

public class Bag {
    int quantity;
    List<Pebble> pebbles;
    Random random;

    public synchronized Pebble drawPebble() {
        Pebble pebble = pebbles.get(random.nextInt(pebbles.size()));
        pebbles.remove(pebble);
        quantity = pebbles.size();
        return pebble;
    }

    public synchronized void placePebble(Pebble p) {
        pebbles.add(p);
        quantity = pebbles.size();
    }

    public int getQuantity() {
        return quantity;
    }
}
