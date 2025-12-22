import java.util.Scanner;
public class project2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       double balance = 1000.0;
        System.out.print("Enter the pin: ");
        int  pin = sc.nextInt();
      
        if (pin == 1234) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money: ");       
            System.out.println("3. Withdraw Money: ");
            System.out.println("4. Exit: ");     

        }
        
        else {
            System.out.println("Invalid pin");
           return;
        }
          System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your current balance is: $" + balance);
                if (balance >=500) {
                    System.out.println(" Status: balance is Healty ");
                }
                break;
            case 2:
                System.out.print("Mount to deposit: ");
                double deposit = sc.nextDouble();
                balance += deposit;
                System.out.println("Deposit successful. New balance: $" + balance);
                break;
                case 3:
                    System.out.print("Enter Withdrawl amount:  ");
                    double Withdrawl = sc.nextDouble();
                    balance -= Withdrawl;
                    System.out.println("Withdrawl successful. New balance: $" + balance);
                break;
                case 4: 
                System.out.print("Exit");
                System.out.println("Thank you for using our ATM. Goodbye!");
        }
        

    }
}     