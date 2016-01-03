package Util;

import Elements.*;

public class Messages {

    public static void position (Element e) { System.out.println(e.toString() + " is at position (X: "
            + e.getPosition().getX() + ", Y: " + e.getPosition().getY()); }

    public static void appear (Element e) {
        System.out.println(e.toString() +  " appeared on the playing field");
    }

    public static void disappear (Element e) { System.out.println(e.toString() +  " disappeared "); }

    public static void ghostEat (Element e) { System.out.println(e.toString() +  " ate Pacman"); }

    public static void pacmanEat (Element e) { System.out.println(e.toString() +  " eaten by Pacman"); }

    public static void displayScore (int score) { System.out.println("Score: " + score); }
}
