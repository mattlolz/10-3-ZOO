import java.awt.*;
import java.util.Random;

public class Cat extends Animal {

    int x;
    int y;
    int lives;
    int chanceOfDeath;

    public Cat(String name, int x, int y){
        super(name, x, y);
        this.x = x;
        this.y = y;
        this.lives = 9;
        this.chanceOfDeath = 0;
    }

    @Override
    public void draw(Graphics g) {
        // two optional examples of a way to draw a cat follow!

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("CA", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);

        // g.setColor(Color.DARK_GRAY);
        // g.setFont(new Font("Consolas", Font.PLAIN, 10));
        // g.drawString(" ^-^ ", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+5);
        // g.drawString("/. .\\", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+15);
        // g.drawString("\\_o_/", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }

    @Override
    public void eat(Food food)
    {
        if (food.getName().equals("NotCheese")){
            // System.out.println(name + " is eating ");
            food.beEaten(this);
            this.hunger -= food.nutrition;


            System.out.println("Cat hunger: " + hunger);
        }
    }

    @Override
    public void move(Zoo zoo) {
        Random random = new Random();
        
        int[] possibleMoves = {-1, 1};

        int moveX = possibleMoves[random.nextInt(2)];
        int moveY = possibleMoves[random.nextInt(2)];

        int newX = x + moveX;
        int newY = y + moveY;

        if (newX >= 0 && newX < Zoo.ZOO_COLS && newY >= 0 && newY < Zoo.ZOO_ROWS) {
            this.x = newX;
            this.y = newY;
        }
    }

    @Override
    public void tick(Zoo zoo) {

        if (this.lives <= 0) {
            this.isAlive = false;
            System.out.println(this.getName() + " has died at the age of " + tickCount + " ticks");
        }
   
        Entity foodTouching = zoo.isTouching(this);
        if (tickCount % 10 == 0) {
            this.hunger += 1;
            // System.out.println(name + " is now at " + hunger + " hunger");
            if (this.hunger > 25) {
                if (Math.random() < 0.99) {
                    if (foodTouching != null) {
                        this.eat((Food)(foodTouching));
                    }
                }
            }
            this.move(zoo);

            if (tickCount > 500){
                if (this.sick = true){
                    this.chanceOfDeath = 10;
                }
                else {
                    chanceOfDeath = 1;
                }
            }
            if (Math.random() * 100 <= chanceOfDeath) {
                this.lives -= 1;
                //System.out.println(name + " has " + lives + " lives left");
            }

        }

        // if (Zoo.tickCount%10==0)
        // {
        //     move(zoo);
        // }
        // for (int new_y = y - 1; new_y <= y + 1; new_y++) {
        //     for (int new_x = x - 1; new_x <= x + 1; new_x++) {
        //         if (new_x >= 0 && new_x < Zoo.ZOO_COLS && new_y >= 0 && new_y < Zoo.ZOO_ROWS) {
                    
        //         }
        //     }
        // }
    }


}