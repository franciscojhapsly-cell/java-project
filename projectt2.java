
import java.util.Scanner;
public class projectt2{
    public static void main(String[] args) {
        Scanner j = new Scanner(System.in);
         double basePrice = 0.0;
        double sizeCharge = 0.0;
        double addonPrice = 0.0;
        double discount = 0.0;
        int extra = 0;
        String name = "";

        double totalprice = 0.0;
        System.out.println("======WELCOME TO JAVA CAFE======");
        System.out.println("Select Dirnk:");
        System.out.println("1. Espresso Drinl - 3.00 ");
        System.out.println("2. Cappuccino - 4.50 ");
        System.out.println("3. Latte - 4.00");
        System.out.println("4.Americano 3.50");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
        int choice = j.nextInt();
        switch (choice) {
            case 1:
                name = "Espresso Drink";
               basePrice = 3.0;
                break;
            case 2:
                basePrice = 4.50;
                 name = "Cappuccino";
                 break;
            case 3:
                basePrice = 4.00;
                name = "Latte";
                break;
            case 4:
                basePrice = 3.50;
              name = "Americano";
                break;
            case 5:
                System.out.println("Exit");
                 j.close();
                return;

              
            default:
                System.out.println("nothing else");
                break;
                
        } 
        System.out.print("Select size (Small/Medium/Large): ");
      String size = j.next().toLowerCase();
        if (size.equalsIgnoreCase("small")) {
            sizeCharge =    0.0;
           
        }
        else if (size.equalsIgnoreCase("medium")) {
            sizeCharge = 0.50;
            
        }
        else if (size.equalsIgnoreCase("large")) {
            sizeCharge = 1.0;
           
        }
        else {
            System.out.println("Invalid size selected.");
         
            return;
        }
       
        System.out.print("Do you want add-ons? (Yes/Noo): ");
        String add = j.next().toLowerCase();
       if (add.equalsIgnoreCase("Yes")) {
         System.out.println("Choose add-on:");
         System.out.println("1. Extra Shot (+$1.00)");
         System.out.println("2. Whipped Cream (+$0.50)");
         System.out.println("3. Caramel Syrup (+$0.75)");
         System.out.println("4. No add-on");
         System.out.print("Enter choice:");
         extra = j.nextInt();
        switch (extra) {
            case 1:
               addonPrice = 1.00;
                break;
             case 2:
                addonPrice = 0.50;
                break;
            case 3:
                addonPrice = 0.75;
                break;
            case 4:
             addonPrice = 0.00;
                break;
       }
        } else {
            System.out.println("No add-ons selected.");
        }
        System.out.print("Do you have a loyalty card? (Yes/Noo): " );
        String loyalty = j.next().toLowerCase();
        if (loyalty.equalsIgnoreCase("yes")) {
             discount = 0.10;
            totalprice -= discount;
        }
        else if (loyalty.equals("no")) {
             discount = 0.5;
            totalprice -=discount;
            
        }
         totalprice = basePrice + sizeCharge + addonPrice;
        System.out.println("\n======ORDER SUMMARY======");
        System.out.println("Drink: "+ choice);
        System.out.println("Size: " + size);
        System.out.println("Add-on: " + extra);
        System.out.println("\n--------------------------");
        System.out.println("Order Details:" + name);
        System.out.printf("Base Price: $%.2f\n", basePrice);
        System.out.printf("Size Charge: $%.2f\n", sizeCharge);
        System.out.printf("Add-on Price: $%.2f\n", addonPrice);
        System.out.printf("Total Price: $%.2f\n", totalprice);
        System.out.printf("Discount: $%.2f\n", discount);
        System.out.printf("Final Price: $%.2f\n", totalprice - discount);
        System.out.println("------------------------------");
        System.out.print("Thank you for visiting MANYAMAN BA????? TYPE: YESSSS / NOOOO:  ");
        String yes = j.next().toLowerCase();
        if (yes.equalsIgnoreCase("YESSSS")) {
            System.out.println("MAY FREE KISS KA SAAKIN");
        } else {
            System.out.println("SAPIKAN KITA EH");
            
        }
}
}