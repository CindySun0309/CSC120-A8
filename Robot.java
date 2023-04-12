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
    ArrayList<String> actions;
    int energy;


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

    public Number shrink() {
        this.height -= 1;
        this.actions.add("shrink");
        System.out.println("Robot " + this.name + " shrank 1 unit dowm. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    public Number grow() {
        this.height += 1;
        this.actions.add("grow");
        System.out.println("Robot " + this.name + " grew 1 unit up. Now " + this.name + " is " + this.height + " units tall.");
        return height;
    }

    public void rest() {
        this.actions.add("rest");
        System.out.println("Robot " + this.name + " is now resting... ");
        this.energy = 10;
    }

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
            System.out.println("You cannot undo. Undo options are: grow(), shrink(), grab(), and drop().");
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
        cindy.walk("east");
        cindy.undo();
    }
}