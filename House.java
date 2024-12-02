/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean elevator;

 
  /**
   * Overloaded Constructor setting hasDiningRoom and elevator to false by default
   * @param name
   * @param address
   * @param nFloors
   */
  public House(String name, String address, int nFloors){
    this(name, address, nFloors, false, false); // sets hasDiningRoom and elevator both to false to have deafult values as false
  }

  /**
   * Overloaded Constructor setting elevator to false by default
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom){
    this(name, address, nFloors, hasDiningRoom, false); // sets hasDiningRoom and elevator both to false to have deafult values as false
  }

  /**
   * Full Constructor
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
    System.out.println("You have built a house: 🏠");
  }


  /**
   * Getter for hasDiningRoom
   * @return boolean for whether or not house has dining room or not
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;

  }

  /**
   * Getter for number of residents in house
   * @return int of size of array list of residents
   */
  public int nResidents(){
    return residents.size();

  }

  /**
   * Adds name to list of people in house as long as name isn't already in house
   * @param name name of person
   */
  public void moveIn(String name){
    if (isResident(name)){
      throw new RuntimeException("Person is already in house");
    } else{
      residents.add(name);
    }
  }

  /**
   * Removes someone from house and from the array list of residents or prints out an error if that person is not in house
   * @param name name inputted
   * @return name inputted
   */
  public String moveOut(String name){
    if (isResident(name) == true){
      residents.remove(name);
      return name;
    } else{
      throw new RuntimeException("Resident is not in house.");
    }
    

  }

  /**
   * Checks whether or not the person is a resident of the house
   * @param person name inputted
   * @return boolean based on whether person is either in house or not
   */
  public boolean isResident(String person){
     return residents.contains(person);
    }

  /**
     * Overrided method of showOptions() that shows the options available for House class
     */
  public void showOptions() {
    super.showOptions();
    System.out.println("hasDiningRoom() \n + nResidents() \n + moveIn(x) \n + moveOut(x) + \n + isResident(x)");
  }


  /**
   * Overrided method of goToFloor() that allows moving betwen multiple floors as long as there is an elevator
   * @param floorNum floor to be moved to 
   */
  public void goToFloor(int floorNum) {
    int absfloorNum = Math.abs(floorNum);
    int absactiveFloor = Math.abs(this.activeFloor);
    if (this.activeFloor == -1){
      throw new RuntimeException("You are not in the building");
    } else if (elevator){
      super.goToFloor(floorNum);
    } else if (absfloorNum - absactiveFloor == 1){
      super.goToFloor(floorNum);
    } else {
      throw new RuntimeException("You need to go up or down multiple floors and this building does not have an elevator so you need to use the goUp() and goDown() methods");
    }
  }

  /**
     * Main method 
     * @param args command line arguments passed into method
     */
  public static void main(String[] args) {
    House myHouse = new House("Haynes", "1 Mandelle Road", 4);
    System.out.println(myHouse.hasDiningRoom());
  
    
  }

}