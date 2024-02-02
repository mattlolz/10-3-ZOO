
// TODO: make Food abstract
// TODO: extend Entity
public abstract class Food extends Entity {

    // TODO: add instance variables
    int nutrition;
    boolean isAnimalProduct;
    boolean isVegetableProduct;
    // TODO: add constructor
    public Food(String name, int x, int y, int nutrition, boolean isAnimalProduct, boolean isVegetableProduct, int age, boolean isAlive, int width, int height)
    {
        // name, x, y, nutrition, isAnimalProduct, isVegetableProduct, int age, boolean isAlive, int width, int height
        super(name, x, y, age, isAlive, width, height);
        this.nutrition = nutrition;
        this.isAnimalProduct = isAnimalProduct;
        this.isVegetableProduct = isVegetableProduct;

    }
    // TODO: add abstract method beEaten(Animal eater)
    public abstract void beEaten(Animal eater);

    // TODO: add non-abstract methods as needed

}