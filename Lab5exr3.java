abstract class Cake{
   String name;
   String[] topping = new String[10];
   String[] toppingOrder = new String[10];
   double priceSmall; 
   double priceMedium; 
   double priceBig; 
   double totalPrice;
   int size, quant;

   Cake(String name){
      this.name = name;
   }

   abstract void setCake
   (String[] topping, double priceSmall, double priceMedium, double priceBig);

   void orderCake(String[] toppingOrder, int quant, int size){
      this.toppingOrder = toppingOrder;
      this.quant = quant;
      this.size = size;
   }
   double getSizePrice(){
      if(size == 1) return priceSmall;
      else if(size == 2) return priceMedium;
      else return priceBig;                        
   }
   
   double getTotalPrice(){
      totalPrice = getSizePrice()*quant + (toppingOrder.length*10);
      return totalPrice;
   }

   String getSize(){
      if(size == 1) return "SMALL";
      else if(size == 2) return "MEDIUM";
      else return "BIG";  
   }

   void printCake(){
      System.out.println("--------------------------------");
      System.out.println("           CAKE MENU      ");
      System.out.println("--------------------------------");
      System.out.println(name + " CAKE WITH AVAILABLE TOPPINGS: ");
      for(int i=0; i<topping.length; i++){
         System.out.println((i+1)+ ") " + topping[i]);   
      }
      System.out.println("\nPrice: ");
      System.out.println("[1] SMALL  : " + priceSmall);
      System.out.println("[2] MEDIUM : " + priceMedium);
      System.out.println("[3] BIG    : " + priceBig); 
   }
   
   void printOrder(){
      System.out.println("\n\nCake Order details: ");
      System.out.println("-------------------------------");
      System.out.print("Topping: ");
      for(int i=0; i<toppingOrder.length; i++){
            System.out.print((i+1)+ ") " + toppingOrder[i] + " ");   
         }
      System.out.println("\nSize: " + getSize());
      System.out.println("-------------------------------");
      System.out.println("TOTAL PRICE: RM " + getTotalPrice());
      System.out.println("-------------------------------");      
   }
}
class BlackForest extends Cake{
   BlackForest(String name){
      super(name);
   }

   void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig){
      this.topping = topping;
      this.priceSmall = priceSmall;
      this.priceMedium = priceMedium;
      this.priceBig = priceBig;
   }
}

public class Lab5exr3{
    public static void main(String args[]){
       Cake c = new BlackForest("BLACKFOREST");
       String[] topping = {"CHOCOLATE", "CHERRIES", "WHIPPED CREAM"};
       c.setCake(topping, 45.00, 65.00, 80.00);
       c.printCake();
      
       String[] order = {"CHOCOLATE", "CHERRIES"};
       c.orderCake(order, 1, 2);
       c.printOrder();
    }
}
