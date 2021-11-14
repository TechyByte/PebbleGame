package es.georgehyn.PebbleGame;

public class Pebble {
    static int weight;
    static Origin origin;

    public Pebble(int w, Origin o) {
        origin = o;
        weight = w;
    }

    public int getWeight() {
        return weight;
    }

    public Origin getOrigin() {
        return origin;
    }
}
