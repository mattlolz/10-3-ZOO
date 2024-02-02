import java.awt.*;

// TODO: extend Animal
public class Cat extends Animal {

    // TODO: add instance variables

    // TODO: add constructor
    public Cat(String name, int x, int y, int hunger, boolean isSick, int age, boolean isAlive, int width, int height){
        super(name, x, y, hunger, isSick, age, isAlive, width, height);
    }
    // TODO: override the tick method
    @Override
    public void tick()
    {
        
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

    // TODO: override the eat method
    @Override
    public void eat(Food food)
    {
        
    }
    // TODO: override the move method
    @Override
    public void move(Zoo zoo)
    {

    }
    @Override
    public void tick(Zoo zoo)
    {

    }


}