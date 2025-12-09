import java.util.Scanner;
public class datatypeandvariable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======= Student Profile ========");
        System.out.print("Enter your First name: ");
        String name = sc.nextLine();
        System.out.print("Enter your Last name:" );
        String last = sc.nextLine();
        System.out.print("Enter Middle name: ");
        char mid = sc.next().charAt(0);
        System.out.print("Enter age: ");
        short age = sc.nextShort();
        System.out.print("Enter grade level: ");
        short g = sc.nextShort();
        System.out.print("Enter student ID: ");
        long id = sc.nextLong();
        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = sc.nextDouble();
        double ave  = gpa * 25;
        System.out.print("s student on honor roll? (true/false): ");
        boolean stu = sc.nextBoolean();
        
        System.out.println("\n======= Student Profile ========");

        System.err.println("NAME: "+ name + " "+  mid +"." +" " +last);
        System.out.println("AGE: "+ age);
        System.out.println("Grade: "+ g + "th");
        System.out.println("Student ID: "+ id);
        System.out.println("GPA :" + gpa +"("+ ave+"%"+")");
        if (stu) {
            System.out.println("Yes");
        }else{
            System.out.println("NO");
        }
        if (g<18) {
            int rem = 18 - g;
            System.out.println("you will be Gradated in " + rem + " years");
        }
        if (g>18 ) {
            System.out.println("you sinor Gradated");
        }
        
     
       


    }
}