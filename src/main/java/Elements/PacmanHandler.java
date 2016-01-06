package Elements;

import Util.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/01/16.
 */
public class PacmanHandler extends ElementHandler{

    Pacman pacManFig;

    PacmanHandler(){
    }

    @Override
    public boolean create(String type, Position pos) {
        this.pacManFig = new Pacman(pos);
        return true;
    }

    @Override
    public boolean eat(Position pos) {
        return false;
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

    public boolean move(Position pos){
        this.pacManFig.setPosition(pos);
        Messages.move(this.pacManFig);
        return true;
    }
}
