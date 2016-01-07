package Elements;

import Util.Messages;
import Util.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/01/16.
 */

// TODO für was brauchst du diese klasse? ist eigentlich sinnlos, da wir eh nur 1 pacman haben. kannt eigentlich köschen

public class PacmanHandler extends ElementHandler{

    Pacman pacManFig;

    PacmanHandler(){
    }

    @Override
    public boolean create(String type, Position pos) {
        this.pacManFig = new Pacman(pos);
        Messages.appear(this.pacManFig);
        return true;
    }

    @Override
    public boolean create(Position pos) {
        return false;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean eat(Position pos) {
        return false;
    }

    public boolean eat(ElementHandler elementHandler){
        return elementHandler.eat(pacManFig.getPosition());
    }

    @Override
    public int getNumberOfElements() {
        return 1;
    }

    @Override
    public List<?> getElements() {
        List<Pacman> list = new ArrayList<Pacman>();
        if (this.pacManFig != null){
            list.add(this.pacManFig);
        }

        return list;
    }

    public boolean move(){
        this.pacManFig.setPosition(Movement.createNextPositionFrom(this.pacManFig.getPosition()));
        Messages.move(this.pacManFig);
        return true;
    }

}
