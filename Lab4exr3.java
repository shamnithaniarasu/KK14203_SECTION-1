import java.util.Scanner;


class Menu{
 String item;
 double price;

    public Menu(String item,double price){
    this.item = item;
    this.price = price;
    }

    public double getPrice(){
    return price;
    }

    public void printItem(){
    System.out.println("\t" + item);
    System.out.print("\tPrice: ");

    }
}

public class Lab4exr3{

public static void main(String args[]){
String item;
double price;
int qty;
double sum=0;

Scanner scan = new Scanner(System.in);
System.out.println("Menu: ");
System.out.println("------------------------------------------------");
System.out.println("[1] Nasi Lemak [RM2.00]");
System.out.println("[2] Roti [RM1.00]");
System.out.println("[3] Teh Tarik [RM1.50]");
System.out.println("[4] Kopi O [RM2.00]");
System.out.println("------------------------------------------------");
System.out.println("Place order [1-4] or type q to quit");


do{
System.out.print("Add order: ");
item = scan.next();

String[] qwer = {"Nasi Lemak", "Roti", "Teh Tarik", "Kopi O"};
double[] asdf = {2.0, 1.0, 1.5, 2.0};                                         
                                                                                               
Menu[] menu = new Menu[4];                                                
    for (int i = 0; i < 4; i++) {                                                    
       menu[i] = new Menu(qwer[i], asdf[i]);                            
    }

  switch(item.charAt(0)){
      case '1':
      System.out.print("Nasi Lemak - Quantity: ");
      qty = scan.nextInt();
      menu[0].printItem();
      sum += (menu[0].getPrice() * qty);
      System.out.println(menu[0].getPrice() * qty);
      break;

       case '2':
       System.out.print("Roti - Quantity: ");
       qty = scan.nextInt();
       menu[1].printItem();
       sum += (menu[1].getPrice() * qty);
       System.out.println(menu[1].getPrice() * qty);
       break;

       case '3':
       System.out.print("Teh Tarik - Quantity: ");
       qty = scan.nextInt();
       menu[2].printItem();
       sum += (menu[2].getPrice() * qty);
       System.out.println(menu[2].getPrice() * qty);
       break;

       case '4':
       System.out.print("Kopi O - Quantity: ");
       qty = scan.nextInt();
       menu[3].printItem();
       sum += (menu[3].getPrice() * qty);
       System.out.println(menu[3].getPrice() * qty);
       break;

        case 'q':
        System.out.println("Thank you for your order ^-^ ");
        break;

       default:
        break;

       }

       }while(item.charAt(0) != 'q');

     System.out.println("Total due: RM" + sum);
  }

}