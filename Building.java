public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     *  Default constructor 
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /** Overloaded constructor with address only 
     * @param address
    */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /** Overloaded constructor with name, address 
     * @param name
     * @param address
    */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /** Full constructor 
     * @param name
     * @param address
     * @param nFloors
    */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Getter for name
     * @return name 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for address
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /** 
     * Getter for number of floors
     * @return number of floors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Allows entering into the building if user is not already inside building
     * @return pointer to the current building
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Allows exiting the building as long as user is already in building 
     * @return null if user has successfuly exited building 
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Allows user to go to a floor as long as user is in building and the floor is in building
     * @param floorNum floor number to be moved to 
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Allows user to go up to a floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Allows a user to go down a floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Shows options available for Building class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Shows information about the building
     * @return information about building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * Main method 
     * @param args command line arguments passed into method
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
