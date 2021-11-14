package es.georgehyn.PebbleGame;

public class Main {
    public static void main(String[] args) {
        BagPairCollection bpc = new BagPairCollection(args[0], args[1], args[2]);
        Player player = new Player(bpc);
    }
}

