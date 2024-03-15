import java.awt.*;

public class Ham extends Food {
    private int x;
    private int y;
    public Ham(String name, int x, int y)
    {
        super(name, x, y);
        this.x = x;
        this.y = y;
    }
    public void beEaten(Animal animal)
    {
        animal.hunger -= 15;
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🍖", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    @Override
    public void tick(Zoo z)
    {
        if (nutrition <= 0) {
            this.isAlive = false;
        }
        if (tickCount > 200) {
            this.expired = true;
        }
        if (this.expired == true) {
            this.nutrition = -5 ;
        }
    }
}
