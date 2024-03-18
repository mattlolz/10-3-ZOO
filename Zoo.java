
import javax.swing.*;
import java.awt.*;

import java.util.*;

// in general it would be better practice to separate the data and display functionalities of Zoo
// into separate classes - they're combined here for simplicity and ease of understanding
public class Zoo extends JPanel {

    // zoo grid size
    public static final int ZOO_ROWS = 30; // grid height
    public static final int ZOO_COLS = 40; // grid width
    // screen size is the zoo grid sizes * SCALE
    public static final int SCALE = 30;

    // use this single Random object to generate ANY and ALL random numbers you need
    // there's an important reason why that's too long to explain in comments but ask me if you're curious 
    public static Random rand = new Random();

    //

    private int width, height;
    protected static int tickCount;
    private ArrayList<ArrayList<LinkedList<Entity>>> grid;

    public Zoo(int w, int h) {
        // initalize the grid using ArrayLists for the rows and columns and LinkedLists for the cell stack
        grid = new ArrayList<>(h);
    
        for(int y = 0; y < h; y++) {
            ArrayList<LinkedList<Entity>> row = new ArrayList<>(w);
            for(int x = 0; x < w; x++) {
                row.add(new LinkedList<Entity>());
            }
            grid.add(row);
        }
        width = w;
        height = h;
    }
    

	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		setBackground(Color.GREEN);

        // draw cell grids
        g.setColor(new Color(0, 200, 0)); // dark green
        for(int y = 0; y < height; y++) {
            g.drawLine(0, y * SCALE, width * SCALE, y * SCALE);
        }
        for(int x = 0; x < width; x++) {
            g.drawLine(x * SCALE, 0, x * SCALE, height * SCALE);
        }

        // draw ntities
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if (!grid.get(y).get(x).isEmpty()) { // Check if the cell contains any entities
                    for(Entity e : grid.get(y).get(x)) {
                        e.draw(g);
                    }
                }
            }
        }
        
	}

    // iterates through each cell in the grid, calling tick(Zoo)
    public void tick() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                for(int i = grid.get(y).get(x).size() - 1; i >= 0; i--) {
                    Entity e = grid.get(y).get(x).remove(i);

                    if(e.isAlive()) {
                        e.tick(this);
                        grid.get(wrap(e.getY(), height)).get(wrap(e.getX(), width)).add(e);
                    }
                }
            }
        }
    }

    // get a list of Entities at position x, y in the grid
    public ArrayList<Entity> at(int x, int y) {
        int atX = wrap(x, width);
        int atY = wrap(y, height);
        // ArrayList constructor copies references from the passed LinkedList
        return new ArrayList<Entity>(grid.get(atY).get(atX));
    }

    // add an Entity to the grid
    public void add(Entity e) {
        int x = e.getX();
        int y = e.getY();
        // Check if the coordinates are within the grid boundaries
        if (x >= 0 && x < width && y >= 0 && y < height) {
            // If within boundaries, add the entity to the grid
            int atX = wrap(x, width);
            int atY = wrap(y, height);
            grid.get(atY).get(atX).add(e);
        } else {
            System.err.println("Error: Attempted to add entity outside grid boundaries.");
        }
    }
    

    // wrap a val between 0 and thresh
    public static int wrap(int val, int thresh) {
        if (val >= 0) {
            return val % thresh;
        } else {
            return (thresh + (val % thresh)) % thresh;
        }
    }


    // explicitly for food but can't figure out how to return food instead of entity
    public Entity isTouching(Entity e) {
        int x = e.getX();
        int y = e.getY();
        ArrayList<Entity> current = at(x, y);
        for (Entity a : current)
        {
            if (a instanceof Food) {
                return (Food) a; // Corrected syntax
            }
        }
        return null;
    }
    
    public Entity getAdjectType(Entity e) {
        int x = e.getX();
        int y = e.getY();

        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
    
                int adjacentX = wrap(x + dx, width);
                int adjacentY = wrap(y + dy, height);
    
                ArrayList<Entity> entities = at(adjacentX, adjacentY);
                for (Entity entity : entities) {
                    return entity;
                }
            }
        }
        return null;
    } 
    

    public ArrayList<int[]> getAdjCoords(Entity animal) {
        int x = animal.getX();
        int y = animal.getY();
        ArrayList<int[]> adjacentCoordinates = new ArrayList<>();
    
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
    
                int adjacentX = wrap(x + dx, width);
                int adjacentY = wrap(y + dy, height);
    
                ArrayList<Entity> entities = at(adjacentX, adjacentY);
                for (Entity entity : entities) {
                    if (entity instanceof Food) {
                        adjacentCoordinates.add(new int[]{adjacentX, adjacentY});
                    }
                }
            }
        }
        return adjacentCoordinates;
    }



    public static void main(String[] args) {
        // main Zoo object
        Zoo zoo = new Zoo(ZOO_COLS, ZOO_ROWS);
    
        JFrame frame = new JFrame("Zoo");
        frame.setSize(ZOO_COLS * SCALE + SCALE / 2, ZOO_ROWS * SCALE + SCALE / 2 + 23);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(zoo);
        frame.setVisible(true);
    
        Animal cat = new Cat("Cat", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS));
        zoo.add(cat);
    
        Animal dog = new Dog("Dog", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS));
        zoo.add(dog);
    
        Food rat = new Rat("NotCheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS));
        zoo.add(rat);
    
        tickCount = 0;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    
            if (tickCount % 10 == 0) {
                if (Math.random() < 0.33) {
                    zoo.add(new Rat("NotCheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS)));
                } else if (Math.random() < 0.66) {
                    zoo.add(new Cheese("Cheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS)));
                } else {
                    zoo.add(new Ham("NotCheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS)));
                }
            }
    
            if (tickCount % 100 == 0) {
                if (Math.random() < 0.50) {
                    zoo.add(new Rat("NotCheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS)));
                } else {
                    zoo.add(new Ham("NotCheese", rand.nextInt(ZOO_COLS), rand.nextInt(ZOO_ROWS)));
                }
            }

            zoo.tick();
    
    
            // redraw the frame
            zoo.revalidate();
            zoo.repaint();
    
            tickCount++;
        }
    }
}
