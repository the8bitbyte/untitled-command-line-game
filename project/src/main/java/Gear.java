class Weapon {
  private String name;
  private int durrability;
  private int damage;

  public Weapon(String name, int durrability, int damage) {
    this.durrability = durrability;
    this.name = name;
    this.damage = damage;

  }

  public String toString() {
    return "This is " + this.name + ". It does " + this.damage + "damage and has " + this.durrability + "durribility";
  }

  static class Sword {
    private String name;
    private int durrability;
    private int damage;

    public Sword() {
      this.name = "degraded sword";
      this.durrability = 15;
      this.damage = 5;
    }
  }

  static class crossbow {
    private String name;
    private int durrability;
    private int damage;

    public crossbow() {
      this.name = "inaccurate crossbow";
      this.durrability = 5;
      this.damage = 2;
    }
  }

  static class axe {
    private String name;
    private int durrability;
    private int damage;

    public axe(){
      this.name = "old earth tomahawk";
      this.durrability = 3;
      this.damage = 4;
    }

  }
}

class MiningTool {
  // as durrability goes down so does the strength

  private String name;
  private int durrability;
  private int damage;
  private int mineTime;

  public MiningTool(String n, int dur, int mT){
    this.name = n;
    this.durrability = dur;
    this.mineTime = mT;
  }



}

class Vehicle{
  private String name;
  private int speed;

  public Vehicle(String name, int speed){
    this.name = name;
    this.speed = speed;
  }
}
