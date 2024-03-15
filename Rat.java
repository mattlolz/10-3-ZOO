import java.awt.*;
import java.util.ArrayList;

/*
 * - A rat has 1 life and desparately tries to keep it
        - After 500 ticks, a rat has a 1.5% chance of dying per tick, 20% if the rat is sick
        - If a rat is at all sick, it has at minimum a 1% chance of dying per tick
    - A rat's hunger can never fall below 20
        - A rat will always eat cheese
        - A rat will eat anything else ONLY IF its hunger is above 50
    - Rats move in a consistent direction once every 5 ticks
        - Every 40-60 ticks, a rat randomly changes the direction they move
        - If a rat is ever adjacent to cheese, it will move towards the cheese
    - Every 50 ticks, there is a 10% chance of a rat spawning
    - Rats do not expire and are always a nutritious meal on the order of deceasing hunger by 10 when eaten
        - Rats can only be eaten once
        - A rat dies when eaten
 */

public class Rat extends Food {
    private int x;
    private int y;
    private int pD;
    public Rat(String name, int x, int y) {
        super(name, x, y);
        this.x = x;
        this.y = y;
        // Direction of rat
        pD = (int)(Math.random() * 4);
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("RA", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    
    @Override
    public void beEaten(Animal animal) {
        this.nutrition -= 10;
        System.out.println("Food is now at " + nutrition + " nutritional value ");
    }

    public void move(Zoo zoo) {
        Entity close = zoo.getAdjectType(this);
        ArrayList<int[]> coords = zoo.getAdjCoords(this);
    
        if (close instanceof Cheese && !coords.isEmpty()) {
            this.x = coords.get(0)[0];
            this.y = coords.get(0)[1];
        } else {
            if (tickCount % 50 == 0) {
                this.pD = (int) (Math.random() * 4);
            }
    
            if (pD == 0 && x < Zoo.ZOO_COLS - 1) {
                this.x++;
            } else if (pD == 1 && x > 0) {
                this.x--;
            } else if (pD == 2 && y < Zoo.ZOO_ROWS - 1) {
                this.y++;
            } else if (pD == 3 && y > 0) {
                this.y--;
            }
        }
    }
    

    @Override
    public void tick(Zoo zoo)
    {
        if (tickCount % 5 == 0) {
            move(zoo);
        }
        
    }

}