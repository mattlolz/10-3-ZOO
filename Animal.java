public abstract class Animal extends Entity{

    int hunger;
    boolean isSick;

    public Animal(String name, int x, int y, int hunger, boolean isSick, int age, boolean isAlive, int width, int height)
    {
        super(name, x, y, age, isAlive, width, height);
        this.hunger = hunger;
        this.isSick = isSick;
    }

    public abstract void eat(Food food);

    public abstract void move(Zoo zoo);
    
}