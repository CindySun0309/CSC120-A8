import java.util.ArrayList;


/**
 * This class implements the interface Contract and creates robots in a game.
 */
public class Robot implements Contract {

    /** The name of a robot */
    String name;
    /** the x-coordinate of a robot's position */
    int x;
    /** the y-coordinate of a robot's position */
    int y;
    /** the height of a robot */
    int height;
    /** the number of hands of a robot */
    int numhands;
    /** the boolean that returns if a robot has hands or not */
    boolean hands;
    /** the boolean that returns if a robot has wings or not */
    boolean wings;
    /** An arraylist that stores things in the hands of a robot */
    ArrayList<String> things_in_hands;
    /** An arraylist that stores the actions of a robot */
    ArrayList<String> actions;
    /** The amount of energy of the robot */
    int energy;


    /**
     * This constructor construct a robot
     * @param name the name of the robot
     * @param initial_x the initial x-coordinate of the robot's position
     * @param initial_y the initial y-coordinate of the robot's position
     * @param height the initial height of the robot
     * @param hands indicates whether the robot has hands or not
     * @param wings indicates whether the robot has wings or not
     */
    public Robot(String name, int initial_x, int initial_y, int height, boolean hands, boolean wings) {
        this.name = name;
        this.x = initial_x;
        this.y = initial_y;
        this.height = height;
        this.hands = hands;
        this.wings = wings;
        this.things_in_hands = new ArrayList<String>();
        this.actions = new ArrayList<String>();
        this.energy = 10;
        this.numhands = 2;
        System.out.println("You have successfully created a robot named " + this.name + " in our game! Try to move " + this.name + " around!");
    }

    /**
     * Grab an item in the robot's hand
     * @param item the item to grab
     */
     public void grab(String item) {
        if (this.hands = false) {
            System.out.println("Robot " + this.name + " cannot grab anything because it does not have a hand.");
        }
        else if (this.numhands <= 2 && this.numhands > 0) {
            this.numhands -= 1;
            this.things_in_hands.add(item);
            this.actions.add("grab");
            this.actions.add(item);
            System.out.println("Robot " + this.name + " grabbed " + item + ".");
        }
        else {
            System.out.println("Robot " + this.name + " cannot grab anything else because both hands are full.");
        }
    }

    /**
     * Drop an item from the robot's hand
     * @param item the item to drop
     * @return the item
     */
    public String drop(String item) {
        if (this.hands = false) {
            System.out.println("Robot " + this.name + " cannot drop anything because it does not have a hand.");
        }
        else if (this.things_in_hands.contains(item)) {
            this.numhands += 1;
            this.things_in_hands.remove(item);
            this.actions.add("drop");
            this.actions.add(item);
            System.out.println("Robot " + this.name + " dropped " + item + ".");
        }
        else {
            System.out.println("Robot " + this.name + " cannot drop " + item + " because " + item + " is not in " + this.name + "'s hands.");
        }
        return item;
    }

    /**
     * Examine an item
     * @param item the item to be examined
     */
    public void examine(String item) {
        if (this.energy <= 0) {
            System.out.println("Robot " + this.name + " is lack of energy! Rest first and try again.");
            this.rest();
        }
        else {
            this.actions.add("examine");
            this.energy -= 1;
            System.out.println("Robot " + this.name + " examined " + item + ".");
        }
        
    }

    /**
     * Use an item
     * @param item the item to be used
     */
    public void use(String item) {
        this.actions.add("use");
        this.energy += 1;
        System.out.println("Robot " + this.name + " used " + item + ".");
    }

    /**
     * Walk one unit to north, south, east, or west
     * @param direction the direction to walk, options: north, south, east, and west
     * @return boolean if successfully walked or not
     */
    public boolean walk(String direction) {
        if (this.energy <= 0) {
            System.out.println("Robot " + this.name + " is lack of energy! Rest first and try again.");
            this.rest();
            return false;
        }
        else if (direction == "north") {
            this.y += 1;
            this.energy -= 1;
            this.actions.add("walk");
            this.actions.add(Integer.toString(x));
            this.actions.add(Integer.toString(y));
            System.out.println("Robot " + this.name + " headed north for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "south") {
            this.y -= 1;
            this.energy -= 1;
            this.actions.add("walk");
            this.actions.add(Integer.toString(x));
            this.actions.add(Integer.toString(y));
            System.out.println("Robot " + this.name + " headed south for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "east") {
            this.x += 1;
            this.energy -= 1;
            this.actions.add("walk");
            this.actions.add(Integer.toString(x));
            this.actions.add(Integer.toString(y));
            System.out.println("Robot " + this.name + " headed east for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "west") {
            this.x -= 1;
            this.energy -= 1;
            this.actions.add("walk");
            this.actions.add(Integer.toString(x));
            this.actions.add(Integer.toString(y));
            System.out.println("Robot " + this.name + " headed west for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else {
            System.out.println("Please input one of the directions in lower case: north, south, east, or west.");
            return false;
        }
    }

    /**
     * Fly to a location
     * @param x the x-coordinate of the location
     * @param y the y-coordinate of the location
     * @return boolean if successfully flew or not
     */
    public boolean fly(int x, int y) {
        if (this.energy <= 0) {
            System.out.println("Robot " + this.name + " is lack of energy! Rest first and try again.");
            this.rest();
            return false;
        }
        else if (this.wings == false) {
            this.energy -= 3;
            System.out.println("Robot " + this.name + " cannot fly because it does not have wings.");
            return false;
        }
        else {
            this.energy -= 3;
            this.x = x;
            this.y = y;
            this.actions.add("fly");
            this.actions.add(Integer.toString(x));
            this.actions.add(Integer.toString(y));
            System.out.println("Robot " + this.name + " flew to location (" + this.x + "," + this.y + ").");
            return true;
        }
    }

    /**
     * directly go back to the prior location when undo() is called
     * @param x the x-coordinate of the location
     * @param y the y-coordinate of the location
     * @return boolean if successfully went back or not
     */
    public boolean goback(int x, int y) {
        if (this.energy <= 0) {
            System.out.println("Robot " + this.name + " is lack of energy! Rest first and try again.");
            this.rest();
            return false;
        }
        else {
            this.energy -= 3;
            this.x = x;
            this.y = y;
            System.out.println("Robot " + this.name + " went back to location (" + this.x + "," + this.y + ").");
            return true;
        }
    }

    /**
     * decrease the height of the robot by 1 unit
     * @return the height of the robot
     */
    public Number shrink() {
        this.height -= 1;
        this.actions.add("shrink");
        System.out.println("Robot " + this.name + " shrank 1 unit dowm. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    /**
     * increase the height of the robot by 1 unit
     * @return the height of the robot
     */
    public Number grow() {
        this.height += 1;
        this.actions.add("grow");
        System.out.println("Robot " + this.name + " grew 1 unit up. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    /**
     * take a rest to restore the energy
     */
    public void rest() {
        this.actions.add("rest");
        System.out.println("Robot " + this.name + " is now resting... ");
        this.energy = 10;
    }

    /**
     * undo the last action, options: grow(), shrink(), grab(), drop(), fly(), and walk()
     */
    public void undo() {

        if (this.actions.get(this.actions.size()-1) == "grow") {
            this.shrink();
        }
        else if (this.actions.get(this.actions.size()-1) == "shrink") {
            this.grow();
        }
        else if (this.actions.get(this.actions.size()-2) == "grab") {
            this.drop(this.actions.get(this.actions.size()-1));
        }
        else if (this.actions.get(this.actions.size()-2) == "drop") {
            this.grab(this.actions.get(this.actions.size()-1));
        }
        else if (this.actions.get(this.actions.size()-3) == "fly" || this.actions.get(this.actions.size()-3) == "walk") {
            for (int i = this.actions.size() - 4; i >= 0; i--) {
                if (this.actions.get(i) == "fly" || this.actions.get(i) == "walk") {
                    this.goback(Integer.valueOf(this.actions.get(i+1)), Integer.valueOf(this.actions.get(i+2)));
                    break;
                }
            }
        }
        else {
            System.out.println("Error! Robot " + this.name + " is unwilling to undo the previous action!");
        }
        
    }


    public static void main(String[] args) {
        Robot cindy = new Robot("Cindy", 0, 0, 20, true, true);
        cindy.grab("coffee");
        cindy.grab("coffee");
        cindy.grab("coffee");
        cindy.drop("coffee");
        cindy.drop("coffee");
        cindy.drop("coffee");

        cindy.examine("coffee");
        cindy.use("coffee");

        cindy.walk("north");
        cindy.walk("north");
        cindy.walk("south");
        cindy.walk("east");
        cindy.walk("west");

        cindy.fly(3,9);
        cindy.fly(9,-2);
        cindy.fly(9,-5);
        cindy.fly(9,-5);

        cindy.shrink();
        cindy.grow();

        cindy.rest();

        cindy.fly(9,-2);
        cindy.undo();
    }
}