package Util;

import Elements.*;

public class Messages {

    public static void position (Element e) {
        System.out.println(e.toString() + " is at " + e.getPosition().toString());
    }

    public static void appear (Element e) {
        System.out.println(e.toString() +  " appeared on the playing field at " + e.getPosition().toString());
    }

    public static void vanish (Element e) { System.out.println(e.toString() +  " vanished"); }

    public static void pacmanEatenBy (Element e) { System.out.println(e.toString() +  " ate Pacman"); }

    public static void pacmanEat (Element e) { System.out.println(e.toString() +  " eaten by Pacman"); }

    public static void move (Element e) { System.out.println(e.toString() +  " moved to " + e.getPosition().toString()); }

    public static void displayScore (int score) { System.out.println("Score: " + score); }

    public static void lifeLost (int lifes) { System.out.println("Lost one life!\nCurrent lifes: " + lifes); }

    public static void gameOver () { System.out.println("Game Over!"); }
}
