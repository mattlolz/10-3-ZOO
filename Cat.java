import java.awt.*;

public class Cat extends Animal {

    int x;
    int y;

    public Cat(String name, int x, int y, int hunger, boolean isSick, int age, boolean isAlive, int width, int height){
        super(name, x, y, hunger, isSick, age, isAlive, width, height);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        // two optional examples of a way to draw a cat follow!

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);

        //g.setColor(Color.DARK_GRAY);
        //g.setFont(new Font("Consolas", Font.PLAIN, 10));
        //g.drawString(" ^-^ ", Zoo.wrap(xPos,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(yPos,Zoo.ZOO_ROWS)*Zoo.SCALE+5);
        //g.drawString("/. .\\", Zoo.wrap(xPos,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(yPos,Zoo.ZOO_ROWS)*Zoo.SCALE+15);
        //g.drawString("\\_o_/", Zoo.wrap(xPos,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(yPos,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
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
        for(int new_y = y-1; y < 3; y++) {
            for(int new_x = x-1; x < 3; x++) {
                
            }
        }
    }


}