import Elements.*;

public class Main {
    public static void main (String[] args) {

        // level size see Position class
        Level level = new Level ();

        // Beispiele
        level.createElement ("CORN", new Position(1,1));
        level.createElement("FRUIT", "BANANA", new Position(1,1));
        level.eat(new Position(1,1));

        //level.createElement("PILL", "POWER", new Position(2,2));
    }
}
