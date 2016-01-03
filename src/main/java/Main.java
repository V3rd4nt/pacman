import Elements.*;

public class Main {
    public static void main (String[] args) {

        // level size see Position class
        Level level = new Level ();

        // Beispiele
        level.createElement ("CORN", new Position(1,1));

        level.createElement("FRUIT", "BANANA", level.randomPosition());

        level.createElement("PILL", "POWER", new Position(1,1));
    }
}
