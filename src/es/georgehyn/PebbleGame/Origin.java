package es.georgehyn.PebbleGame;

import java.util.Random;

public enum Origin {
    A,
    B,
    C;

    private static final Origin[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Origin getRandomOrigin()  {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
