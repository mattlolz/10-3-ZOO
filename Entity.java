
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
    }

    // ABSTRACT METHODS

    public abstract void tick(Zoo z);
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