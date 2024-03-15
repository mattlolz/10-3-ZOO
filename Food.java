import java.awt.Graphics;

public abstract class Food extends Entity {

    protected int nutrition;
    protected boolean expired;

    public Food(String name, int x, int y) {
        super(name, x, y);
        this.nutrition = 0;
        this.expired = false;
    }

    public abstract void beEaten(Animal eater);
    public abstract void draw(Graphics g);

    public int getNutrition() {
        return nutrition;
    }
    public boolean isExpired() {
        return expired;
    }

    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }
    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
