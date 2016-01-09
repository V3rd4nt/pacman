package Elements;

public class Wall extends Element {

    public Wall(Position pos) {
        super(pos);
    }

    @Override
    public String toString() {
        return "WALL";
    }
}
