public abstract class Animal extends Entity{

    // TODO: instance variables
    int hunger;
    boolean isSick;
    // TODO: add constructor
    public Animal(String name, int x, int y, int hunger, boolean isSick, int age, boolean isAlive, int width, int height)
    {
        super(name, x, y, age, isAlive, width, height);
        this.hunger = hunger;
        this.isSick = isSick;
    }
    // TODO: add abstract method eat(Food food)
    public abstract void eat(Food food);
    // TODO: add abstract method move(Zoo zoo)
    public abstract void move(Zoo zoo);
    
    // TODO: add non-abstact methods as necessary
}