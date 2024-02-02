import java.awt.*;

public class Rat extends Animal {

    public Rat(String name, int x, int y, int hunger, boolean isSick, int age, boolean isAlive, int width, int height) {
        super(name, x, y, hunger, isSick, age, isAlive, width, height);

    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    @Override
    public void eat(Food food)
    {
        
    }
    @Override
    public void move(Zoo zoo)
    {
        
    }
    @Override
    public void tick(Zoo zoo)
    {
        
    }

}