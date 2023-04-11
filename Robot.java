import java.util.ArrayList;

public class Robot implements Contract {

    String name;
    int x;
    int y;
    int height;
    int numhands;
    boolean hands;
    boolean wings;
    ArrayList<String> things_in_hands;
    int energy;


    public Robot(String name, int initial_x, int initial_y, int height, boolean hands, boolean wings) {
        this.name = name;
        this.x = initial_x;
        this.y = initial_y;
        this.height = height;
        this.hands = hands;
        this.wings = wings;
        this.things_in_hands = new ArrayList<String>();
        this.energy = 10;
        this.numhands = 2;
        System.out.println("You have successfully created a robot named " + this.name + " in our game! Try to move " + this.name + " around!");
    }

    public void grab(String item) {
        if (this.hands = false) {
            System.out.println("Robot " + this.name + " cannot grab anything because it does not have a hand.");
        }
        else if (this.numhands <= 2 && this.numhands > 0) {
            this.numhands -= 1;
            this.things_in_hands.add(item);
            System.out.println("Robot " + this.name + " grabbed " + item + ".");
        }
        else {
            System.out.println("Robot " + this.name + " cannot grab anything else because both hands are full.");
        }
    }

    public String drop(String item) {
        if (this.hands = false) {
            System.out.println("Robot " + this.name + " cannot drop anything because it does not have a hand.");
        }
        else if (this.things_in_hands.contains(item)) {
            this.numhands += 1;
            this.things_in_hands.remove(item);
            System.out.println("Robot " + this.name + " dropped " + item + ".");
        }
        else {
            System.out.println("Robot " + this.name + " cannot drop " + item + " because " + item + " is not in " + this.name + "'s hands.");
        }
        return item;
    }

    public void examine(String item) {
        System.out.println("Robot " + this.name + " examined " + item + ".");
    }

    public void use(String item) {
        System.out.println("Robot " + this.name + " used " + item + ".");
    }

    public boolean walk(String direction) {
        if (this.energy <= 0) {
            System.out.println("Robot " + this.name + " is lack of energy! Rest first and try again.");
            this.rest();
            return false;
        }
        else if (direction == "north") {
            this.y += 1;
            this.energy -= 1;
            System.out.println("Robot " + this.name + " headed north for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "south") {
            this.y -= 1;
            this.energy -= 1;
            System.out.println("Robot " + this.name + " headed south for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "east") {
            this.x += 1;
            this.energy -= 1;
            System.out.println("Robot " + this.name + " headed east for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else if (direction == "west") {
            this.x -= 1;
            this.energy -= 1;
            System.out.println("Robot " + this.name + " headed west for 1 unit. " + this.name + "'s current location is at (" + this.x + "," + this.y + ").");
            return true;
        }
        else {
            System.out.println("Please input one of the directions in lower case: north, south, east, or west.");
            return false;
        }
    }

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
            System.out.println("Robot " + this.name + " flew to location (" + this.x + "," + this.y + ").");
            return true;
        }
    }

    public Number shrink() {
        this.height -= 1;
        System.out.println("Robot " + this.name + " shrank 1 unit dowm. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    public Number grow() {
        height += 1;
        System.out.println("Robot " + this.name + " grew 1 unit up. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    public void rest() {
        System.out.println("Robot " + this.name + " is now resting... ");
        this.energy = 10;
    }

    public void undo() {
        
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
    }



}
