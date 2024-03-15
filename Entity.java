
import java.awt.Graphics;

public abstract class Entity extends Zoo {
    
    protected int id;
    protected boolean isAlive;
    protected int x;
    protected int y;

    public Entity(String name, int x, int y) {
        super(ZOO_ROWS, ZOO_COLS);
        this.x = x;
        this.y = y;

        // TODO: complete the Entity constructor
    }

    // ABSTRACT METHODS
    // tick and draw are called by the Zoo class

    // TODO: add abstract method tick(Zoo z)
    public abstract void tick(Zoo z);
    // TODO: add abstract method draw(Graphics g)
    public abstract void draw(Graphics g);

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}