public class Resource{
  private String name;
  private int quantity;
  private float minetime;

  public Resource(String n, int q){
    name = n;
    quantity = q;
    minetime = 1.0f;
  }

  public Resource(String n, int q, float t)
  {
    name = n;
    quantity = q;
    minetime = t;
  }

  public String getName(){
    return name;
  }

  public int getQuantity(){
    return quantity;
  }

  public float getTime()
  {
    return minetime;
  }

  public void harvest(){
    quantity -= 1;

  }
  public void addTo(int amt)
  {
    quantity+=amt;
  }
}