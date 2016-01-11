package Pacman.Elements;

/**
 * Lifes
 */
public class Lifes {

    private int amount;

    /**
     * Creates a life object and sets the amount of lifes
     * @param amount lifes
     */
    public Lifes(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the amount of lifes left
     * @return lifes left
     */
    public int getAmount () {
        return amount;
    }

    /**
     * In case of loosing a life the amount of lifes is reduced by 1
     * @return true if lifes are &gt; 0 (possible to loose life), false if &lt;= 0 (not possible to loose life)
     */
    public boolean looseLife () {
        if (amount > 0) {
            amount -= 1;
            return true;
        }
        else return false;
    }
}
