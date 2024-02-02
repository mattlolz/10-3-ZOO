
import java.awt.Graphics;

public abstract class Entity extends Zoo {
    // optional code to assign a sequencial entity ID
    private static int lastID = 0;
    protected int id;


    // TODO: add the Entity instance variables
    protected boolean isAlive;
    protected int x;
    protected int y;

    public Entity(String name, int x, int y, int age, boolean isAlive, int width, int height) {
        // name, x, y, age, isAlive, width, height
        // optional code to assign a sequencial entity ID
        super(width, height);
        this.id = lastID;
        this.isAlive = isAlive;
        lastID = lastID + 1;

        // TODO: complete the Entity constructor
    }

    // ABSTRACT METHODS
    // tick and draw are called by the Zoo class

    // TODO: add abstract method tick(Zoo z)
    public abstract void tick(Zoo z);
    // TODO: add abstract method draw(Graphics g)
    public abstract void draw(Graphics g);


    // NON-ABSTRACT METHODS
    // isAlive, getX, and getY are all called by the Zoo class

    public boolean isAlive() {
        // TODO: implement the isAlive method
        if (isAlive)
        {
            return true;
        }
        return false;
    }

    public int getX() {
        // TODO: implement the getX method
        return this.x;
    }

    public int getY() {
        // implement the getY method
        return this.y;
    }

}