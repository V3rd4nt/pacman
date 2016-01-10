package Pacman.Elements;

public class Lifes {

    private int amount;

    public Lifes(int amount) {
        this.amount = amount;
    }

    public int getAmount () {
        return amount;
    }

    public boolean looseLife () {
        if (amount > 0) {
            amount -= 1;
            return true;
        }
        else return false;
    }
}
