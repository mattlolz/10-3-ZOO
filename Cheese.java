import java.awt.Graphics;

public class Cheese extends Food {
    public Cheese(String name, int x, int y, int nutrition, boolean isAnimalProduct, boolean isVegetableProduct, int age, boolean isAlive, int width, int height)
    {
        super(name, x, y, nutrition, isAnimalProduct, isVegetableProduct, age, isAlive, width, height);
    }
    public void beEaten(Animal animal)
    {

    }
    @Override
    public void draw(Graphics g)
    {
        
    }
    @Override
    public void tick(Zoo z)
    {

    }
}