import java.util.ArrayList;
import java.util.Scanner;
public class Scene{
  private String description;
  private String title;
  private ArrayList<Resource> resources =  new ArrayList<Resource>();

  public Scene(String d, String t, String r, int q){
    description = d;
    title = t;
    Resource res = new Resource(r, q);
    resources.add(res);
  }

  public String getTitle(){
    return title;
  }

  public String getDescription(){
    return description;
  }

  public String getResources(){
    String output = "";
    for (int i=0; i<resources.size(); i++)
      {
        output+= "- " + (i+1) + " - " + resources.get(i).getName() + ": " + resources.get(i).getQuantity() + "\n";
      }
    return output;

  
  }
  public void addResource(String r, int q)
  {
    Resource res = new Resource(r, q);
    resources.add(res);
  }
  public void addResource(String r, int q, float t)
    {
      Resource res = new Resource(r, q, t);
      resources.add(res);
    }
  public Resource harvestResource(int index)
  {
    index -= 1;
    resources.get(index).harvest();
    return new Resource(resources.get(index).getName(),1);
  }
  public void sceneEvents(Scanner scan, Character player)
  {
    Main.printSymbol(1);
    System.out.println(getDescription());
    while (true){
    presentOptions();
    int choice = player.validateIntInput(scan);
    switch(choice)
      {
        case 1:
          Main.printSymbol(1);
          System.out.println(player.getInventory());
          continue;
        case 2:
          break;
        case 3:
          Main.printSymbol(1);
          System.out.println("you see the following resources \n" + getResources());
          Main.printSymbol(2);
          System.out.println("What resource would you like to harvest?");
          int resChoice = player.validateIntInput(scan);
          System.out.print("\n\033[34m>\033[0m ");
          if (resources.get(resChoice-1).getQuantity()<1)
          {
            Main.printSymbol(3);
            System.out.println("that resource has already been used up");
          }
          else
          {
            Main.showProgressBar(resources.get(resChoice-1).getTime());
            player.addToInv(harvestResource((resChoice)));
            Main.printSymbol(1);
            System.out.println(player.getInventory());
            Main.printSymbol(2);
            while (resources.get(resChoice-1).getQuantity() > 0)
            {
              System.out.println("there is " + resources.get(resChoice-1).getQuantity() + " " + resources.get(resChoice-1).getName() + " left, mine another? (y/n)");
              String mineAgain = scan.nextLine();
              if (mineAgain.equalsIgnoreCase("y"))
              {
                Main.showProgressBar(resources.get(resChoice-1).getTime());
                player.addToInv(harvestResource((resChoice)));
              }
              else
              {
                System.out.println(mineAgain + "test");
              }
            }
          }
          continue;
      }
      break;
    }
  }
  public static void presentOptions(){
    System.out.println("\n");
    Main.printSymbol(2);
    System.out.println("What would you like to do?");
    System.out.println("- 1 - Check Inventory\n- 2 - Move Elsewhere\n- 3 - Mine a resource\n- 4 - Check for items");
    System.out.print("\n\033[34m>\033[0m ");
  }
  }
