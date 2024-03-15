import java.awt.*;

/*
    Cheese can be eaten 3 times
    The first time, it decreases hunger by 10 nutrition, the second time 8 nutrition, the third time 5 nutrition.
    After 400 ticks, cheese has a 1% chance of expiring per tick, at which point it will make an animal sick
    Eating expired cheese neither increases nor decreases hunger
    Rats are immune to cheese sickness and will not get sick if they eat expired cheese
 */
public class Cheese extends Food {
    private int x;
    private int y;
    public Cheese(String name, int x, int y)
    {
        super(name, x, y);
        this.x = x;
        this.y = y;
    }
    public void beEaten(Animal animal)
    {
        if (this.nutrition == 13)
        {
            nutrition = 8;
        }

        if (this.nutrition == 5)
        {
            nutrition = 5;
        }
        if (this.nutrition == 23)
        {
            nutrition = 13;
        }
        this.nutrition -= 10;

        System.out.println("Cheese value: " + nutrition);
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🧀", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }

    @Override
    public void tick(Zoo z)
    {
        if (nutrition <= 0) {
            this.isAlive = false;
        }
        if (tickCount > 400) {
            if (Math.random() <= 0.01) {
                System.out.println("Cheese is expired");
                this.expired = true;
            }
        }
    }
}
