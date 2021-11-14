package es.georgehyn.PebbleGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BagPair {
    Bag white;
    Bag black;
    Bag swap;

    private static int[] readWeightsFromCSV(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        int[] weights = new int[(int) Files.size(path)];
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
            // read the first line from the  file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] readWeights = line.split(",");
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine(); }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return weights;
    }

    public BagPair(Bag b, Bag w) {
        black = b;
        white = w;
    }

    public Pebble draw() {
        Pebble pebble = black.drawPebble();
        if (black.getQuantity() == 0) {
            swap = white;
            white = black;
            black = swap;
        }
        return pebble;
    }

    public void place(Pebble p) {
        white.placePebble(p);
    }

    public BagPair(String fileName, Origin o) throws IOException {
        int[] weights = readWeightsFromCSV(fileName);
        white = new Bag();
        black = new Bag();
        for (int weight: weights) {
            black.placePebble(new Pebble(weight, o));
        }
    }
}
