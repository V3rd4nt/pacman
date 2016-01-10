package Pacman.Util;

import Pacman.Elements.Element;

public class Messages {

    public static void position (Element e) { System.out.println(e.toString() + " is at " + e.getPosition().toString()); }

    public static void appear (Element e) { System.err.println(e.toString() +  " appeared " + e.getPosition().toString()); }

    public static void pacmanEatenBy (Element e) { System.err.println(e.toString() +  " ate Pacman"); }

    public static void pacmanEat (Element e) { System.err.println(e.toString() +  " eaten by Pacman"); }

    public static void displayScore (int score) { System.err.println("Score: " + score); }

    public static void displayBonusScore (int nr, int score) { System.err.println("Bonus score for eating " + nr + " ghosts: " + score); }

    public static void lifeLost (int lifes) { System.err.println("Lost one life!\nCurrent lifes: " + lifes); }

    public static void gameOver () { System.err.println("Game Over!"); }
}
