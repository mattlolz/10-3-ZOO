import java.awt.*;
import java.util.Random;

public class Dog extends Animal {

    int x;
    int y;
    int lives;
    private int deathChance;
    private int tickCount;
    private int pD;

    public Dog(String name, int x, int y){
        super(name, x, y);
        this.lives = 1;
        this.deathChance = 0;
        this.pD = (int)(Math.random() * 4);
    }

    @Override
    public void draw(Graphics g) {
        // two optional examples of a way to draw a cat follow!

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("DO", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
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
        Entity nearby = zoo.getAdjectType(this);

        if (nearby instanceof Dog)
        {
            ((Dog)(nearby)).pD = this.pD;
        }

        if (tickCount % 15 == 0)
        {
            this.hunger += 1;
            move(zoo);
        }

        if (tickCount > 1000)
        {
            if (this.sick)
            {
                this.deathChance = 10;
            }
            else
            {
                deathChance = 1;
            }
        }

        if (this.hunger > 50)
        {
            if (zoo.isTouching(this) != null)
            {
                Entity a = zoo.isTouching(this);
                if (a.getName().equals("Food"))
                {
                    this.eat((Food)(a));
                }
            }
        }
        else
        {
            if (Math.random() < 0.01)
            {
                if (zoo.isTouching(this) != null)
                {
                    Entity a = zoo.isTouching(this);
                    if (a.getName().equals("Food"))
                    {
                        this.eat((Food)(a));
                    }
                }
            }
        }

        if (Math.random() * 1000 <= deathChance)
        {
            this.lives -= 1;
        }

        if (this.lives <= 0) {
            this.isAlive = false;
            System.out.println("Dog has died");
            if (Math.random() < 0.5){
                zoo.add(new Dog("DOGoffspring", this.x + 1, this.y + 1));
                System.out.println("Dog has been born!");
                if(Math.random() < 0.5){
                    zoo.add(new Dog("DOGoffspring", this.x - 1, this.y - 1));
                    System.out.println("2 dogs have been born");
                }
            }
        }

    }


}