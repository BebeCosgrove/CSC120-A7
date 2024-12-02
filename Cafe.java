/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /**
     * Overloaded constructor with name, address, and nFloors  and other values for the cafe set to default values
     * @param name
     * @param address
     * @param nFloors
     */

    public Cafe(String name, String address, int nFloors){
        this(name, address, nFloors, 300, 150, 150, 100); // manually sets nCoffeeOunces, nSugarPackets, nCreams, and nCups to set numbers
    }

    /**
     * Constructor
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     * @param nCoffeeOunces number of coffee ounces in inventory remaining
     * @param nSugarPackets number of sugar packets remaining in inventory
     * @param nCreams number of splashes of cream remaining in inventory
     * @param nCups number of cups remaning in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Decreases the cafe's inventory when a cup of coffee is sold
     * @param size number of ounces of cup of coffee
     * @param nSugarPackets number of sugar packets used
     * @param nCreams number of creams used 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups - 1 <= 0){
            if (this.nCoffeeOunces < size){
                restock(size,0,0,0);

            } 
            if (this.nSugarPackets < nSugarPackets){
                restock(0, nSugarPackets, 0, 0);

            } 
            if (this.nCreams < nCreams){
                restock(0,0,nCreams,0);
            } 
            if (this.nCups - 1 <= 0){
                restock(0,0,0,nCups);
            }
        } 
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
        
        System.out.println(("Amount of coffee ounces in inventory: " +this.nCoffeeOunces));
        System.out.println("Amount of sugar packets in inventory: " + this.nSugarPackets);
        System.out.println("Amount of cream in inventory: " + this.nCreams);
        System.out.println("Amount of cups in inventory: " + this.nCups);
        
    }

    /**
     * Overloaded method of sellCoffee that adds nCups as an input
     * @param size number of ounces of cup of coffee
     * @param nSugarPackets number of sugar packets used
     * @param nCreams number of creams used 
     * @param nCups number of cups of coffee used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < nCups){
            if (this.nCoffeeOunces < size){
                restock(size,0,0,0);

            } 
            if (this.nSugarPackets < nSugarPackets){
                restock(0, nSugarPackets, 0, 0);

            } 
            if (this.nCreams < nCreams){
                restock(0,0,nCreams,0);
            } 
            if (this.nCups < nCups){
                restock(0,0,0,nCups);
            }
        } 
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - nCups;
        
        System.out.println(("Amount of coffee ounces in inventory: " +this.nCoffeeOunces));
        System.out.println("Amount of sugar packets in inventory: " + this.nSugarPackets);
        System.out.println("Amount of cream in inventory: " + this.nCreams);
        System.out.println("Amount of cups in inventory: " + this.nCups);
    }

    /**
     * Restocks inventory when cafe is out of something
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (nCoffeeOunces > 0){ // if variable is 0 that means that it doesn't need to be restocked
            this.nCoffeeOunces = nCoffeeOunces + 50 ;
        } 
        if (nSugarPackets > 0){ 
            this.nSugarPackets = nSugarPackets + 50;
        } 
        if (nCreams > 0) {
            this.nCreams = nCreams;
        } 
        if (nCups > 0){
            this.nCups = nCups;
        }

    

    }

    /**
     * Overrided method of showOptions() that shows the options available for Cafe class
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("sellCoffee(n,n,n) \n + restock(n,n,n,n)");
    }

    /**
     * Overrided method for goToFloor()
     * @param floorNum floor to be moved to 
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum != -1) {
            throw new RuntimeException("Only one floor in Cafe");
        } else{
            System.out.println("You are now on floor # 1" + " of " + this.name);
            this.activeFloor = floorNum;
        }
    }
    /**
     * Main method 
     * @param args command line arguments passed into method
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("compass cafe", "1 chapin way", 2, 12, 10, 3, 4);
        Cafe campusCenter = new Cafe("Campus Center Cafe", "1 Chapin Way", 1);
        myCafe.sellCoffee(15, 3, 4);
        campusCenter.sellCoffee(15, 3, 4, 2);
    }
    
}
