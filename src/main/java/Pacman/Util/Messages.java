package Pacman.Util;

import Pacman.Elements.Element;

/**
 * Messages Class
 */
public class Messages {

    /**
     * Displays the current position of an Element
     * @param e Element
     */
    public static void position (Element e) { System.out.println(e.toString() + " is at " + e.getPosition().toString()); }

    /**
     * Displays the creating position of an Element
     * @param e Element
     */
    public static void appear (Element e) { System.err.println(e.toString() +  " appeared " + e.getPosition().toString()); }

    /**
     * Displays that Pacman was eaten by an Element
     * @param e Element
     */
    public static void pacmanEatenBy (Element e) { System.err.println(e.toString() +  " ate Pacman"); }


    /**
     * Displays that Pacman ate an Element
     * @param e Element
     */
    public static void pacmanEat (Element e) { System.err.println(e.toString() +  " eaten by Pacman"); }

    /**
     * Displays game score
     * @param score current points to display
     */
    public static void displayScore (int score) { System.err.println("Score: " + score); }

    /**
     * Displays the bonus score for eating more than 3 ghosts
     * @param nr number of ghosts eaten
     * @param score bonus points
     */
    public static void displayBonusScore (int nr, int score) { System.err.println("Bonus score for eating " + nr + " ghosts: " + score); }

    /**
     * Indicates that one life was lost and displays the current number of lifes
     * @param lifes current amount of lifes
     */
    public static void lifeLost (int lifes) { System.err.println("Lost one life!\nCurrent lifes: " + lifes); }

    /**
     * Indicates that the game is over
     */
    public static void gameOver () { System.err.println("Game Over!"); }
}
