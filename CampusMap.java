import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        Cafe compass = new Cafe("Compass Cafe", "7 Elm Street", 1, 300, 200, 200, 200);
        compass.sellCoffee(12, 3, 2, 1);
        myMap.addBuilding(compass);
        Cafe campusCenterCafe = new Cafe("Campus Center Cafe", "1 Chapin Way", 1);
        campusCenterCafe.sellCoffee(10, 2, 3);
        myMap.addBuilding(campusCenterCafe);
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive", 3, true));
        myMap.addBuilding(new Library("Alumni Gym", "83 Green St", 3));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 Lower College Ln"));
        myMap.addBuilding(new House("Haynes House", "1 Mandelle Rd", 4, true, true));
        myMap.addBuilding(new House("Jordan House", "1 Paradise Rd", 4));
        myMap.addBuilding(new House("Emerson House", "1 Paradise Rd", 4, true));
        myMap.addBuilding(new Library("Hillyer Library", "22 Elm St"));
        myMap.addBuilding(new Building("Botanic Garden", "16 College Ln"));
    
        System.out.println(myMap);
    }
    
}
