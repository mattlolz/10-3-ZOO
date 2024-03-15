import java.awt.*;

public abstract class Animal extends Entity{

    protected int hunger;
    protected boolean sick;

    public Animal(String name, int x, int y)
    {
        super(name, x, y);
        this.hunger = 0;
    }

    public abstract void draw(Graphics g);

    public abstract void eat(Food food);

    public abstract void tick(Zoo zoo);

    public abstract void move(Zoo zoo);
    
    public int getHunger() {
        return this.hunger;
    }
    
    public boolean isSick(){
        return this.sick;
    }
}