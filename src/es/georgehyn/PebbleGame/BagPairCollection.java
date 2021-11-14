package es.georgehyn.PebbleGame;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BagPairCollection {
    Map<Origin, BagPair> BPs = new HashMap<>();
    Random random;

    public BagPairCollection(String fn1, String fn2, String fn3) {
        random = new Random();
        try {
            BPs.put(Origin.A, new BagPair(fn1, Origin.A));
            BPs.put(Origin.B, new BagPair(fn2, Origin.B));
            BPs.put(Origin.C, new BagPair(fn3, Origin.C));
        } catch (IOException e) { // invalid filename, usually
            e.printStackTrace();
        }
    }

    public void discard(Pebble p) {
        BPs.get(p.getOrigin()).place(p);
    }

    public Pebble pebblePlease(Origin o) {
        return BPs.get(o).draw();
    }
}
