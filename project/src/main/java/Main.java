import java.util.Scanner;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.ArrayList;



public class Main {


  public static void printSymbol(int value) {
      String symbol;
      switch (value) {
          case 1:  symbol = "[\033[92m+\033[0m] "; break;
          case 2:  symbol = "[\033[94m?\033[0m] "; break;
          case 3:  symbol = "[\033[93m!\033[0m] "; break;
          case 4:  symbol = "[\033[31m-\033[0m] "; break;
          case 5:  symbol = "[\033[95m*\033[0m] "; break;
          default: symbol = "";    break;
      }
      System.out.print(symbol);
  }

  public static int validateIntInput(Scanner scan){

      int choice = 0;
      while (true){
        System.out.print("\u001b[s");
        System.out.print("\n\033[34m>\033[0m ");
        if(scan.hasNextInt()) {
           choice = scan.nextInt();
          break;
        }
        else{
          System.out.print("\u001b[u");
          System.out.print("\u001b[0J");
          System.out.print("\n\033[34m>\033[0m ");
          scan.nextLine();
          continue;
        }

      }
      System.out.println("\033[H\033[2J");
      System.out.flush(); 
      return choice;
    }

  public static void Clear()
  {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    CreateFile createSave = new CreateFile();
    createSave.create();
    Character player = createCharacter(scan);
    Clear();
    printSymbol(2);
      System.out.println("choose your starter\n- 1 - Sword\n- 2 - Axe\n- 3 - Crossbow");
    int weaponchoice = validateIntInput(scan);
    while (true)
      {
        if (weaponchoice < 4 && weaponchoice > 0)
        {
          break;
        }
        printSymbol(2);
        System.out.println("choose your starter\n- 1 - Sword\n- 2 - Axe\n- 3 - Crossbow");
        weaponchoice = validateIntInput(scan);
      }

    createWeapon(weaponchoice, player);

    // Scene testScene = new Scene("F ound a quarry");
    // System.out.println(testScene.getDescription());
    // presentOptions();
    // int choice = scan.nextInt();


    //showProgressBar(2.5f);

    Scanner input = new Scanner(System.in);


    event1(input, player);


  }

  public static void event1(Scanner input, Character player) {
      Scene quarryScene = new Scene("you approach a quarry, nobody is around. You can see a vein of stone that looks like it could be mined.", "quarry", "Stone", 10);
    quarryScene.addResource("Iron", 3, 2.5f);
    quarryScene.addResource("Bronze", 5, 3f);
      Scene forestScene = new Scene("you approach a dense forest. the trees block most sunlight leaving the path before you dark.", "Forest", "Wood", 18);
    forestScene.addResource("sticks", 6);
      while(true) {
        printSymbol(2);
        System.out.println("select location");
        System.out.println("- 1 - "+quarryScene.getTitle()+"\n"+
                           "- 2 - "+forestScene.getTitle()+"\n");
        int choice = validateIntInput(input);

        switch (choice) {
          case 1:
            quarryScene.sceneEvents(input, player);
            break;
          case 2:
            forestScene.sceneEvents(input, player);
            break;
          case 3:
            System.out.println("more text");
            break;
          default:
            continue;
        }
      }
  }

  public static void showProgressBar(float seconds) {
    int totalDuration = 100;  // total steps for 100%
    long sleepInterval = (long) (seconds * 1000 / totalDuration);  // ms per step

    for (int i = 0; i <= totalDuration; i++) {
        printProgressBar(i, totalDuration);
        try {
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("\nCompleted!\n\n");
}

private static void printProgressBar(int current, int total) {
    int progressWidth = 20;
    int progress = (int) ((double) current / total * progressWidth);
    StringBuilder bar = new StringBuilder();

    bar.append("\r");
    for (int j = 0; j < progressWidth; j++) {
        if (j < progress) {
            bar.append("\033[92m━\033[0m"); // filler
        } else {
            bar.append("\033[90m─\033[0m"); // empty
        }
    }
    bar.append(" | ").append((int) ((double) current / total * 100)).append("%");
    System.out.print("\033[H\033[2J");
    System.out.print(bar.toString());
}



  public static void createWeapon(int choice, Character p) {
    while (true) {
      switch (choice) {
        case 1:
          Weapon mySword = new Weapon("Sword", 5, 100);
          p.updateWeapon(mySword);
          System.out.print("\033[H\033[2J");
          printSymbol(1);
          System.out.print("You found a Sword\n\n");
          break;

        case 2:
          Weapon myAxe = new Weapon("Axe", 10, 200);
          System.out.print("\033[H\033[2J");
          p.updateWeapon(myAxe);
          printSymbol(1);
          System.out.print("You found an Axe\n\n");
          //System.out.print("you found the thing from the loaraxe that start oh noes");
          break;
        case 3:
          Weapon myBow = new Weapon("Bow", 3, 150);
          System.out.print("\033[H\033[2J");
          p.updateWeapon(myBow);
          printSymbol(1);
          System.out.println("You found a Bow\n\n");
          //System.out.print("ah yes you have found special bow this is a very myical bow used back with old paps tho paps was mean he is pap it was passed down with gernation gernation old paps found drangon with that one it has be cursed by the spirt of the drango it has -50 damage -100000 defense to host oh yeah i forgot to metion this bow is diease in way once in conact it will croase its roots in to you affect your biological proceeswss it 5g fiber opical tracking where it will always know where you are and will appy siad procesewws + 10 health point to all surronding eminies and eminies ONLY not FRIENDLY at least not local mmm old paps loved old dinner but the fast food owner cursed his food which makes it poisonisi to all ");
          break;

        default:
          System.out.print("\033[H\033[2J");
          System.out.print("Enter a valid choice");

      }
      break;
    }

  }

  public static Character createCharacter(Scanner scan) {
    printSymbol(2);
    System.out.println("What is your character's name? ");
    String inputName = scan.nextLine();
    return new Character(inputName);
  }

  public static void presentOptions() {
    System.out.println("What would you like to do?");
    System.out.println("1. Check Inventory\n2. Move Elsewhere\n3. Mine a resource\n4. Check for items");
    System.out.print("Please enter a number input:");
  }

}

class Character {
  private String name;
  private int MaxHealth;
  private int Health;
  private int Money;
  private Weapon weapon;
  private MiningTool mine;
  private Vehicle vehicle;
  private ArrayList<Resource> inventory = new ArrayList<Resource>();

  public static int validateIntInput(Scanner scan){
  System.out.print("\u001b[s");
  System.out.print("\n\033[34m>\033[0m ");
    int choice = 0;
    while (true){
      if(scan.hasNextInt()) {
         choice = scan.nextInt();
        break;
      }
      else{
        System.out.print("\u001b[u");
        System.out.print("\u001b[0J");
        System.out.print("\n\033[34m>\033[0m ");
        scan.nextLine();
        continue;
      }

    }
    System.out.println("\033[H\033[2J");
    System.out.flush();
    return choice;
  }

  public Character(String n) {
    this.weapon = new Weapon("my weapon", 0, 0);
    this.mine = new MiningTool("my mine", 0, 0);
    this.vehicle = new Vehicle("Car", 0);
    this.name = n;
    this.MaxHealth = 100;
    this.Health = MaxHealth;
    this.Money = 0;
    ArrayList<Resource> inventory = new ArrayList<Resource>();
  }

  public void updateWeapon(Weapon s) {
    this.weapon = s;
  }

  public void updateMiningTool(MiningTool m) {
    this.mine = m;
  }

  public void updateVehicle(Vehicle v) {
    this.vehicle = v;
  }

  public String getInventory()
  {
    String output = "Inventory\n";
    if (inventory.isEmpty())
    {
      output = "< Empty >";
    }
    else
    {
      for (int i=0; i<inventory.size(); i++)
        {
          output+= (i+1) + ". " + inventory.get(i).getName() + ": " + inventory.get(i).getQuantity() + "\n";
        }
    }
    return output;
  }
  public void addToInv(Resource r){
  boolean addToExisting = false;

    for (int i = 0; i < inventory.size(); i++)
      {
        if (inventory.get(i).getName().equals(r.getName()))
        {
          inventory.get(i).addTo(r.getQuantity());
          addToExisting = true;

        }
      }
    if (!addToExisting)
    {
      inventory.add(r);
    }

    public String saveInventory(){
      String output = "";
      for (int i = 0; i <= inventory.size(); i++)
      {
        output += inventory.get(i).getName() + ":" + inventory.get(i).getQuantity();
      }
      return output;
    }
  }

  // //TODO: Change argument to more generic type later on!
  // public void addSword(Weapon s) {
  // inventory.add(s);
  // }

  public String toString1() {
    return ("Name: " + this.name + "\nHealth: " + this.Health + "/" + this.MaxHealth + "\nMoney: " + this.Money);
  }

  public String formatSaveString()
  {
    /*
    SAVE DATA ORDER:
    1. Player Name
    2. Max Health
    3. Current Health
    4. Money
    5. Weapon Data
    6. Mining Tool Data
    */
    String output = "";
    output += this.name + "|";
    output += this.MaxHealth + "|";
    output += this.Health + "|";
    output += this.Money + "|";
    output += this.weapon.saveData() + "|";
    output += this.mine.saveData() + "|";
  }

}