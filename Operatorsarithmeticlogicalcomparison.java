import java.util.Scanner;

public class Operatorsarithmeticlogicalcomparison {
    public static void main(String[] args) {
        Scanner j = new Scanner(System.in);
        
        System.out.println("===== SHOPPING CART CALCULATOR =========");
        System.out.print("Enter price of item 1: $");
        double item1 = j.nextDouble();
        System.out.print("Enter price of item 2: $");
        double item2 = j.nextDouble();
        System.out.print("Enter price of item 3: $");
        double item3 = j.nextDouble();
        
        System.out.print("\nAre you a member? (true/false): ");
        boolean member = j.nextBoolean();
        System.out.print("Is it weekend? (true/false): ");
        boolean weekend = j.nextBoolean();
        
       
        double subtotal = item1 + item2 + item3;
        
       
        double totalDiscountPercent = 0.0;
        double discountAmount = 0.0;
        int discountCount = 0;  
        
        System.out.println("\n=========== CALCULATION BREAKDOWN ===============");
        System.out.printf("Item 1: $%.2f%n", item1);
        System.out.printf("Item 2: $%.2f%n", item2);
        System.out.printf("Item 3: $%.2f%n", item3);
        System.out.println("---------------------------------------------------");
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        
        
        if (member && subtotal >= 100) {
            totalDiscountPercent += 0.15;
            discountCount++; 
            System.out.println("✓ Member discount applied: 15% off");
        }
        
        
        if (weekend || subtotal >= 200) {
            totalDiscountPercent += 0.05;
            discountCount++; 
            System.out.println("✓ Weekend/High purchase discount: 5% off");
        }
        
        
        if (member && weekend && subtotal >= 150) {
            totalDiscountPercent += 0.10;
            System.out.println("✓ Super saver discount: 10% off");
        }
        
        
        discountAmount = subtotal * totalDiscountPercent;
        
       
        double afterDiscount = subtotal - discountAmount;
        
        
        double tax = afterDiscount * 0.08;  
        
        
        double finalTotal = afterDiscount + tax;
        
       
        int loyaltyPoints = (int) (finalTotal / 10);
        
       
        System.out.println("\n========== DISCOUNT SUMMARY ==========");
        System.out.printf("Total Discount Applied: %.1f%%%n", totalDiscountPercent * 100);
        System.out.printf("Number of Discounts: %d%n", discountCount);
        System.out.printf("Discount Amount: -$%.2f%n", discountAmount);
        
        System.out.println("\n========== FINAL BILL ==========");
        System.out.printf("Subtotal:        $%.2f%n", subtotal);
        System.out.printf("Discount:        -$%.2f%n", discountAmount);
        System.out.printf("After Discount:  $%.2f%n", afterDiscount);
        System.out.printf("Tax (8%%):        +$%.2f%n", tax);
        System.out.println("---------------------------------------------------");
        System.out.printf("FINAL TOTAL:     $%.2f%n", finalTotal);
        System.out.printf("You Saved:       $%.2f%n", discountAmount);
        System.out.printf("Loyalty Points:  %d points%n", loyaltyPoints);
        
      
        if (discountAmount > 0) {
            System.out.println("\n🎉 Congratulations! You saved money today!");
        }
        
        if (!member && subtotal >= 50) {
            System.out.println("\n💡 Tip: Become a member to save even more!");
        }
        
        if (member && weekend && subtotal >= 150) {
            System.out.println("\n⭐ SUPER SAVER! You got all discounts!");
        }
        
        j.close();
    }
}